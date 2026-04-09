package task_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class botter {
	@Test
	
	public static void lol(){
		
		
		//File json = new File("C:\\Users\\HARWIN S\\eclipse-workspace\\lotOfLove\\src\\test\\resources\\testing.json");
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(new object())
		
		.when()
		     .post("https://petstore.swagger.io/v2/store/order")
		     
		 .then()
		     .statusCode(200)
		     .log().all();
		
	}
}