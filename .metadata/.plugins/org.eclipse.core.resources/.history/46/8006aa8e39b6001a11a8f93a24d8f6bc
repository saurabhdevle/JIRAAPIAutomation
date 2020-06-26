package com.jira.apis;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;


public class Firstsampletest {
	public static final String CREATE_PATH="/rest/auth/1/session";
	public static final String CREATE_ISSUE="/rest/api/2/issue";
	
	@Test(enabled = true)
	public static  void testUserdetail() {
     RestAssured.baseURI="http://localhost:8082";
     
     SessionFilter session=new SessionFilter();   
    
     given().log().all().contentType(ContentType.JSON)
     .body(Payload.reqBody()).filter(session)
     .when().post(CREATE_PATH)
     .then().log().all().assertThat().statusCode(200)
     .extract().body().asString();
     		
		given().log().all().contentType(ContentType.JSON)
		.body(Payload.createIssue()).filter(session)
		.log().all().when().post(CREATE_ISSUE)
		.then().log().all().assertThat().statusCode(201)
		.extract().body().asString();
		 
	}



}
