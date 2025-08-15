package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class LoginAPITest {
	
	
	@Test
	public void loginTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login("{ \"username\": \"string\", \"password\": \"string\" }");
		System.out.println(response.asPrettyString());
		
	}

	/*@Test
	public void loginTest() {
		RestAssured.baseURI="http://64.227.160.186:8080";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y =  x.header("Content-Type", "application/json");
		RequestSpecification z =y.body("{ \"username\": \"string\", \"password\": \"string\" }");
		Response response = z.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		
	}*/
	
	/* @Test
	public void loginTest() {
		
		Response response = given()
				.baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
				.body("{ \"username\": \"string\", \"password\": \"string\" }").post("/api/auth/login");
		System.out.println(response.asPrettyString());
		
		assertEquals(response.getStatusCode(), 200);
		
		
	}*/
	

}
