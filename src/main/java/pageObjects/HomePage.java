package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class HomePage extends base {
	
	@FindBy(xpath = "//*[@id=\'navbarText\']/ul/li[2]/a")
	private static WebElement useridtext;

	@FindBy(xpath = "//h1[normalize-space()='Dashboard']")
	private static WebElement dashboardtitle;

	@FindBy(linkText = "Logout")
	private static WebElement logoutlink;

	@FindBy(xpath = "//p[normalize-space()='Catalog']")
	private static WebElement sidemenu_Catalog;

	@FindBy(xpath = "//p[normalize-space()='Sales']")
	private static WebElement sidemenu_Sales;

	@FindBy(xpath = "//p[normalize-space()='Content management']")
	private static WebElement sidemenu_Cont_mgmnt;

	@FindBy(xpath = "//p[normalize-space()='Customers']")
	private static WebElement sidemenu_Customers;

	@FindBy(xpath = "//p[normalize-space()='Promotions']")
	private static WebElement sidemenu_Promotions;

	@FindBy(xpath = "//p[normalize-space()='Configuration']")
	private static WebElement sidemenu_Confgigutration;

	@FindBy(xpath = "//p[normalize-space()='System']")
	private static WebElement sidemenu_System;

	@FindBy(xpath = "//p[normalize-space()='Reports']")
	private static WebElement sidemenu_Reports;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	private static WebElement sideMenu_customer_link;

	@FindBy(xpath = "//p[normalize-space()='Customer roles']")
	private static WebElement sideMenu_customer_role_link;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	public static String getUserIdText()
	{
		return HomePage.useridtext.getText();
	}
	public static void clickLogoutlink() {

		logoutlink.click();
	}

	public static void customerRoleSideMenuClick()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",sideMenu_customer_role_link);

	}
	public static CustomerPage customerSideMenuClick()
	{
		sideMenu_customer_link.click();
		return new CustomerPage(driver);
	}

	public static String getDashboardTitleText()
	{
		return dashboardtitle.getText();
	}
	public static boolean isCatalogMenuDisplayed()
	{
		return sidemenu_Catalog.isDisplayed();	
	}
	public static boolean isConfigurationMenuDisplayed()
	{
		return sidemenu_Confgigutration.isDisplayed();	
	}
	public static boolean isContMgmntMenuDisplayed()
	{
		return sidemenu_Cont_mgmnt.isDisplayed();	
	}
	public static boolean isCustomersMenuDisplayed()
	{
		return sidemenu_Customers.isDisplayed();	
	}
	public static boolean isPromotionsMenuDisplayed()
	{
		return sidemenu_Promotions.isDisplayed();	
	}
	public static boolean isReportsMenuDisplayed()
	{
		return sidemenu_Reports.isDisplayed();	
	}
	public static boolean isSalesMenuDisplayed()
	{
		return sidemenu_Sales.isDisplayed();	
	}
	public static boolean isSystemMenuDisplayed()
	{
		return sidemenu_System.isDisplayed();	
	}


}
