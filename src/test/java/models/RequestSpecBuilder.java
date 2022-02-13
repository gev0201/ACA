package models;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class RequestSpecBuilder {

    public RequestSpecification rSpec(String baseUri, List<String> params, List<String> headers){
        if (params != null) {
            RequestSpecification reqSpec = given().
                    contentType(ContentType.JSON).
                    baseUri(baseUri).
                    params(MapBuilder.reqParam(params));
            return reqSpec;
        }
        else if (headers != null){
            RequestSpecification reqSpec = given().
                    contentType(ContentType.JSON).
                    baseUri(baseUri).
                    params(MapBuilder.reqParam(headers));
            return reqSpec;
        }
        else if (params != null & headers != null){
            RequestSpecification reqSpec = given().
                    contentType(ContentType.JSON).
                    baseUri(baseUri).
                    params(MapBuilder.reqParam(params)).
                    headers(MapBuilder.reqParam(headers));
            return reqSpec;
        }
        else {
            RequestSpecification reqSpec = given().
                    contentType(ContentType.JSON).
                    baseUri(baseUri);
            return reqSpec;
        }
    }
}
