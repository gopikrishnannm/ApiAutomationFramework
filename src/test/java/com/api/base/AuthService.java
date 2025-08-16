package com.api.base;

import com.api.model.request.LoginRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH = "/api/auth/";
	
	
	public Response login(LoginRequest loginRequest) {
		return postRequest(loginRequest, BASE_PATH+"login");
	}
	

}
