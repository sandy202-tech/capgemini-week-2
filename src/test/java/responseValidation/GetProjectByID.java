package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetProjectByID {
	@Test
	public void getProjectTest() {
		
		// PRE CONDITION
		given()
        
		// HTTP METHOD
		.when()
			.get("http://49.249.28.218:8091/project/NH_PROJ_039")
		
	// RESPONSE
		.then()
			.log().all()
			.assertThat()
				.statusCode(200)
				.statusLine(containsString("HTTP"))
				.contentType("application/json")
				.header("Pragma", "no-cache")
				.body("projectName", equalTo("Eterna"))
				.time(lessThan(5000l));
				
		}
}
