package apiTests;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.ExcelUtil;
import utils.apiUtils;

public class createUserTest {
	
	
	   @Test
	    public void createUserTest(Method method) {
			 String testCaseName = method.getName(); 
			 Map<String, String> data = ExcelUtil.getTestCaseData("API", testCaseName);
	        String requestBody = data.get("body");
	        System.out.print(requestBody);
	        System.out.print(data.get("endpoint"));

	        Response response = apiUtils.postRequest(data.get("endpoint"), requestBody);

	        Assert.assertEquals(response.getStatusCode(), 201);
	        String id = response.jsonPath().getString("id");
	        Assert.assertNotNull(id);
	    }

}
