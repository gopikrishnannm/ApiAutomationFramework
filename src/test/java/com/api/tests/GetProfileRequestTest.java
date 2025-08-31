package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileInfoTest() {
		
		// Extracting auth token from login request
		AuthService authServie = new AuthService();
		Response response = authServie.login(new LoginRequest("gknm", "gkgkgk"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		//String token = loginResponse.getToken();
			
		// Passing token to get access for account access
		
		UserProfileManagementService userProfileManagementService = 
				new UserProfileManagementService();
		
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse UserProfileResponse = response.as(UserProfileResponse.class);
		
		Assert.assertEquals(UserProfileResponse.getUsername(), "gknm");
		
	}
}
