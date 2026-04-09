package authenticationPackageHTTPBin;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class BearerAuth {
	@Test
	public void authTest() {
		
		
		// PRE CONDITION
		given()
			.auth().oauth2("baby boy")
		        
		// HTTP METHOD
		.when()
			.get("https://httpbin.org/bearer")
		
		// RESPONSE
		.then()
			.log().all();
	}
}