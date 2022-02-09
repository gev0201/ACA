package tests.apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadersTest {

    @Test
    public void headerTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("header", "value_2");
        headers.put("x-mock-match-request-headers", "header");
        headers.put("a", "b");
        headers.put("c", "d");

        Response
                responsejson = given().
                baseUri("https://6bd604fb-eca4-48d1-8c2c-bdfa6066b3c1.mock.pstmn.io").
                headers(headers).
//                log().headers().
                when().
                get("/getmock").
                then().
                log().headers().
                assertThat().
                statusCode(200).
                header("res", "resvalue_2").
                header("Server", "nginx").
                extract().response();
    }



    @Test
    public void headersTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("header", "value_2");
        headers.put("x-mock-match-request-headers", "header");
        Response
                responsejson = given().
                baseUri("https://6bd604fb-eca4-48d1-8c2c-bdfa6066b3c1.mock.pstmn.io").
                headers(headers).
                when().
                get("/getmock").
                then().
                assertThat().
                statusCode(200).
                header("res", "resvalue_2").
                extract().response();
    }

}
