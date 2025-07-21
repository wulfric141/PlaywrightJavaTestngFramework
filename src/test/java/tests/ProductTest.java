package tests;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.PageTitleConstants;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtil;

public class ProductTest extends BaseTest{

	@Test
	public void verifyProductAtHomePage(Method method) {
		 String testCaseName = method.getName(); 
		 Map<String, String> data = ExcelUtil.getTestCaseData("Sheet1", testCaseName);
	      System.out.println("map" + data);
		  LoginPage loginPage=new LoginPage(page);
	      loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	      HomePage homePage=new HomePage(page);
	      String actProductName=homePage.getProductName();
	      System.out.println("UI: " + actProductName);
	      System.out.println("excel: " + data.get("productName"));
	      Assert.assertEquals(actProductName, data.get("productName"));   
	}
}
