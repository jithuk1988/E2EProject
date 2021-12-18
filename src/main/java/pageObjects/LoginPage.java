package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

import java.io.IOException;
import static util.Utils.*;
public class LoginPage extends base {

	@FindBy(id = "Email")
	private static WebElement txtUsername;

	@FindBy(id = "Password")
	private static WebElement txtPassword;

	@FindBy(xpath = "*//button[contains(text(), 'Log in')]")
	private static WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public static LoginPage clickLogin() {
		
		loginbutton.click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	public static HomePage loginToApplication() throws IOException {
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		String username = readExcelCells("Logins", 1, 0);
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		String password = readExcelCells("Logins", 1, 1);
		txtPassword.sendKeys(password);
		clickLogin();
		return new HomePage(driver);
	}

}
