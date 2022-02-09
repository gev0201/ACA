package tests.apiTests;

import base.ApiBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestReqresGetRequestsTesting extends ApiBase {
    private String usersListEndpoint = "/api/users";
    private String miscDataEndpoint = "/api/unknown";


    @Test
    public void getUsersAll() {
        Response getRes = getRequest(baseUrlReqres, usersListEndpoint);
        assertThat(getRes.path("data.size()"), is(equalTo(6)));
        assertThat(getRes.path("data.id"), hasItem(1));
    }

    @Test
    public void getUsersByPage() {
        Map<String, String> header = new HashMap<>();
        Map<String, String> pathParam = new HashMap<>();
        pathParam.put("page", "2");
        Response getRes = getRequest(baseUrlReqres, usersListEndpoint, pathParam, header);
        checkStatusCode(getRes, "200");
        assertThat(getRes.path("data.size()"), is(equalTo(6)));
        assertThat(getRes.path("data.id"), hasItem(7));
    }

    @Test
    public void getUsersByPageNegative() {
        Map<String, String> header = new HashMap<>();
        Map<String, String> pathParam = new HashMap<>();
        Response getRes = getRequest(baseUrlReqres, "usersListEndpoint", pathParam, header);
        checkStatusCode(getRes, "404");
    }

    @Test
    public void getmiscData() {
        Response getRes = getRequest(baseUrlReqres, miscDataEndpoint);
        assertThat(getRes.path("support.text"), equalTo("To keep ReqRes free, " +
                "contributions towards server costs are appreciated!"));
    }
}
