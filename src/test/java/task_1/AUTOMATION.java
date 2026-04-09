package task_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AUTOMATION {
	final String BASE_URL = "https://automationexercise.com/api";
	String update = "{ \"email\": \"john.doe@example.com\", \"birth_date\": \"30\", \"birth_month\": \"11\", \"birth_year\": \"2004\", \"zipcode\": \"600099\" }";
	
	@Test
	void createUserAccount() {
		
		RestAssured.given()
        .contentType("application/x-www-form-urlencoded")
        .formParam("name", "hartin Doe")
        .formParam("email", "hartin.doe@example.com")
        .formParam("password", "SecurePass123")
        .formParam("title", "Mr")
        .formParam("birth_date", "15")
        .formParam("birth_month", "June")
        .formParam("birth_year", "1998")
        .formParam("firstname", "John")
        .formParam("lastname", "Doe")
        .formParam("company", "Tech Solutions Pvt Ltd")
        .formParam("address1", "123 Anna Nagar Street")
        .formParam("address2", "Near Metro Station")
        .formParam("country", "India")
        .formParam("zipcode", "600040")
        .formParam("state", "Tamil Nadu")
        .formParam("city", "Chennai")
        .formParam("mobile_number", "9876543210")

    .when()
        .post(BASE_URL + "/createAccount")

    .then()
        .log().all();
	}
	
	@Test
	void getUserByID() {
		RestAssured.given()
		.formParam("email", "hartin.doe@example.com")
			.when()
				.get(BASE_URL + "/getUserDetailByEmail")
			.then().log().all();
	}
	
	@Test
	void deleteUser() {
		RestAssured.given()
			.formParam("email", "hartin.doe@example.com")
			.formParam("password", "SecurePass123")
			
			.when()
				.delete(BASE_URL + "/deleteAccount")
			.then().log().all();
	}
	
	@Test
	void updateAccount() {
		RestAssured.given()
			.formParam("email", "hartin.doe@example.com")
			.formParam("password", "SecurePass123")
			.formParam("birth_date", "30")
	        .formParam("birth_month", "11")
	        .formParam("birth_year", "2004")
	        .formParam("zipcode", "600099")
			
			.when()
				.put(BASE_URL + "/updateAccount")
			.then().log().all();
	}
	
	
}
