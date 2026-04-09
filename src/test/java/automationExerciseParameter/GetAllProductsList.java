package automationExerciseParameter;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetAllProductsList {
	@Test
	public void getProductsTest() {
		// PRE CONDITION
			RestAssured.given()
				.queryParam("email", "test@gmail.com")
	        
		// HTTP METHOD
			.when()
				.get("https://automationexercise.com/api/getUserDetailByEmail")
			
		// RESPONSE
			.then()
				.log().all();
	}

}
