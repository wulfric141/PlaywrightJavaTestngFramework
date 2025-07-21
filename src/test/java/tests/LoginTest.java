package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import constants.PageTitleConstants;
import pages.HomePage;
import pages.LoginPage;
public class LoginTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageNavigationTest() {
		LoginPage loginPage=new LoginPage(page);
		String actLoginPageTitle=loginPage.getLoginPageTitle();
		System.out.println("page act title: " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, PageTitleConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyLoginSuccessfull() {
	  LoginPage loginPage=new LoginPage(page);
      loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
      HomePage homePage=new HomePage(page);
  	  String actHomePageTitle=homePage.getHomePageTitle();
	  System.out.println("page act title: " + actHomePageTitle);
		Assert.assertEquals(actHomePageTitle, PageTitleConstants.HOME_PAGE_TITLE);
      
      
	}

}
