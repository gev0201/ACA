package tests.apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestReqres {
    @Test
    public void checkResponse() {
        given().
                baseUri("https://api.postman.com")
                .header("X-Api-Key",
                        "PMAK-61b7629c2e987400527bb771-499f84ebc4d691aed909af7ce8a66f1452").
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200).
                body("workspaces.name",
                        hasItems("5ee8c421-7585-4707-9115-ea576964ab3c",
                                "9be1c07c-f20f-41fc-ac80-d7b1b91b93e2",
                                "59db625f-e514-4e73-a05e-dd552e415734"),
                        "workspaces[0].name", equalTo("reqRes"),
                        "workspaces[1].name", is(equalTo("postmanWorkspaces")),
                        "workspaces.size()", is(equalTo(3)),
                        "workspaces.name", hasItem("MockServerAPI"));
    }

    @Test
    public void extractRespose() {
        Response res = given().
                baseUri("https://api.postman.com")
                .header("X-Api-Key",
                        "PMAK-61b7629c2e987400527bb771-499f84ebc4d691aed909af7ce8a66f1452").
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200).
                extract().response();
        System.out.println("Rsponse is --------- " + res.asString());

    }

    @Test
    public void extractSingleValueFromRespose() {
        Response
//        String
                responsejson = given().
                baseUri("https://api.postman.com")
                .header("X-Api-Key",
                        "PMAK-61b7629c2e987400527bb771-499f84ebc4d691aed909af7ce8a66f1452").
                when().
                get("/workspaces").
                then().
                assertThat().
                statusCode(200).
                extract().response();
//                .asString();
        assertThat(responsejson.path("workspaces[0].name"), equalTo("reqRes"));
//        assertEquals(4, "reqRess", "Spasvox arjeqy chi hamapatasxanum, aktualin");


//        System.out.println(responsejson);


//        String Str1 = JsonPath.from(res).getString("workspaces[0].name");
//        System.out.println(Str1);


//        JsonPath jsonPath = new JsonPath(responsejson.asString());
//        String str = jsonPath.getString("workspaces[0].name");
//        System.out.println("------------------------------   " + str);


//        System.out.println("First Workspace NAME is --------- " + responsejson.path("workspaces[0].name"));
//        System.out.println("First Workspace ID is --------- " + responsejson.path("workspaces[0].id"));
    }
}