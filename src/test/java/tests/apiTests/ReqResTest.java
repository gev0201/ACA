package tests.apiTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTest {

    @Test
    public void registerUser(){
        String baseUrl = "https://reqres.in/";
        String endpoint = "/api/register";
        String reqJson= """
                {
                    "email": "eve.holt@reqres.in",
                    "password": "pistol"
                }
                """;
        given().baseUri(baseUrl).contentType("Application/Json").
                body(reqJson).
        when().post(endpoint).
        then().assertThat().statusCode(200).
        body("id", equalTo(5));



    }

}
