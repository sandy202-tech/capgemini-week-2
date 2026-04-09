package task_2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BasicAuthTest {

    @Test
    public void basicAuthTest() {

        RestAssured
                .given()
                .auth()
                .basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .log().all();
    }
}