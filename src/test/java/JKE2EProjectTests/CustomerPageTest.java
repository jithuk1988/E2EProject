package JKE2EProjectTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.base;
import pageObjects.CustomerPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.Utils;

public class CustomerPageTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		new LoginPage(driver);
		LoginPage.loginToApplication();		
	}


	@Test(description = "Verify searching of customers using Email ID")
	public void CustomerPageSearchEmailTest() throws IOException {

		HomePage.customerRoleSideMenuClick();
		HomePage.customerSideMenuClick();
		new CustomerPage(driver);
		CustomerPage.enterSearchEmail("james_pan@nopCommerce.com");
		CustomerPage.searchButtonClick();
		Assert.assertTrue(CustomerPage.isSearchResultDisplayed(),"Search Result missing");
		Assert.assertEquals(CustomerPage.getSearchResultPaginationInfo(), "1-1 of 1 items","Result count not matching");
		log.info("Customer page search by Email completed");
		Utils.ReloadPage(driver);
		
	}
	
	@Test(description = "Verify searching of customers using First Name")
	public void CustomerPageSearchFirstNameTest() throws IOException {


		HomePage.customerRoleSideMenuClick(); 
		HomePage.customerSideMenuClick();
		CustomerPage cp = new CustomerPage(driver);
		cp.get_textbox_firstName_serarch().sendKeys("Arthur");
		cp.get_search_button().click();
		Assert.assertTrue(cp.get_search_firstName_result().isDisplayed());
		Assert.assertEquals(cp.get_grid_result_info().getText(), "1-1 of 1 items");
		log.info("Customer page search by First Name completed");

	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	}
	

