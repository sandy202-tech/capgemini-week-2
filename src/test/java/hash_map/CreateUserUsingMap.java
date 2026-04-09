package hash_map;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateUserUsingMap {

    @Test
    public void createUserMap() {

        RestAssured.baseURI = "http://49.249.28.218:8091";

        HashMap<String, Object> map = new HashMap<>();
        map.put("createdBy", "Sabarinathan");
        map.put("projectName", "MapProject");
        map.put("status", "Created");
        map.put("teamSize", 3);

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(map)
                .when()
                .post("/addProject")
                .then()
                .statusCode(201)
                .log().all();
    }
}