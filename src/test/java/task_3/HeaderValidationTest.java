package task_3;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class HeaderValidationTest {

    @Test
    public void validateHeaders() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        RestAssured
                .given()
                .when()
                .get("/projects")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .log().all();
    }
}