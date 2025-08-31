package com.api.base;

import com.api.model.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
	
	private static final String Base_PATH = "/api/users";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(Base_PATH + "/profile");
	}
	
	public Response updateProfile(String token, ProfileRequest payload) {
		setAuthToken(token);
		return putRequest(payload, Base_PATH + "/profile");
	}
	
	public Response updateProfilePartially(String token, ProfileRequest payload) {
		setAuthToken(token);
		return patchRequest(payload, Base_PATH + "/profile");
	}

}
