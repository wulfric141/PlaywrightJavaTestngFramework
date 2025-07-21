package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// 1. String Locators - OR
	private String usernameField = "#user-name";
	private String passwordField = "#password";
	private String loginButton = "#login-button";
	
	

	// 2. page constructor:
	public LoginPage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getLoginPageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}
	
	public void doLogin(String username, String password) {
		page.locator(usernameField).fill(username);
		page.locator(passwordField).fill(password);
		page.locator(loginButton).click();
	
	}
}
