package pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;

	// 1. String Locators - OR
	private String productNameLoc = "a[id='item_4_title_link'] div[class='inventory_item_name ']";

	

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}
	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}
	
	public String getProductName() {
		return page.locator(productNameLoc).innerText();
	}

}
