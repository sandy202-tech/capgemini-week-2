package task2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetUserTest {

    @Test
    public void getAllUsers() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        RestAssured
                .given()
                .get("/projects")
                .then()
                .statusCode(200)
                .log().all();
    }
}