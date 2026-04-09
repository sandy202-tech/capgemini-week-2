package task2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class UpdateUserTest {

    @Test
    public void updateUser() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        String body = "{\n" +
                "  \"createdBy\": \"Sabarinathan\",\n" +
                "  \"projectName\": \"UpdatedProject\",\n" +
                "  \"status\": \"Ongoing\",\n" +
                "  \"teamSize\": 0\n" +
                "}";

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .put("/projects/TY_PROJ_001")
                .then()
                .statusCode(200)
                .log().all();
    }
}