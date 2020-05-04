package JSONReadingHTTPMethods;

import WeatherAPI_methods.PropertiesClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class PostManMethods {
    static String station_id = " ";
    protected static Properties prop = null;

    static {
        try {
            prop = PropertiesClass.loader_properties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void CreateNewEntry() {
        RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";

        Response postresponse = null;
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("src/main/resources/ConfigureProperties/CreateJSON_file.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String external_id = Random_numberGenerator.radomNumber();
            System.out.println(external_id);

            jsonObject.remove("external_id");
            jsonObject.put("external_id", external_id);

            System.out.println("JSON Response :: " + jsonObject);
            try {

                postresponse = RestAssured.given()
                        .when().queryParam("appid", prop.getProperty("APP_ID"))
                        .contentType(ContentType.JSON)
                        .body(jsonObject.toString())
                        .post("/stations");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Response response = postresponse;
            String str = response.getBody().asString();
            System.out.println(str);

            org.json.JSONObject result = new org.json.JSONObject(str);
            station_id = result.getString("ID");
            System.out.println(result.getString("ID"));
            System.out.println("Response :" + postresponse.asString());
            System.out.println("Status Code :" + postresponse.getStatusCode());
            assertEquals(201, postresponse.getStatusCode());


            Assert.assertEquals(60,result.get("latitude")); //
            Assert.assertNotEquals(50,result.get("latitude"));
            Assert.assertTrue(result.get("latitude").equals(60),"yes it is true");
            Assert.assertTrue(result.get("longitude").equals(128));
            Assert.assertFalse(true);


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Test
    public static void getweatherstations() {
        Response getresponse = null;

        RestAssured.baseURI = prop.getProperty("URI");

        System.out.println(station_id + "- I am your new station ID/updated ID");


        try {
            getresponse = RestAssured.given()
                    .when().queryParam("appid", prop.getProperty("APP_ID"))
                    .get("/stations/" + station_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.json.JSONObject result = new org.json.JSONObject(getresponse.asString());
        station_id = result.getString("id");
        System.out.println(result.getString("id"));
        System.out.println("Response :" + getresponse.asString());
        System.out.println("Status Code :" + getresponse.getStatusCode());
        assertEquals(200, getresponse.getStatusCode());

    }

    @Test
    public static void putmethod() throws IOException, ParseException {

        RestAssured.baseURI = prop.getProperty("URI");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/resources/ConfigureProperties/UpdateJson_file.json"));

        JSONObject jsonObject = (JSONObject) obj;
        Response putresponse = null;

        try {
            putresponse = RestAssured.given()
                    .when().queryParam("appid", prop.getProperty("APP_ID"))
                    .contentType(ContentType.JSON)
                    .body(jsonObject.toJSONString())
                    .put("/stations/" + station_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.json.JSONObject result = new org.json.JSONObject(putresponse.asString());
        station_id = result.getString("id");
        System.out.println(result.getString("id"));
        System.out.println("Response :" + putresponse.asString());
        System.out.println("Status Code :" + putresponse.getStatusCode());
        assertEquals(200, putresponse.getStatusCode());

        getweatherstations();
        System.out.println(result.getString("name"));
        assertEquals("cadapa", result.getString("name"));


    }

}



