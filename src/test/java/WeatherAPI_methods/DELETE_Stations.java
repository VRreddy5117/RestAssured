package WeatherAPI_methods;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DELETE_Stations {
        @Test
        public void deleteEntry() {

            RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";

            Response response = null;

            try {
                response = RestAssured.given()
                        .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                        .contentType(ContentType.JSON)
                        .delete("/stations/5e9ec923cca8ce0001f1ab79");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());

        }


    }

