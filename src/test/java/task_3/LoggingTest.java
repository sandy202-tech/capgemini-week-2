package task_3;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class LoggingTest {

    @Test
    public void logRequestResponse() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        RestAssured
                .given()
                .log().all()
                .when()
                .get("/projects")
                .then()
                .log().all();
    }
}