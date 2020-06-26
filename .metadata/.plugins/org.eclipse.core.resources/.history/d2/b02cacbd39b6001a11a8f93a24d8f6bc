package com.jiraapisusingjsonfile;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;

public class Testjira {
	
	public static final String CREATE_SESSION="/rest/auth/1/session";
	public static final String CREATE_ISSUE="/rest/api/2/issue";
	
	@Test
	public static void createSession() throws IOException {
		RestAssured.baseURI="http://localhost:8082";
		
		SessionFilter filter=new SessionFilter();
		
		String updatedbody="{\r\n" + 
				"	\"username\":\"AdityaPatil\",\r\n" + 
				"	\"password\":\"adityapatil29\"\r\n" + 
				"	\r\n" + 
				"}";
		
		given().log().all().contentType(ContentType.JSON)
		.body(updatedbody).log().all().filter(filter)
		.when().post(CREATE_SESSION)
		.then().log().all().assertThat().statusCode(200);
		
		String s=Stringfromfile("C:\\Users\\Hp\\eclipse-workspace\\Assignment\\Input\\Payload.json");
		
		given().log().all().contentType(ContentType.JSON)
		.body(s).log().all().filter(filter).log().all()
		.when().post(CREATE_ISSUE)
		.then().log().all().statusCode(201);
		
	}
	public static String Stringfromfile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}

}
