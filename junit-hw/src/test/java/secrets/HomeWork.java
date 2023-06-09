package secrets;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomeWork {

    private static final String EMAIL_1 = "user3@example.com";
    private static final String EMAIL_2 = "user2@example.com";
    private static final String PASSWORD_1 = "Superbowl-recipe";
    private static final String PASSWORD_2 = "require-Absorb";
    private static final String FILE_PATH = "../junit-hw/src/test/resources/test.csv";

    @BeforeAll
    void makeSources() {
        makeResourcesFolderIfNotExist();
        try (PrintWriter writer = new PrintWriter(FILE_PATH)) {
            writer.println("Гари" + "," + login(EMAIL_1, PASSWORD_1));
            writer.println("Джо" + "," + login(EMAIL_2, PASSWORD_2));
        } catch (IOException e) {
            System.out.println(e + " Не удалось записать данные в файл: " + FILE_PATH);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv")
    @DisplayName("Проверка созданного поста")
    void checkAllPersons(String author, String token) {

        JsonPath jsonValidator = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .body(generateRandomJsonBodyForPost())
                .post("/posts").then().statusCode(HTTP_OK).extract().jsonPath();

        assertAll(
                () -> assertEquals(author, jsonValidator.get("author")),
                () -> assertNotNull(jsonValidator.get("id"))
        );

        deletePostById(jsonValidator.get("id"), token);
    }


    private String login(String email, String password) {
        RestAssured.baseURI = "http://qa-games.ru:9000";
        String authData = "{" +
                "\"email\": " + "\"" + email + "\"" + "," +
                "\"password\": " + "\"" + password + "\"" + " " +
                "}";

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(authData).post("/users/login").getCookie("token");
    }

    private String generateRandomString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private void deletePostById(String id, String token) {
        RequestSpecification httpRequestDelete = RestAssured.given();
        httpRequestDelete.header("Content-Type", "application/json");
        httpRequestDelete.header("Cookie", "token=" + token);

        httpRequestDelete.delete("/posts/" + id).then().statusCode(200);
    }

    private String generateRandomJsonBodyForPost() {
        return "{" +
                "    \"title\": " + "\"" + generateRandomString() + "\"" + "," +
                "    \"body\": " + "\"" + generateRandomString() + "\"" + "" +
                "}";
    }

    private static void makeResourcesFolderIfNotExist() {
        File resourcesDirectory = new File(FILE_PATH.substring(0, FILE_PATH.lastIndexOf('/')));
        if (!resourcesDirectory.exists()) {
            resourcesDirectory.mkdirs();
        }
    }

}

