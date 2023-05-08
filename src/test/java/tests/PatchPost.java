package tests;

import base.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;

public class PatchPost extends TestBase {

    @ParameterizedTest
    @MethodSource("data_provider.DataProvider#patchPostDataProvider")
    @DisplayName("Patch post by ID")
    @Tag("Patch post")
    public void shouldPatchPost(String userID, String body) {
        given().
                body(body).
                contentType(ContentType.JSON).
        when().
                patch(POSTS + "/" + userID).
                then().statusCode(200);
    }
}