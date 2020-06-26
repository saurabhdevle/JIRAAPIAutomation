package com.jira.UNandPWD;

public class Payload {
	public static final  String account_crt="/rest/auth/1/session";
	
	public static String requestBody() {
		return "{\r\n" + 
				"	    \"username\":\"saurabhdevle\",\r\n" + 
				"	    \"password\": \"123456\"\r\n" + 
				"	    \r\n" + 
				"	}";

	}
	
	public static final  String account_crt_issue="/rest/api/2/issue";
	public static String createIssue() {
		
	return "{\n" + 
			"    \"fields\": {\n" + 
			"       \"project\":\n" + 
			"       {\n" + 
			"          \"key\": \"SAUR\"\n" + 
			"       },\n" + 
			"       \"summary\": \"Creating a new story for false ceiling\",\n" + 
			"       \"description\": \"Living room false ceiling\",\n" + 
			"       \"issuetype\": {\n" + 
			"          \"name\": \"Story\"\n" + 
			"       }\n" + 
			"   }\n" + 
			"}";

	}

}

