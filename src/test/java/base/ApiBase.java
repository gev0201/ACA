package base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.MapBuilder;
import models.RequestSpecBuilder;
import org.testng.Assert;
import java.util.List;


import static io.restassured.RestAssured.given;

public class ApiBase {

    public String baseUrlReqres = "https://reqres.in";
    public String baseUrlGoRest = "https://gorest.co.in";
    public String baseUrlPostmanLocal = "https://6bd604fb-eca4-48d1-8c2c-bdfa6066b3c1.mock.pstmn.io";
    public String baseUrlPostman = "https://api.postman.com";
    public String baseUrlLocal = "http://localhost:80";
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();


    /**
     * Use this method to check status Code
     * @param response - Response object
     * @param statusCode - int expected status code
     */
    public void checkStatusCode(Response response, String statusCode) {
        String actualCode = String.valueOf(response.getStatusCode());
        Assert.assertEquals(actualCode, statusCode, "Not expected response status code " + actualCode);
    }

    /**
     * Use this method to fetch data from server using method GET, with parameters and headers.
     * @param baseurl - String Base URI
     * @param endpoint - String endpoint
     * @param params - Map params
     * @param headers - Map headers
     * @return - Response object
     */
    public Response getRequest(String baseurl, List<String> params,
                               List<String> headers,  String endpoint) {
        Response get = given().
                spec(requestSpecBuilder.rSpec(baseurl,params,headers)).
                when().
                get(endpoint).
                then().
                log().all().
                extract().response();
        return get;
    }

    /**
     * Use this method to send POST request
     * @param baseurl - String Base URI
     * @param jsonObj
     * @param headers
     * @param endpoint
     * @return
     */
    public Response postRequest(String baseurl, Object jsonObj, List<String> headers, String endpoint) {
        Response post = given().
                contentType(ContentType.JSON).
                baseUri(baseurl).
                body(jsonObj).
                headers(MapBuilder.reqParam(headers)).
                when().
                post(endpoint).
                then().
                log().all().
                extract().response();
        return post;
    }

    /**
     * Use this method to send PUT request
     * @param baseurl
     * @param jsonObj
     * @param headers
     * @param endpoint
     * @return
     */
    public Response putRequest(String baseurl, Object jsonObj, List<String> headers, String endpoint) {
        Response put = given().
                contentType(ContentType.JSON).
                baseUri(baseurl).
                body(jsonObj).
                headers(MapBuilder.reqParam(headers)).
                when().
                put(endpoint).
                then().
                log().all().
                extract().response();
        return put;
    }

    /**
     * Use this method to send DELETE request
     * @param baseurl
     * @param jsonObj
     * @param params
     * @param headers
     * @param endpoint
     * @return
     */
    public Response deleteRequest(String baseurl, Object jsonObj, List<String> params, List<String> headers, String endpoint){
        Response post = given().
                contentType(ContentType.JSON).
                baseUri(baseurl).
                body(jsonObj).
                params(MapBuilder.reqParam(params)).
                headers(MapBuilder.reqParam(headers)).
                when().
                delete(endpoint).
                then().
                log().all().
                extract().response();
        return post;
    }
}