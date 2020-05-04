package JSONReadingHTTPMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GetMethod {

    @Test
    public void getmethod () throws FileNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/ConfigureProperties/CreateJSON_file.json"));
        RestAssured.baseURI = "https://api.openweathermap.org/data/3.0/";


        try {
            Response postresponse = RestAssured.given()
                    .when().queryParam("appid", "8d210e35e278338658ea419462e7490d")
                    .contentType(ContentType.JSON)
                   // .body(IOUtils.)
                    .post("/stations");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
