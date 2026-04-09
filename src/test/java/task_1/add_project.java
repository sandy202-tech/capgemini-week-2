package task_1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LotOfFun {
	
	final String BASE_URL = "https://petstore.swagger.io/v2";
	final String ID = 9223372036854775807l + "";
	
	
//	@Test
	void postPet(){
		RestAssured.given()
			.formParam("name","kamal")
			.pathParam("petID", ID)
			
			.when()
				.post("https://petstore.swagger.io/v2/pet/{petID}")
			.then().log().all();
	}
	
//	@Test
	void createPet() {
		RestAssured.given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"category\": {\r\n"
					+ "    \"id\": 0,\r\n"
					+ "    \"name\": \"string\"\r\n"
					+ "  },\r\n"
					+ "  \"name\": \"kamala\",\r\n"
					+ "  \"photoUrls\": [\r\n"
					+ "    \"string\"\r\n"
					+ "  ],\r\n"
					+ "  \"tags\": [\r\n"
					+ "    {\r\n"
					+ "      \"id\": 0,\r\n"
					+ "      \"name\": \"string\"\r\n"
					+ "    }\r\n"
					+ "  ],\r\n"
					+ "  \"status\": \"available\"\r\n"
					+ "}")
			.when()
				.post(BASE_URL + "/pet")
			.then().log().all();
	}
	
	@Test
	void uploadImage() {
		
		File image = new File("C:\\Users\\HARWIN S\\OneDrive\\Pictures\\blackHole.jpeg");
		
		RestAssured.given()
		.pathParam("petID", ID)
		.multiPart(image)
		
		.when()
			.post("https://petstore.swagger.io/v2/pet/{petID}/uploadImage")
		.then().log().all();
	}
	
}
