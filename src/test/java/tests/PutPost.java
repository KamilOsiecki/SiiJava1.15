package tests;

import base.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;

public class PutPost extends TestBase {
    @ParameterizedTest
    @MethodSource("data_provider.DataProvider#putPostDataProvider")
    @DisplayName("Put post by user ID")
    @Tag("Put post")
    public void shouldPutPost(String userID, String body) {
        given()
                .body(body)
                .contentType(ContentType.JSON).
        when()
                .put(POSTS + "/" + userID)
                .then().statusCode(200);
    }
}