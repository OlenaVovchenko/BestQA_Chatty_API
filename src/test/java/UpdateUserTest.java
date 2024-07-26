import static apiUtil.ApiRequests.deleteRequest;
import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.putRequest;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_USER_PATH;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import user.User;
import static user.UserDataRegistry.getInvalidUser;
import static user.UserDataRegistry.getUpdatedUser;

public class UpdateUserTest extends AdminUserTest {


    @Test
    public void updateUserTest() {
        User expectedUser = getUpdatedUser(authRegisteredUser.getEmail());
        putRequest(UPDATE_OR_DELETE_USER_PATH + userId, expectedUser, 200, accessToken);
        User returnedUser = getRequest(GET_USER_PATH, 200, accessToken).body().as(User.class);

        assertEquals(expectedUser.getAvatarUrl(), returnedUser.getAvatarUrl());
        assertEquals(expectedUser.getName(), returnedUser.getName());
        assertEquals(expectedUser.getSurname(), returnedUser.getSurname());
        assertEquals(userId, returnedUser.getId());
        assertEquals(expectedUser.getGender(), returnedUser.getGender());
        assertEquals(expectedUser.getPhone(), returnedUser.getPhone());
        assertTrue(returnedUser.getBirthDate().contains(expectedUser.getBirthDate().substring(0,10)));
        assertFalse(returnedUser.getEmail().isEmpty());
        assertFalse(returnedUser.getRole().isEmpty());
        assertFalse(returnedUser.getBlocked());
        assertNull(returnedUser.getBackgroundUrl());
    }


    @Test
    public void updateUserNoAuthorizationTest() {
        putRequest(UPDATE_OR_DELETE_USER_PATH + userId, getUpdatedUser(authRegisteredUser.getEmail()),
                401, null);
    }

    @Test
    public void updateUserBadRequestTest() {
        putRequest(UPDATE_OR_DELETE_USER_PATH + userId, getInvalidUser(), 400, accessAdminToken);
    }


    @AfterEach
    public void deleteUser(){
        deleteRequest(UPDATE_OR_DELETE_USER_PATH, 204,  accessAdminToken, userId);
    }

}
