import apiUtil.ApiRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static apiUtil.UrlUtil.GET_USER_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserTest extends AdminUserTest {

    @Test
    public void getUserTest() {

        ApiRequests.getRequest(GET_USER_PATH, 200, accessToken);

        Response getUserResponse = ApiRequests.getRequest(GET_USER_PATH, 200, accessToken);
        assertEquals(200, getUserResponse.getStatusCode());

    }

}
