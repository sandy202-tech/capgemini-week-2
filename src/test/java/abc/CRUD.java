package abc;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUD {
	
	private static String BaseUrl = "http://49.249.28.218:8091";
	private static String ProjectId;
	@BeforeClass
	public void setup() {
		RestAssured.baseURI=BaseUrl;
		System.out.println("BaseUrl = " + RestAssured.baseURI);
	}

	@Test
	public void crud() {
		Response response = RestAssured.given()
				.contentType("application/json")
				.body("{\n" +
                      "  \"createdBy\": \"sabari\",\n" +
                      "  \"projectName\": \"sabari_Project11\",\n" +
                      "  \"status\": \"Created\",\n" +
	                  "  \"teamSize\": 0\n" +
	                  "}")
				.when()
				.post("/addProject");
		
				response.then().log().all();
		
				
				Assert.assertEquals(response.getStatusCode(), 201);
				
				ProjectId = response.jsonPath().getString("projectId");
				System.out.println("Created Project ID: " + ProjectId);
    }
	
	@Test(dependsOnMethods = "crud")
	public void getSingleProject() {
	    Response response = RestAssured.given()
	            .pathParam("projectId", ProjectId)
	            .when()
	            .get("/project/{projectId}");

	    response.then().log().all();

	    Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(dependsOnMethods = "getSingleProject")
	public void updateSingleProject() {
	    Response response = RestAssured.given()
	            .contentType("application/json")
	            .pathParam("projectId", ProjectId)
	            .body("{\n" +
	                  "  \"createdBy\": \"sabari\",\n" +
	                  "  \"projectName\": \"sabari_Project_Updated\",\n" +
	                  "  \"status\": \"Ongoing\"\n" +
	                  "}")
	            .when()
	            .put("/project/{projectId}");

	    response.then().log().all();

	    Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(dependsOnMethods = "updateSingleProject")
	public void updateProjectUsingPatchApi() {
	    Response response = RestAssured.given()
	            .contentType("application/json")
	            .pathParam("id", ProjectId)
	            .body("{\n" +
	                  "  \"status\": \"Completed\"\n" +
	                  "}")
	            .when()
	            .patch("/project/{id}");

	    response.then().log().all();

	    Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(dependsOnMethods = "updateProjectUsingPatchApi")
	public void deleteSingleProject() {
	    Response response = RestAssured.given()
	            .pathParam("projectId", ProjectId)
	            .when()
	            .delete("/project/{projectId}");

	    response.then().log().all();

	    Assert.assertEquals(response.getStatusCode(), 204);
	}
		
	
}