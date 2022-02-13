package tests.apiTests;

import base.ApiBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.CreateUserGoRestJson;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestGoRestUserCRUD extends ApiBase {
    public  String endpoint= "/public/v2/users";
    public int userId;

    private String email = "GEVORGGevya@mail.com";
    private String name = "GEVOGGevorgya";
    private String gender = "male";
    private String status = "Active";

    List<String> headerValues = new ArrayList<>();

    @Test(priority = 0)
    public void createUser() {
        headerValues.add("Authorization");
        headerValues.add("Bearer 9ca3cc5d0340f386a2f2b423de49068ae9847c495bfe17593d4ed06304644c88");

        CreateUserGoRestJson userJson = new CreateUserGoRestJson(
                email,
                name,
                gender,
                status
        );
        Response createUser = postRequest(baseUrlGoRest,userJson, headerValues, endpoint);
        assertThat(createUser.path("name"), is(equalTo(name)));
        assertThat(createUser.path("gender"), is(equalTo(gender)));
        userId = createUser.path("id");
    }

    @Test(priority = 1)
    public void getUserById() {
        headerValues.add("Authorization");
        headerValues.add("Bearer 9ca3cc5d0340f386a2f2b423de49068ae9847c495bfe17593d4ed06304644c88");
        Response fetchUser = getRequest(baseUrlGoRest,null, headerValues, endpoint + "/" + userId);
        checkStatusCode(fetchUser, "200");
        assertThat(fetchUser.path("name"), is(equalTo(name)));
        assertThat(fetchUser.path("id"), is(equalTo(userId)));
    }

    @Test(priority = 2)
    public void updateUser(){
        CreateUserGoRestJson userJson = new CreateUserGoRestJson(
                userId,
                email,
                "Valya",
                "Female",
                status
        );
        Response updateUser = putRequest(baseUrlGoRest,userJson, headerValues, endpoint + "/" + userId);
        assertThat(updateUser.path("name"), is(equalTo("Valya")));
        assertThat(updateUser.path("gender"), is(equalTo("female")));
    }

    @Test(priority = 3)
    public void deleteUser(){
        CreateUserGoRestJson userJson = new CreateUserGoRestJson();
        Response delUser = deleteRequest(baseUrlGoRest, userJson, null, headerValues, endpoint + "/" + userId);
        checkStatusCode(delUser, "204");
    }
}
