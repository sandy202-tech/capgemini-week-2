package parameters;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class SearchProjectByIDQuery {
	@Test
	public void getProjectTest() {
		// PRE CONDITION
		RestAssured.given()
			.queryParam("projectID", "NH_PROJ_3387")
        
		// HTTP METHOD
			.when()
				.get("http://49.249.28.218:8091/project")
			
		// RESPONSE
			.then()
				.log().all();
	}
}
