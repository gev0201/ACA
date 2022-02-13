package tests.apiTests;

import base.ApiBase;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import models.CreateUserJson;
import models.MapBuilder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestReqresCreateEditDeleteUser extends ApiBase {
    private String usersListEndpoint = "/api/users";
    private String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}" +
            "(\\.[0-9]+)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?";
    private String userId;

    @Test(priority = 0)
    public void createUser() {
        CreateUserJson createUserJson = new CreateUserJson(
                "Gevorg",
                "QA"
        );
        Response newUser = postRequest(baseUrlReqres, createUserJson, null, usersListEndpoint);
        checkStatusCode(newUser, "201");
        assertThat(newUser.path("name"), is(equalTo("Gevorg")));
        assertThat(newUser.path("id"), is(notNullValue()));
        assertThat(newUser.path("createdAt"), matchesPattern(regex));
        userId = newUser.path("id");
    }

    @Test(priority = 1)
    public void updateUser() {
        CreateUserJson createUserJson = new CreateUserJson(
                "Gevorg",
                "QA_engineer"
        );
        Response newUser = putRequest(baseUrlReqres, createUserJson, null, usersListEndpoint + "/" + userId);
        checkStatusCode(newUser, "200");
        assertThat(newUser.path("job"), is(equalTo("QA_engineer")));
        assertThat(newUser.path("id"), is(notNullValue()));
    }

    @Test(priority = 2)
    public void deleteUser() {
        CreateUserJson createUserJson = new CreateUserJson();
        Response newUser = deleteRequest(baseUrlReqres, createUserJson, null, null,
                usersListEndpoint + "/" + userId);
        checkStatusCode(newUser, "204");
    }
}
