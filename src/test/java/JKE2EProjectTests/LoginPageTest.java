package JKE2EProjectTests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.base;
import pageObjects.LoginPage;

public class LoginPageTest extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}
	
	@Test(dataProvider = "getData",description="Verify logging in with two different users")
	public void LoginTest(String username, String password,String text) throws IOException
	{
		new LoginPage(driver);
		LoginPage.loginToApplication();		
		log.info("Login Successfull");
		System.out.println("User Type: " + text);
	}
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//For sending three values two times, then [2][3]
		//Column stands for number of values
		Object[][] data = new Object[2][3];
		data[0][0] = "admin@yourstore.com";
		data[0][1] = "admin";
		data[0][2] = "SuperAdmin";
		data[1][0] = "ADMIN@YOURSTORE.com";
		data[1][1] = "admin";
		data[1][2] = "Admin";		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
