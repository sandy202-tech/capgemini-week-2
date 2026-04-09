package task_3;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ResponseTimeTest {

    @Test
    public void checkResponseTime() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        RestAssured
                .given()
                .when()
                .get("/projects")
                .then()
                .time(org.hamcrest.Matchers.lessThan(2000L))
                .log().all();
    }
}