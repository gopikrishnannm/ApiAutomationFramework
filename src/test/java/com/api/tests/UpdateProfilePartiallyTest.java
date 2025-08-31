package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.model.request.LoginRequest;
import com.api.model.request.ProfileRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfilePartiallyTest {
	
	@Test
	public void updateProfilePartiallyTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("gknm", "gkgkgk"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.email("new234gknm@gk.com")
				.build();
		
		System.out.println(profileRequest.toString());
		response = userProfileManagementService.updateProfilePartially(loginResponse.getToken(), profileRequest);
		
		System.out.println(response.asPrettyString());
		
	}

}
