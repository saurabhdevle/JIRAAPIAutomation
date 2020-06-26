package JiraDemo;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;

public class JiraApiUser {

 static String CREATE_PATH = "/rest/auth/1/session";
 static String Issue_path = "/rest/api/2/issue";
	

	@Test(enabled = true)
	public static void createSessionData() throws IOException {
		RestAssured.baseURI = "http://localhost:8090";
		SessionFilter session = new SessionFilter();
		String body = JiraPayload.getSessionData();
		String updatedData = String.format(body, "saurabhdevle", "123456");

		System.out.println("Updated data" + updatedData);

		given().log().all()
				// .header("content-type", "application/json")
				.contentType(ContentType.JSON).body(updatedData).log().all().filter(session).when().post(CREATE_PATH)
				.then().log().all().assertThat().statusCode(200);

		String str = generateStringFromFile(
				"C:\\Saurabh\\Automation\\RestAssuredAutomation\\JIRA_API\\Doc\\Issuedata.json");

		given().log().all()
				// .header("content-type", "application/json")
				.contentType(ContentType.JSON).body(str).log().all().filter(session).when().post(Issue_path)
				.then().log().all().assertThat().statusCode(201);

	}

	public static String generateStringFromFile(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));
	}

	@Test(enabled = true)
	public static void createIssueData() throws IOException {
		/*
		 * String str = generateStringFromFile(
		 * "C:\\Saurabh\\Automation\\RestAssuredAutomation\\JIRA_API\\Doc\\Issuedata.json"
		 * );
		 * 
		 * given().log().all() //.header("content-type", "application/json")
		 * .contentType(ContentType.JSON) .body(str).log().all() .filter(session)
		 * .when() .post("/rest/api/2/issue")
		 * .then().log().all().assertThat().statusCode(200);
		 */
	}

}
