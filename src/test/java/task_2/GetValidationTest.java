package task_2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetValidationTest {

    @Test
    public void validateGet() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        RestAssured
                .given()
                .get("/projects")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .log().all();
    }
}