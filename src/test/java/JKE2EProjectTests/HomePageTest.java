package JKE2EProjectTests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.base;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
		new LoginPage(driver);
		LoginPage.loginToApplication();		
		log.info("Login Successfull");
	}

	@Test(description="Verify all the side menu items are displayed")
	public void HomeTest() throws IOException {

		//new HomePage(driver);
		SoftAssert Assert = new SoftAssert();		
		Assert.assertEquals(HomePage.getUserIdText(), "John Smith", "User Id in the home page not matching");;
		log.info("User id verified");
		Assert.assertEquals(HomePage.getDashboardTitleText(), "Dashboard", "Dashboard Title in the home page not matching");;
		log.info("Verifying Side menu links");
		Assert.assertTrue(HomePage.isCatalogMenuDisplayed(),"Catalog Menu not displayed");
		Assert.assertTrue(HomePage.isConfigurationMenuDisplayed(),"Configuration Menu not displayed");
		Assert.assertTrue(HomePage.isContMgmntMenuDisplayed(),"Content Management Menu not displayed");
		Assert.assertTrue(HomePage.isCustomersMenuDisplayed(),"Customers Menu not displayed");
		Assert.assertTrue(HomePage.isPromotionsMenuDisplayed(),"Promotions Menu not displayed");
		Assert.assertTrue(HomePage.isReportsMenuDisplayed(),"Reports Menu not displayed");
		Assert.assertTrue(HomePage.isSalesMenuDisplayed(),"Sales Menu not displayed");
		Assert.assertTrue(HomePage.isSystemMenuDisplayed(),"Systems Menu not displayed");
		Assert.assertAll();
		log.info("Side menu verification completed");
		HomePage.clickLogoutlink();

	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}


