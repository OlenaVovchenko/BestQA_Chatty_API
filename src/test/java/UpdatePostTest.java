import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import post.Post;
import user.User;

import static apiUtil.ApiRequests.*;
import static apiUtil.UrlUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static user.PostDataRegistry.createDefaultPost;
import static user.PostDataRegistry.getUpdatedPost;
import static user.UserDataRegistry.getInvalidUser;
import static user.UserDataRegistry.getUpdatedUser;

public class UpdatePostTest extends AdminUserTest {


    @Test
    public void updatePostTest() {

        Response response = postRequest(CREATE_POST_PATH, createDefaultPost(), 201, accessAdminToken);
        assertEquals(201, response.getStatusCode(), "The response status is as expected.");
        assertFalse(getPostIdAfterRequest().isEmpty());
        String postId = getPostIdAfterRequest();

        Post expectedPost = getUpdatedPost(postId);
        Response putResponse = putRequest(CREATE_POST_PATH + postId, expectedPost, 200, accessToken);
        assertEquals(200, putResponse.getStatusCode(), "The response status is as expected.");

        Response getResponse = getRequest(CREATE_POST_PATH + postId, 200, accessToken);
        Post returnedPost = getResponse.body().as(Post.class);

        assertEquals(expectedPost.getTitle(), returnedPost.getTitle());
        assertEquals(expectedPost.getDescription(), returnedPost.getDescription());
        assertEquals(expectedPost.getBody(), returnedPost.getBody());
        assertEquals(expectedPost.getImageUrl(), returnedPost.getImageUrl());

    }

    @Test
    public void updateUserBadRequestTest() {
        String postId = getPostIdAfterRequest();
         Response putResponse = putRequest(CREATE_POST_PATH + postId, createDefaultPost(), 404, accessToken);

    }

    @Test
    public void updatePostNoAuthorizationTest() {
        String postId = getPostIdAfterRequest();
        Post expectedPost = getUpdatedPost(postId);
        Response putResponse = putRequest(CREATE_POST_PATH + postId, expectedPost, 401, null);
    }
}











