package base;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public static WebDriver driver;
	public static Properties prop;
	public final String propertiesRelativePath = "\\src\\main\\java\\config\\data.properties";
	public static final String USERNAME = "jithuk1";
	public static final String AUTOMATE_KEY = "FjbUz9MS2BzSTupHYeJP";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 20;
	public static long POLLING_TIME = 250;
	public static String TEST_DATA_PATH = "D:\\Study\\EclipseWorkspace\\E2EProject\\src\\test\\java\\testData\\TestData.xlsx";

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(getAbsoluteFilePath(propertiesRelativePath));
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) 
		{
	        WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browsername.equals("edge")) 
		{
	        WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else if (browsername.equals("firefox")) 
		{
	        WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browsername.equals("remote")) 
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "88");
			driver = new RemoteWebDriver(new URL(URL), caps);

		}
		
		else if (browsername.equals("chromeHeadless")) 
		{
	        WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\Screenshots\\" + testcaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

	public String getAbsoluteFilePath(String RelativePath) {
		String filePath = new File("").getAbsolutePath();
		String propertiesAbsolutePath = filePath.concat(propertiesRelativePath);
		return propertiesAbsolutePath;
	}
}
