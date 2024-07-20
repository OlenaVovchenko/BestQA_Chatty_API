package apiUtil;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UrlUtil {

    public static final String BASE_URL = "http://chatty.telran-edu.de:8989/api";
    public static final String REFRESH_PATH = "/auth/refresh";
    public static final String AUTH_PATH = "/auth/login";
    public static final String GET_USER_PATH = "/me";
    public static final String UPDATE_OR_DELETE_USER_PATH = "/users";
    public static final String REGISTER_PATH = "/auth/register";

    public static final RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .build()
            .log().all();

    private UrlUtil() {
    }
}
