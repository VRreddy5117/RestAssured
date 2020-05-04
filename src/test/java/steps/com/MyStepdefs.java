package steps.com;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;


public class MyStepdefs {


    JSONObject jsonObject;


    @Given("^send dummy get API$")
    public void read_a_get_api_file() throws Throwable {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/kurnool");


        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

    }

    @Then("^Get all key Value pairs$")
    public void get_all_key_Value_pairs() throws Throwable {

    }

    @Given("^POST request API$")
    public void postRequestAPI() {

        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "venkat"); // Cast
        requestParams.put("LastName", "reddy");
        requestParams.put("UserName", "VRReddy");
        requestParams.put("Password", "restAssured");

        requestParams.put("Email",  "ramana@gmail.com");
        request.body(requestParams.toJSONString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, "201");
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
    }

    @Given("^DELETE request API$")
    public void deleteRequestAPI() {

        int empid = 16486;

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Response response = request.delete("/delete/"+ empid);

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        org.testng.Assert.assertEquals(statusCode, 200);

        String jsonString =response.asString();
        org.testng.Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
    }

    @Given("^Create get request$")
    public void createGetRequest() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/Kurnool");


        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

    }

    @Given("^send dummy  url$")
    public void sendDummyUrl() {

        int empid = 15410;

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Zion"); // Cast
        requestParams.put("age", 23);
        requestParams.put("salary", 12000);

        request.body(requestParams.toJSONString());
        Response response = request.put("/update/" + empid);

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        org.testng.Assert.assertEquals(statusCode, 200);
    }

    @Given("^send dummy  post url$")
    public void sendDummyPostUrl() {

        RestAssured.baseURI ="  http://restapi.demoqa.com/customer/register/n";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender");
        requestParams.put("LastName", "Singh");
        requestParams.put("UserName", "sdimpleuser2dd2011");
        requestParams.put("Password", "password1");

        requestParams.put("Email",  "sample2ee26d9@gmail.com");
        request.body(requestParams.toJSONString());
        Response response = request.post("/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, "201");
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
    }

    public static class GETData {

        @Test
        public void TestGETData() {
            Response Resp = RestAssured.get("https://samples.openweathermap.org/data/3.0/measurements" +
                    "?station_id=816a&type=h&limit=100&appid=8d210e35e278338658ea419462e7490d");

            int code = Resp.getStatusCode();
            System.out.println("status code is " +code);
            org.testng.Assert.assertEquals(code, 200);
        }
    }
}
