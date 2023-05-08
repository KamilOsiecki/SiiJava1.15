package tests;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.*;

public class DeletePost extends TestBase {

    @ParameterizedTest
    @MethodSource("data_provider.DataProvider#deletePostDataProvider")
    @DisplayName("Delete post by ID")
    @Tag("Delete post")
    public void shouldDeletePost(String userID) {
        when()
                .delete(POSTS + "/" + userID)
                .then()
                .statusCode(200);
    }
}