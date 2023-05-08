package tests;

import base.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;

import static io.restassured.RestAssured.*;

public class GetPosts extends TestBase {

    @Test
    @DisplayName("Get all posts")
    @Tag("Get all posts")
    public void shouldGetAllUsers() {
        Response response =
                when().
                        get(POSTS).
                then().
                        statusCode(200).
                        extract().
                        response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertThat(jsonPath.get("body").toString()).isNotEmpty();
    }

    @ParameterizedTest
    @MethodSource("data_provider.DataProvider#getUserPostsDataProvider")
    @DisplayName("Get posts by user ID")
    @Tag("Get user posts")
    public void shouldGetUserPosts(String userID) {
        Response response =
                when().
                                get(POSTS + "/" + userID).
                        then().
                                statusCode(200)
                                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/userPostsSchema.json")))
                                .extract()
                                .response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertThat(jsonPath.get("id").toString()).isEqualTo(userID);
    }
}