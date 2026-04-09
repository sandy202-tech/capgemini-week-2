package task;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject_Post {

    @Test
    public void Create() {

        given()
        .contentType(ContentType.JSON)
            .body("{ \"createdBy\": \"Sabari\", \"projectName\": \"API_Project_02\", \"status\": \"Created\", \"teamSize\": 0}")

        .when()
            .post("http://49.249.28.218:8091/addProject")

        .then()
            .statusCode(201)
            .log().all();
    }

}