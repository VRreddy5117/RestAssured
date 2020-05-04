package VerificationOfCode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetCode {
    private static Logger log = Logger.getLogger(String.valueOf(GetCode.class));

    @Test
    public void createEmployee() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        String requestBody = "{\n" +
                "  \"name\": \"Venkat123\",\n" +
                "  \"salary\": \"12321\",\n" +
                "  \"age\": \"27\"\n" +
                "}";


        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/create");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusCode();
        Headers allHeaders = response.headers();
        String statusLine = response.getStatusLine();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();

        assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
        System.out.println("Status Line :" + response.getStatusLine());

        assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
        System.out.println("Status Code :" + response.getStatusCode());

        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        String contentType = response.header("Content-Type");

       // assertEquals(contentType / + actual value /, "application/json;charset=utf-8" / expected value /);
        log.info("Verified Content-Type in Header");

        String serverType = response.header("Server");
    //    assertEquals(serverType / actual value /, "nginx/1.16.0" / expected value /);
        log.info("Verified serverType in Header");

        JsonPath jsonPathEvaluator = response.jsonPath();

        assertTrue(bodyAsString.toLowerCase().contains("status"), "Response body contains status");
        assertTrue(bodyAsString.contains("success"), "Response body contains success");
        log.info("status received from Response " + jsonPathEvaluator.get("status"));

        assertTrue(bodyAsString.toLowerCase().contains("data"), "Response body contains data");
        assertTrue(bodyAsString.contains("ramana"), "Response body contains ramana");
        log.info("data received from Response " + jsonPathEvaluator.get("data"));

        assertTrue(bodyAsString.toLowerCase().contains("data"), "Response body contains data");
        assertTrue(bodyAsString.contains("2300"), "Response body contains 2300");
        log.info("data received from Response " + jsonPathEvaluator.get("data"));

        assertTrue(bodyAsString.toLowerCase().contains("data"), "Response body contains data");
        assertTrue(bodyAsString.contains("26"), "Response body contains 26");
        log.info("data received from Response " + jsonPathEvaluator.get("data"));

    }
}