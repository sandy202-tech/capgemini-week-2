package task_3;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateUserWithValidation {

    @Test
    public void createUserValidate() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        String body = "{\n" +
                "  \"createdBy\": \"Sabarinathan\",\n" +
                "  \"projectName\": \"ValidateProject\",\n" +
                "  \"status\": \"Created\",\n" +
                "  \"teamSize\": 6\n" +
                "}";

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/addProject")
                .then()
                .statusCode(201)
                .assertThat()
                .body("createdBy", org.hamcrest.Matchers.equalTo("Sabarinathan"))
                .log().all();
    }
}