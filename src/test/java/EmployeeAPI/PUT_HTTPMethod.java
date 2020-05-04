package EmployeeAPI;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PUT_HTTPMethod {

        @Test
        public void UpdateEntry() {

            RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

            String requestBody = "{\r\n" +
                    " \"name\":\"Kumar\",\r\n" +
                    " \"salary\":\"20000\",\r\n" +
                    " \"age\":\"28\"\r\n" +
                    "}";


            Response response = null;

            try {
                response = RestAssured.given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .put("/update/23470");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());
            System.out.println("Does Reponse contains 'kumar'? :" + response.asString().contains("kumar"));


            assertEquals(200, response.getStatusCode());
        }
    }

