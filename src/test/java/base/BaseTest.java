package base;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.HomePage;
import pages.LoginPage;
import utils.PlaywrightFactory;


public class BaseTest {

	PlaywrightFactory pf;
	protected Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected LoginPage loginPage;

	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();

		page = pf.initBrowser(prop);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}