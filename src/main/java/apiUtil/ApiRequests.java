package apiUtil;

import io.restassured.response.Response;

import static apiUtil.UrlUtil.CREATE_POST_PATH;
import static apiUtil.UrlUtil.UPDATE_OR_DELETE_USER_PATH;
import static io.restassured.RestAssured.given;

public class ApiRequests {

    private ApiRequests() {
    }

    public static Response postRequestNoToken(String endpoint, Object body, int statusCode) {
        return given()
                .spec(UrlUtil.specification)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public static Response postRequest(String endpoint, Object body, int statusCode, String accessToken) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public static Response getRequest(String endpoint, int statusCode, String accessToken) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }
    public static Response getPostRequest(int statusCode, String accessToken, String id) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(UPDATE_OR_DELETE_USER_PATH + id + CREATE_POST_PATH)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }
    public static Response getPostInvalidPathRequest(int statusCode, String accessToken, String id) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(UPDATE_OR_DELETE_USER_PATH + id )
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }
    public static String createPostAndGetId(Object post, String accessToken, String id) {
        Response response = given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .contentType("application/json")
                .body(post)
                .when()
                .post(UPDATE_OR_DELETE_USER_PATH + id + CREATE_POST_PATH)
                .then()
                .log().all()
                .statusCode(201)  // Проверяем, что статус код 201, что означает успешное создание
                .extract()
                .response();

        return response.jsonPath().getString("id");  // Получаем ID из JSON ответа
    }

    public static Response putRequest(String endpoint, Object updatedBody, int statusCode, String accessToken) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .body(updatedBody)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public static Response deleteRequest(String endpoint, int statusCode, String accessToken, String idUser) {
        return given()
                .spec(UrlUtil.specification)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete(endpoint + idUser)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}

