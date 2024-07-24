import static apiUtil.ApiRequests.getRequest;
import static apiUtil.ApiRequests.postRequest;
import static apiUtil.ApiRequests.postRequestNoToken;
import static apiUtil.UrlUtil.AUTH_PATH;
import static apiUtil.UrlUtil.GET_USER_PATH;
import static apiUtil.UrlUtil.REFRESH_PATH;
import static apiUtil.UrlUtil.REGISTER_PATH;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import user.AuthorizationUser;
import static user.UserDataRegistry.getAdminRegistration;
import static user.UserDataRegistry.getUserForLogin;
import static user.UserDataRegistry.getUserRegistration;
import user.UserRole;
import static user.UserRole.ADMIN;
import static user.UserRole.USER;


public class BaseTest {
    protected String accessToken;
    protected String refreshToken;
    protected String accessAdminToken;
    protected String refreshAdminToken;
    protected AuthorizationUser authRegisteredUser;


    public void setTokensAfterUserRegistration(UserRole role) {
        JsonPath jsonPath = registerValidUser(role).jsonPath();
        String accessToken = jsonPath.getString("accessToken");
        String refreshToken = jsonPath.getString("refreshToken");

        if (ADMIN == role) {
            this.accessAdminToken = accessToken;
            this.refreshAdminToken = refreshToken;
        } else if (USER == role) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        } else {
            throw new IllegalArgumentException("User with unknown role");
        }
    }

    private Response registerValidUser(UserRole role) {
        if (ADMIN == role) {
            this.authRegisteredUser = getAdminRegistration();
        } else if (USER == role) {
            this.authRegisteredUser = getUserRegistration();
        } else {
            throw new IllegalArgumentException("User with unknown role");
        }
        return postRequestNoToken(REGISTER_PATH, authRegisteredUser, 201);
    }

    public Response refreshTokens(UserRole role) {
        if (ADMIN == role) {
            return postRequest(REFRESH_PATH, refreshAdminToken, 200, accessAdminToken);
        } else if (USER == role) {
            return postRequest(REFRESH_PATH, refreshToken, 200, accessToken);
        }
        throw new IllegalArgumentException("User with unknown role");
    }

    public Response loginRegisteredUser(UserRole role) {
        if (ADMIN == role) {
            return postRequest(AUTH_PATH, getUserForLogin(authRegisteredUser), 200, accessAdminToken);
        } else if (USER == role) {
            return postRequest(AUTH_PATH, getUserForLogin(authRegisteredUser), 200, accessToken);
        }
        throw new IllegalArgumentException("User with unknown role");
    }

    public String getUserIdAfterRequest() {
        return getRequest(GET_USER_PATH, 200, accessToken)
                .jsonPath()
                .getString("id");
    }

}
