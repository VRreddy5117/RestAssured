package WeatherAPI_methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class PUT_Stations {

        @Test
        public static void putmethod() {

            RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";

           /* String requestBody = "{\n" +
                    "  \"station_id\": \"2ae8a8fd5123dab7c63b3901f2a81bb3\",\n" +
                    "  \"dt\": \"1479817340\",\n" +
                    "  \"temperature\": \12.7,\n" +
                    "  \"wind_speed\": \1.2,\n" +
                    "  \"wind_gust\": \3.4,\n" +
                    "  \"pressure\": \"1201\",\n" +
                    "  \"humidity\": \"87\",\n" +
                    "  \"rain_1h\": \"2\"\n" +
                    "}";*/

            JSONObject requestParams = new JSONObject();
            requestParams.put("external_id","1004");
            requestParams.put("name","ramana2");
            requestParams.put("latitude",69);
            requestParams.put("longitude",160);
            requestParams.put("altitude",120);

            Response response = null;

            try {
                response = RestAssured.given()
                        .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                        .contentType(ContentType.JSON)
                        .body(requestParams.toJSONString())
                        .put("/stations/5e9e6c8ecca8ce0001f1ab69");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());
            assertEquals(200, response.getStatusCode());
        }


    }


