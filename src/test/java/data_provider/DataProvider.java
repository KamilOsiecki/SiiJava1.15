package data_provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {
    public static Stream<Arguments> getUserPostsDataProvider() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("3")
        );
    }

    public static Stream<Arguments> deletePostDataProvider() {
        return Stream.of(
                Arguments.of("1")
        );
    }

    public static Stream<Arguments> patchPostDataProvider() {
        return Stream.of(
                Arguments.of("1", """
                        {
                          "title": "Test post title",
                          "body": "Test body"
                        }""")
        );
    }

    public static Stream<Arguments> postPostDataProvider() {
        return Stream.of(
                Arguments.of("""
                        {
                          "title": "NEW POST",
                          "body": "NEW POST BODY"
                        }""")
        );
    }

    public static Stream<Arguments> putPostDataProvider() {
        return Stream.of(
                Arguments.of("1", """
                        {
                          "title": "Test post title",
                          "body": "Test body"
                        }""")
        );
    }
}