package WeatherAPI_methods;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class GET_stations {

        @Test
        public void getweatherstations() {

            //RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/";
            RestAssured.baseURI = "https://api.openweathermap.org/data/3.0/";

            Response response = null;

            try {
                response = RestAssured.given()
                        .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                        .get("/stations");

                       // .get("/weather?q=Hyderabad,ind&");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());
            assertEquals(200, response.getStatusCode());
        }

    @Test
    public void getUserDetailStatusCode () {

            RestAssured.baseURI = "https://api.openweathermap.org/data/3.0/";
        RestAssured.given()
                .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                .get("/stations")
                .then()
                .assertThat().log()
                .all()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .header("Connection","keep-alive");

       // assertEquals(200, .getUserDetailStatusCode());

    }

    }



