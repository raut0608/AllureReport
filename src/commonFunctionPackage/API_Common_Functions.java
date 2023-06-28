package commonFunctionPackage;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import io.restassured.RestAssured;


public class API_Common_Functions {

	@BeforeTest
	public static int response_statusCode(String baseURI, String resource, String requestBody) 
	{
		RestAssured.baseURI=baseURI;
		
		int status_Code=given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().statusCode();
		
		return status_Code;
	}

	public static String response_Body(String baseURI, String resource, String requestBody) 
	{
		RestAssured.baseURI=baseURI;

		String responseBody = given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().response().asString();
		
		return responseBody;	
	}


	
}
