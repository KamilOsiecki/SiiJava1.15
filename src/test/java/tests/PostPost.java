package tests;

import base.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;

public class PostPost extends TestBase {

    @ParameterizedTest
    @MethodSource("data_provider.DataProvider#postPostDataProvider")
    @DisplayName("Post user post")
    @Tag("Post user post")
    public void shouldCreateNewPost(String body) {
        given()
                .body(body)
                .contentType(ContentType.JSON).
        when()
                .post(POSTS)
                .then().statusCode(201);
    }
}