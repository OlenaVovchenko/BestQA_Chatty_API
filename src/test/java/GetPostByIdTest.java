import apiUtil.ApiRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.*;
import static apiUtil.UrlUtil.*;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_USER_PATH;
import static org.junit.jupiter.api.Assertions.*;
import static user.PostDataRegistry.createDefaultPost;
import static user.PostDataRegistry.getInvalidPost;

public class GetPostByIdTest extends AdminUserTest {


    @Test
    public void getPostByIdTest() {

        Response response = postRequest(CREATE_POST_PATH, createDefaultPost(), 201, accessAdminToken);
        assertEquals(201, response.getStatusCode(), "The response status is as expected.");

        Response getPostResponse = ApiRequests.getPostRequest(200, accessToken, getUserIdAfterRequest());
        assertEquals(200, getPostResponse.getStatusCode());
        assertFalse(getPostIdAfterRequest().isEmpty());
    }


    @Test
    public void getPostByIdBadRequestTest() {
        Response response = getPostRequest(400, accessToken, "");
        assertEquals(400, response.getStatusCode(), "Expected Bad Request status.");
    }


      @Test
    public void getPostByIdNoAuthorizationTest() {
        Response response = getPostRequest(401, null, userId);
        assertEquals(401, response.getStatusCode(), "Expected Unauthorized status.");
        String errorMessage = response.getBody().jsonPath().getString("message");
        assertEquals("Unauthorized", errorMessage, "Error message does not match expected.");
    }


}























