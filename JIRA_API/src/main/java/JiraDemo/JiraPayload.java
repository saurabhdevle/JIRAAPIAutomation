package JiraDemo;

public class JiraPayload {
	
	
	public static String getSessionData() {
		return "{\r\n" + 
				" \"username\":\"%s\",\r\n" + 
				"\"password\":\"%s\"\r\n" + 
				"}";
		
	}

}
