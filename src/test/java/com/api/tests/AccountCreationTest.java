package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	
	@Test
	public void createAccountTest() {
		
		
		
		AuthService authService = new AuthService();
		
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder().email("lkmk@gk.com").firstName("mkmkmk").lastName("mk").password("mkmkmkmk").username("lkmkmk").mobileNumber("9999999945").build();
		
		Response response = authService.signUp(signUpRequest);
		
		System.out.println(response);
		
		Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
	}

}
