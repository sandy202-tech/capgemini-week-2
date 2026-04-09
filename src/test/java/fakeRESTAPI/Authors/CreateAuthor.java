package fakeRESTAPI.Authors;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateAuthor {

    @Test
    public void createAuthor() {

        String body = """
        {
            "id": 20,
            "idBook": 10,
            "firstName": "sabari",
            "lastName": "nathan"
        }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(body)

        // HTTP METHOD
        .when()
            .post("https://fakerestapi.azurewebsites.net/api/v1/authors")

        // RESPONSE
        .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .statusLine(Matchers.containsString("HTTP"))
            .time(Matchers.lessThan(5000L));
    }
}