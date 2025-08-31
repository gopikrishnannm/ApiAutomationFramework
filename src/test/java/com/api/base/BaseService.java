  package com.api.base;

import com.api.filter.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecificatoin;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	
	public BaseService() {
		requestSpecificatoin = RestAssured.given().baseUri(BASE_URL);
	}
	
	public void setAuthToken(String token) {
		requestSpecificatoin.header("Authorization", "Bearer "+token);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecificatoin.get(endpoint);	
	}
	
	protected Response postRequest(Object payload,String endpoint) {
		return requestSpecificatoin.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response putRequest(Object payload,String endpoint) {
		return requestSpecificatoin.contentType(ContentType.JSON).body(payload).put(endpoint);
	}
	
	protected Response patchRequest(Object payload,String endpoint) {
		return requestSpecificatoin.contentType(ContentType.JSON).body(payload).patch(endpoint);
	}
	


	
	
	

}
