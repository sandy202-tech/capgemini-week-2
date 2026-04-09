package authenticationPackageHTTPBin;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DigestAuth {
	@Test
	public void authTest() {
		
		// PRE CONDITION
		given()
			.pathParam("qop", "auth")
			.pathParam("user", "admin")
			.pathParam("passwd", "password123")
			.auth().digest("admin", "password123")
		        
		// HTTP METHOD
		.when()
			.get("https://httpbin.org/digest-auth/{qop}/{user}/{passwd}")
		
		// RESPONSE
		.then()
			.log().all();
	}
}