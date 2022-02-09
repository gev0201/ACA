package tests.apiTests;

import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RequestSpecTest {
    RequestSpecification requestSpecification;

    @BeforeClass
    public void beforeClass(){
        requestSpecification =
//                              with().
                                given().baseUri("https://api.postman.com")
                                .header("X-Api-Key",
                                "PMAK-61b7629c2e987400527bb771-499f84ebc4d691aed909af7ce8a66f1452");
    }


    @Test
    public void validateStatusCode(){
                given().spec(requestSpecification).
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void validateWorkspaceName(){
                given().spec(requestSpecification).
                when().
                get("/workspaces").
                then().
                assertThat().
                body("workspaces[0].name", equalTo("reqRes"));
    }

}
