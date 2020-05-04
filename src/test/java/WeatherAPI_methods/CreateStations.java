package WeatherAPI_methods;

//import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import java.util.Properties;
import static org.junit.Assert.assertEquals;

public class CreateStations {
    static String station_id = " ";

    @Test
    public void CreateNewEntry() {

        Response postresponse = null;

        RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";
       // RestAssured.baseURI = prop.getProperty("URI");

        JSONObject requestParams = new JSONObject();
        requestParams.put("external_id", "1002");
        requestParams.put("name", "ramana");
        requestParams.put("latitude", 79);
        requestParams.put("longitude", 170);
        requestParams.put("altitude", 120);
        System.out.println(requestParams);

        //request.body(requestParams.toJSONString());
        try {
            postresponse = RestAssured.given()
                    .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                    .contentType(ContentType.JSON)
                    .body(requestParams.toString())
                    .post("/stations");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject result = new JSONObject(postresponse.toString());
        station_id = result.getString("ID");
        System.out.println(result.getString("ID"));
        System.out.println("Response :" + postresponse.asString());
        System.out.println("Status Code :" + postresponse.getStatusCode());
        assertEquals(201, postresponse.getStatusCode());

    }

    @Test
    public void postUserDetailStatusCode () {

        RestAssured.baseURI = "https://api.openweathermap.org/data/3.0/";
        RestAssured.given()
                .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                .post("/stations")
                .then()
                .assertThat().log()
                .all()
                .statusCode(201)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("Connection","keep-alive");

        // assertEquals(200, .getUserDetailStatusCode());

    }

}

