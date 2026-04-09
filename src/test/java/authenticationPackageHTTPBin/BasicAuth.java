package authenticationPackageHTTPBin;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class BasicAuth {
	@Test
	public void authTest() {
		
		// PRE CONDITION
		given()
			.pathParam("user", "admin")
			.pathParam("passwd", "password123")
			.auth().basic("admin", "password123")
		        
		// HTTP METHOD
		.when()
			.get("https://httpbin.org/basic-auth/{user}/{passwd}")
		
		// RESPONSE
		.then()
			.log().all();
	}
}