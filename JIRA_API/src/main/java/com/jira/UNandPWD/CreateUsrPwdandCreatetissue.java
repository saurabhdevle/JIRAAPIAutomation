package com.jira.UNandPWD;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class CreateUsrPwdandCreatetissue {
	
	static SessionFilter session = new SessionFilter();
	static String createsession="/rest/auth/1/session";
	static String createissue="/rest/api/2/issue";
	
	public static void main(String[] args) throws IOException {
		RestAssured.baseURI = "http://localhost:8090";
		 createSession();
		 cerateIssue();
		
	}
		
		
		public  static void createSession(){
		     String responsebody = given().log().all().header("content-type", "application/json")
				.body(Payload.requestBody())
				.filter(session).when()
				.post(createsession).then().log().all()
				.assertThat().statusCode(200).extract().asString();
				System.out.println(responsebody);
		}
	
		
	public static void	cerateIssue() throws IOException
		{
		RestAssured.baseURI = "http://localhost:8090";
		String filereader = generateStringFromFile("C:\\Saurabh\\Automation\\RestAssuredAutomation\\JIRA_API\\src\\test\\resources\\CeateIssue.json");
		given().log().all().header("content-type", "application/json")
		.body(filereader)
		.filter(session)
		.when()
		.post(createissue).then().log().all()
		.assertThat().statusCode(201);
		
		}
	

	private static String generateStringFromFile(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
