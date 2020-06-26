package JiraDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FirstJiraSampletest {

	String createURI ="/rest/auth/1/session";
	@Test(enabled=true)
	public void testUserdetail() {
		RestAssured.baseURI="http://localhost:8090";
		given().log().all().header("Content-Type","application/json")
		.body(Payload.reqBody()).when().post(createURI)
		.then().log().all().statusCode(200)
		.extract().body().asString();
	}
	
	
	@Test(enabled=false)
	public void projectField() {
		RestAssured.baseURI="http://localhost:8090";
		given().log().all().contentType(ContentType.JSON)
		.body(Payload.reqBody()).when().post(createURI)
		.then().log().all().statusCode(200)
		.extract().body().asString();
	}
	
}
