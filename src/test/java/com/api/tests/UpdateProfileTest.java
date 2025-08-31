package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.ProfileRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void UpdateProfileTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("gknm", "gkgkgk"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		System.out.println("-----------------------------------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
//		response = userProfileManagementService.getProfile(loginResponse.getToken());
//		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		
		
		System.out.println("-------------------------------------------------");
		
		

		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.email("fullupdatedgk@gmail.com")
				.firstName("gk")
				.lastName("nm")
				.mobileNumber("9999999923")
				.build();
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		
		System.out.println(response.asPrettyString());
		
		
		
		
	}
	
}
