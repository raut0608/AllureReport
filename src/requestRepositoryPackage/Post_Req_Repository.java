package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.BeforeTest;
import commonFunctionPackage.Utility_Common_Function;


public class Post_Req_Repository {

	@BeforeTest
	public static String baseURI() 
	{
		String baseURI="https://reqres.in";
		return baseURI;
	}
	
	public static String post_resource() 
	{
		String resource="/api/users";
		return resource;
	}
	
	public static String post_req_tc1() throws IOException 
	{
		ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data", "Post_TC1");
		String reqName=data.get(1);
		String reqJob=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+reqName+"\",\r\n"
				+ "    \"job\": \""+reqJob+"\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String post_req_tc2() throws IOException 
	{
		ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data", "Post_TC2");
		String reqName=data.get(1);
		String reqJob=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+reqName+"\",\r\n"
				+ "    \"job\": \""+reqJob+"\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String post_req_tc3() throws IOException 
	{
		ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data", "Post_TC3");
		String reqName=data.get(1);
		String reqJob=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+reqName+"\",\r\n"
				+ "    \"job\": \""+reqJob+"\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String post_req_tc4() throws IOException 
	{
		ArrayList<String> data=Utility_Common_Function.readDataExcel("Post_Test_Data", "Post_TC4");
		String reqName=data.get(1);
		String reqJob=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+reqName+"\",\r\n"
				+ "    \"job\": \""+reqJob+"\"\r\n"
				+ "}";
		return requestBody;
	}
	
}
