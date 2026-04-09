package task2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void createUser() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        String body = "{\n" +
                "  \"createdBy\": \"Sabarinathan\",\n" +
                "  \"projectName\": \"Task1Project\",\n" +
                "  \"status\": \"Created\",\n" +
                "  \"teamSize\": 0\n" +
                "}";

        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("/addProject");

        res.then().statusCode(201).log().all();
    }
}