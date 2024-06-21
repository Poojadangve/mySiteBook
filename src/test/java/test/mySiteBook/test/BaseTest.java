package test.mySiteBook.test;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.mySiteBook.pageObjects.LandingPage;
import test.mySiteBook.pageObjects.LoginPage;




public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	

	public WebDriver initilazeDriver() throws Exception {

		Properties prop = new Properties();
		// FileInputStream fis = new
		// FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulShettyAcademy//resources//data.properties");

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//test//mySiteBook//resources//data.properties");
		prop.load(fis);

		// String browserName = prop.getProperty("browser");
		String browserName = "chrome";
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
//gecko
		} else if (browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					"D:\\Automation\\Software1\\edgedriver_win64\\msedgedriver.exe");

			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		return driver;

	}
	
	public String getScreenShot(String testcaseName, WebDriver driver) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
	
		File file = new File(System.getProperty("user.dir")+"//reports"+testcaseName+ ".png");
	
		FileUtils.copyFile(src, file);
		
		return System.getProperty("user.dir")+"//reports"+testcaseName+ ".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws Exception {
		driver = initilazeDriver();

		landingPage = new LandingPage(driver);

		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
