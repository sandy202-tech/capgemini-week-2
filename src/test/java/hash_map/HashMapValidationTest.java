package hash_map;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class HashMapValidationTest {

    @Test
    public void validateResponseUsingMap() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        HashMap<String, Object> map = new HashMap<>();
        map.put("createdBy", "Sabarinathan");
        map.put("projectName", "ValidationProject");
        map.put("status", "Created");
        map.put("teamSize", 5);

        RestAssured
                .given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("/addProject")
                .then()
                .statusCode(201)
                .body("createdBy", equalTo("Sabarinathan"))
                .log().all();
    }
}