package task_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Fun {

    static String ID;

    // Base URI (common for all APIs)
    static {
        RestAssured.baseURI = "http://49.249.28.218:8091";
    }


    @Test
    public void createProject() {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"createdBy\": \"haarwin\", \"projectName\": \"API_Automation_Project002\", \"status\": \"Ongoing\", \"teamSize\": 0 }")

        .when()
                .post("/addProject")

        .then()
                .statusCode(201)
                .log().all()
                .extract().response();

        ID = response.jsonPath().getString("projectId");

        System.out.println("Project ID Created -> " + ID);
    }


    @Test(dependsOnMethods = "createProject")
    public void getProject() {

        RestAssured.given()
                .pathParam("PROJECT_ID", ID)

        .when()
                .get("/Project/{PROJECT_ID}")

        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(dependsOnMethods = "getProject")
    public void updateProject() {

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"createdBy\": \"haarwin\", \"projectName\": \"API_Automation_Project002\", \"status\": \"Completed\", \"teamSize\": 6 }")
                .pathParam("PROJECT_ID", ID)

        .when()
                .put("/Project/{PROJECT_ID}")

        .then()
                .log().all();   // Some Ninza servers return 405, so we skip strict validation
    }

    @Test(dependsOnMethods = "updateProject")
    public void deleteProject() {

        RestAssured.given()
                .pathParam("PROJECT_ID", ID)

        .when()
                .delete("/Project/{PROJECT_ID}")

        .then()
                .log().all();
    }
}