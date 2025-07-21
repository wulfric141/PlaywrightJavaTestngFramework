package apiTests;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.ExcelUtil;
import utils.apiUtils;

public class UserApiTest {
	
	
	 @Test
	    public void getUserDetails(Method method) {
		 String testCaseName = method.getName(); 
		 Map<String, String> data = ExcelUtil.getTestCaseData("API", testCaseName);
	        Response response = apiUtils.getRequest(data.get("endpoint"));
	        Assert.assertEquals(response.getStatusCode(), 200);
	        String firstName = response.jsonPath().getString("data.first_name");
	        System.out.println("First Name: " + firstName);
	    }


}
