package EmployeeAPI;



import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class GET_HTTPMethod {

        @Test
        public void getweatherstations() {

            RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

            Response response = null;

            try {
                response = RestAssured.given()
                        .when()
                        .get("/employees");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());
            assertEquals(200, response.getStatusCode());
        }
    }



