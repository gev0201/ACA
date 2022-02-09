package base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiBase {

    public String baseUrlReqres = "https://reqres.in";
    public String baseUrlPostmanLocal = "https://6bd604fb-eca4-48d1-8c2c-bdfa6066b3c1.mock.pstmn.io";
    public String baseUrlPostman = "https://api.postman.com";
    public String baseUrlLocal = "http://localhost:80";

    public void checkStatusCode(Response response, String statusCode) {
        String actualCode = String.valueOf(response.getStatusCode());
        Assert.assertEquals(actualCode, statusCode, "The response  codes not mutch");
    }

    /**
     * Use this method to fetch data from server using method GET, without parameters and headers.
     * @param baseurl
     * @param endpoint
     * @return
     */
    public Response getRequest(String baseurl, String endpoint) {
        Response get = given().
                contentType(ContentType.JSON).
                baseUri(baseurl).
                when().
                get(endpoint).
                then().
                log().ifValidationFails().
                log().all().
                extract().response();
        return get;
    }

    /**
     *
     * @param baseurl
     * @param endpoint
     * @param params
     * @param headers
     * @return
     */

    public Response getRequest(String baseurl, String endpoint, Map<String, String> params, Map<String, String> headers) {
        Response get = given().
                contentType(ContentType.JSON).
                params(params).
                baseUri(baseurl).headers(headers).
                when().
                get(endpoint).
                then().
                log().ifValidationFails().
                extract().response();
        return get;
    }
}
