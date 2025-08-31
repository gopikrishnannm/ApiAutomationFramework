package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPasswordTest() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("gk@gmail.com");
		System.out.println(response.asPrettyString());
	}
}
