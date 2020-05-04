package WeatherAPI_methods;


//import org.json.simple.JSONObject;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ManageStation {
    static String station_id = " ";
    //  static Response response = null;


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

        Response postresponse = null;

        RestAssured.baseURI = prop.getProperty("URI");

        JSONObject requestParams = new JSONObject();
        requestParams.put("external_id", "12990");
        requestParams.put("name", "thuni");
        requestParams.put("latitude", 60);
        requestParams.put("longitude", 128);
        requestParams.put("altitude", 120);


        //request.body(requestParams.toJSONString());
        try {
            postresponse = RestAssured.given()
                    .when().queryParam("appid", prop.getProperty("APP_ID"))
                    .contentType(ContentType.JSON)
                    .body(requestParams.toString())
                    .post("/stations");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject result = new JSONObject(postresponse.asString());
        station_id = result.getString("ID");
        System.out.println(result.getString("ID"));
        System.out.println("Response :" + postresponse.asString());
        System.out.println("Status Code :" + postresponse.getStatusCode());
        assertEquals(201, postresponse.getStatusCode());

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
        JSONObject result = new JSONObject(getresponse.asString());
        station_id = result.getString("id");
        System.out.println(result.getString("id"));
        System.out.println("Response :" + getresponse.asString());
        System.out.println("Status Code :" + getresponse.getStatusCode());
        assertEquals(200, getresponse.getStatusCode());

    }


    @Test
    public static void putmethod() {

        RestAssured.baseURI = prop.getProperty("URI");


        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("external_id", "1004");
        requestParams.put("name", "ramana2");
        requestParams.put("latitude", 69);
        requestParams.put("longitude", 160);
        requestParams.put("altitude", 120);

        Response putresponse = null;

        try {
            putresponse = RestAssured.given()
                    .when().queryParam("appid", prop.getProperty("APP_ID"))
                    .contentType(ContentType.JSON)
                    .body(requestParams.toJSONString())
                    .put("/stations/" + station_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject result = new JSONObject(putresponse.asString());
        station_id = result.getString("id");
        System.out.println(result.getString("id"));
        System.out.println("Response :" + putresponse.asString());
        System.out.println("Status Code :" + putresponse.getStatusCode());
        assertEquals(200, putresponse.getStatusCode());

        getweatherstations();
        System.out.println(result.getString("name"));
        assertEquals("ramana2", result.getString("name"));
    }

    @Test
    public void deleteEntry() {

        RestAssured.baseURI = prop.getProperty("URI");

        Response deleteresponse = null;

        try {
            deleteresponse = RestAssured.given()
                    .when().queryParam("appid", prop.getProperty("APP_ID"))
                    .contentType(ContentType.JSON)
                    .delete("/stations/" + station_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  JSONObject result = new JSONObject(deleteresponse.asString());
        System.out.println("Response :" + deleteresponse.asString());
        System.out.println("Status Code :" + deleteresponse.getStatusCode());

        getweatherstations();
        //  assertEquals("ramana2", result.getString("name"));
        assertEquals(404, deleteresponse.getStatusCode());

    }
}

