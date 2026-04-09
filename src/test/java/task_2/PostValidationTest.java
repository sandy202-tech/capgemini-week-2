package task_2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostValidationTest {

    @Test
    public void validatePost() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        String body = "{\n" +
                "  \"createdBy\": \"Sabarinathan\",\n" +
                "  \"projectName\": \"task2Project\",\n" +
                "  \"status\": \"Created\",\n" +
                "  \"teamSize\": 0\n" +
                "}";

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("/addProject")
                .then()
                .statusCode(201)
                .log().all();
    }
}