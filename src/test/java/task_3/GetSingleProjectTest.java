package task_3;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetSingleProjectTest {

    @Test
    public void getProjectById() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        RestAssured
                .given()
                .pathParam("projectId", "TY_PROJ_001")
                .when()
                .get("/projects/{projectId}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
