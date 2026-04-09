package automationExerciseParameter;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class SearchProduct {
	@Test
	public void searchProductsTest() {
		// PRE CONDITION
			RestAssured.given()
			.formParam("search_product", "top")
	        
		// HTTP METHOD
			.when()
				.post("https://automationexercise.com/api/searchProduct")
			
		// RESPONSE
			.then()
				.log().all();
	}
}
