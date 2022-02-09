package tests.apiTests;


import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {

    @Test
    public void blacklistHeaderTest() {
        Response
                responsejson = given().
                baseUri("https://api.postman.com")
                .header("X-Api-Key",
                        "PMAK-61b7629c2e987400527bb771-499f84ebc4d691aed909af7ce8a66f1452").

                config(config.logConfig(LogConfig.logConfig().blacklistHeader("X-Api-Key"))).
                log().all().
                when().
                get("/workspaces").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(200).
                extract().response();
        assertThat(responsejson.path("workspaces[0].name"), equalTo("reqRes"));

    }


    @Test
    public void blacklistHeadersTest() {
        Set<String> headers = new HashSet<>();
        headers.add("X-Api-Key");
        headers.add("Accept");

        Response
                responsejson = given().
                baseUri("https://api.postman.com")
                .header("X-Api-Key",
                        "PMAK-61b7629c2e987400527bb771-499f84ebc4d691aed909af7ce8a66f1452").
                config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers))).
                log().all().
                when().
                get("/workspaces").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(200).
                extract().response();
        assertThat(responsejson.path("workspaces[0].name"), equalTo("reqRes"));

    }

}
