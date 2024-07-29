import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static apiUtil.ApiRequests.*;
import static apiUtil.ApiRequests.getPostRequest;
import static apiUtil.UrlUtil.CREATE_POST_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static post.PostDataRegistry.createDefaultPost;

public class GetPostsByUser extends AdminUserTest{
    @Test
    public void getPostByUserTest() {
        getUserIdAfterRequest();
        postRequest(CREATE_POST_PATH, createDefaultPost(), 201, accessAdminToken);
        Response getPostByUser = getPostRequest(200, accessToken, getUserIdAfterRequest());
        assertEquals(200, getPostByUser.getStatusCode());
    }

    @Test
    public void getPostByUserBadRequestTest() {
        getPostInvalidPathRequest(405, accessToken, getUserIdAfterRequest());
    }

    @Test
    public void postCreateBadRequestTest() {
        getPostRequest(401, null, getUserIdAfterRequest());
    }

}

