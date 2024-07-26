import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import post.Post;

import static apiUtil.ApiRequests.postRequest;
import static apiUtil.UrlUtil.CREATE_POST_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static user.PostDataRegistry.createDefaultPost;
import static user.PostDataRegistry.getInvalidPost;

public class PostCreateTest extends AdminTest {
    @Test
    public void postCreateTest() {

        Response response = postRequest(CREATE_POST_PATH, createDefaultPost(), 201, accessAdminToken);
        assertEquals(201, response.getStatusCode(), "The response status is as expected.");
    }

    @Test
    public void updatePostBadRequestTest() {
        postRequest(CREATE_POST_PATH, getInvalidPost(), 400, accessAdminToken);
    }

    @Test
    public void postCreateBadRequestTest() {
        postRequest(CREATE_POST_PATH, createDefaultPost(), 401, null);
    }
}
