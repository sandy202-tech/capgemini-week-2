package task_2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BearerTokenTest {

    @Test
    public void bearerTokenTest() {

        String token = "your_token_here";

        RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.github.com/user")
                .then()
                .log().all();
    }
}