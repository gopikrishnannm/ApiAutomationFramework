package com.api.filter;

import org.apache.logging.log4j.Logger;

import com.api.listeners.TestListener;
import com.api.utility.LoggerUtility;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	
	private static final Logger logger = LoggerUtility.getLogger(TestListener.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		logRequest(requestSpec);
		
		Response response = ctx.next(requestSpec, responseSpec);
		
		logResponse(response);
		
		return response;
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		
		logger.info("Base URI : "+ requestSpec.getBaseUri());
		logger.info("Request Header:" + requestSpec.getHeaders());
		logger.info("Request Payload "+requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		logger.info("Status code : "+ response.getStatusCode());
		logger.info("Response Header:" + response.getHeaders());
		logger.info("Response Payload "+response.getBody());
	}
	
	

}
