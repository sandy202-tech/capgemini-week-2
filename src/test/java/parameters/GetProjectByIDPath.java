package parameters;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetProjectByIDPath {
	@Test
	public void getProjectTest() {
		// PRE CONDITION
		RestAssured.given()
			.pathParam("projectID", "NH_PROJ_3387")
        
		// HTTP METHOD
			.when()
				.get("http://49.249.28.218:8091/project/{projectID}")
			
		// RESPONSE
			.then()
				.log().all();
	}
}
