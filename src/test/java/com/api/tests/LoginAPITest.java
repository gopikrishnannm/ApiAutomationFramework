package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {
	

	@Test(description = "To verify login api is working")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("gknm", "gkgkgk");
		
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		
		
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
	
	/*
	@Test
	public void testLogin() {
	    RestAssured.given()
	        .baseUri("http://64.227.160.186:8080")
	        .contentType(ContentType.JSON)
	        .body("{ \"username\": \"uday1234\", \"password\": \"uday1234\" }")
	    .when()
	        .post("/login")
	    .then()
	        .statusCode(200)
	        .body("token", notNullValue());
	}
	*/

}
