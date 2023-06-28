package testClassPackage;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctionPackage.API_Common_Functions;
import commonFunctionPackage.Utility_Common_Function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_Req_Repository;

public class Post_TC4 {

	@Test
	public static void execute() throws IOException 
	{
		for(int i=0;i<5;i++)
		{
			int statusCode=API_Common_Functions.response_statusCode(Post_Req_Repository.baseURI(), Post_Req_Repository.post_resource(), Post_Req_Repository.post_req_tc4());
			System.out.println(statusCode);
			if(statusCode==201)
			{
				String responseBody=API_Common_Functions.response_Body(Post_Req_Repository.baseURI(), Post_Req_Repository.post_resource(), Post_Req_Repository.post_req_tc4());
				System.out.println(responseBody);
				Post_TC4.validator(responseBody, statusCode);
				Utility_Common_Function.evidenceFileCreator("Post_TC4", Post_Req_Repository.post_req_tc4(), responseBody);
				break;
			}
			else
			{
				System.out.println("correct status code is not found hence retrying the API");
			}
		}	
	}	
	public static void validator(String responseBody, int statusCode) throws IOException
	{
		JsonPath jspRes=new JsonPath(responseBody);
		String resName=jspRes.getString("name");
		String resJob=jspRes.getString("job");
		String resId=jspRes.getString("id");
		String resCreatedAt=jspRes.getString("createdAt");
		String actDate=LocalDateTime.now().toString().substring(0, 10);
		
		JsonPath jspReq=new JsonPath(Post_Req_Repository.post_req_tc4());
		String reqName=jspReq.getString("name");
		String reqJob=jspReq.getString("job");
		String expDate=resCreatedAt.substring(0, 10);
		
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(resName, reqName);
		Assert.assertEquals(resJob, reqJob);
		Assert.assertNotNull(resId);
		Assert.assertEquals(expDate, actDate);
	}
}
