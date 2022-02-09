package tests.apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.UserJson;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class goRestTest {
    public String baseUrl = "https://gorest.co.in";
    public  String endpoint= "/public/v2/users";
    public int userId;

    private String email = "Asw45qwerd@mail.com";
    private String name = "1234";
    private String gender = "male";
    private String status = "Active";


    @Test(priority = 0)
    public void createPostRequest() {
        UserJson userJson = new UserJson(
                email,
                name,
                gender,
                status
        );
        Response res = given().baseUri(baseUrl).contentType(ContentType.JSON)
                .header("Authorization", "Bearer 9ca3cc5d0340f386a2f2b423de49068ae9847c495bfe17593d4ed06304644c88")
                .body(userJson)
                .when().post(endpoint)
                .then().log().all().statusCode(201).extract().response();

                assertThat(res.path("name"), is(equalTo(name)));
                assertThat(res.path("gender"), is(equalTo(gender)));
                userId = res.path("id");
    }

    @Test(priority = 1)
    public void getUserById() {
        given().baseUri(baseUrl).contentType(ContentType.JSON)
                .header("Authorization", "Bearer 9ca3cc5d0340f386a2f2b423de49068ae9847c495bfe17593d4ed06304644c88")
                .when().get(endpoint)
                .then()
                .assertThat().statusCode(200).body("id", hasItem(userId));
    }

    @Test(priority = 2)
    public void updateUser(){
        UserJson userJson = new UserJson(
                userId,
                email,
                "Valya",
                "Female",
                status
        );
        Response res = given().baseUri(baseUrl).contentType(ContentType.JSON)
                .header("Authorization", "Bearer 9ca3cc5d0340f386a2f2b423de49068ae9847c495bfe17593d4ed06304644c88")
                .body(userJson)
                .when().put(endpoint + "/" + userId)
                .then().log().all().statusCode(200).extract().response();

        assertThat(res.path("name"), is(equalTo("Valya")));
        assertThat(res.path("gender"), is(equalTo("female")));
    }

    @Test(priority = 3)
    public void deleteUser(){
        given().baseUri(baseUrl).contentType(ContentType.JSON)
                .header("Authorization", "Bearer 9ca3cc5d0340f386a2f2b423de49068ae9847c495bfe17593d4ed06304644c88")
                .when().delete(endpoint + "/" + userId)
                .then()
                .assertThat().statusCode(204);
    }

}
