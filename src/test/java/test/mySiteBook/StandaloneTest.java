package test.mySiteBook;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StandaloneTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver",
			//	"D:\\Automation\\Software1\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		driver.get("https://mysitebook.io/");
		
		Thread.sleep(3000);
		
	driver.findElement(By.xpath("//div[@id='close']/img")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.linkText("LOGIN")).click();
	
	Set<String> window = driver.getWindowHandles();
	
	
	Iterator<String> it = window.iterator();
	
	String homeWindow = it.next();
	
	String loginWindow = it.next();
	
	driver.switchTo().window(loginWindow);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w-75']/child::input")));
	
	
//	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[@class='w-75']/child::input")).sendKeys("7821049181");
	
	driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@123");
	
	driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	
	Thread.sleep(3000);
	
	 List<WebElement> allSampleProjects = driver.findElements(By.xpath("//div[@class='container-fluid']/div/mbc-projects-card/descendant::span"));
	 
	 String expectedSampleProject = "Sample Bungalow Project G+1 - Detailed Estimate";
	 
	 for(int i = 0;i<allSampleProjects.size();i++)
	 {
		 Thread.sleep(5000);
		 String getSampleProject = allSampleProjects.get(i).getText();
		 Thread.sleep(3000);
		 if(getSampleProject.equalsIgnoreCase(expectedSampleProject))
		 {
			 System.out.println(allSampleProjects.get(i).getText());
			 allSampleProjects.get(i).click();
			 break;
			 
		 }
	 }
	 
	
	 
		
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	 List<WebElement> allQuotesTitle = driver.findElements(By.xpath("//div[@class='visible']/descendant::p[contains(@class,'quote-title-web')]"));
	 
	 String expectedQuotesTitle = "Detailed Estimate";
	 
	 Thread.sleep(3000);
	 for(int i =0; i< allQuotesTitle.size();i++)
	 {
		 Thread.sleep(3000);
		 String getQuotesTotle = allQuotesTitle.get(i).getText();
		 Thread.sleep(3000);
		 if(getQuotesTotle.equals(expectedQuotesTitle))
		 {
			allQuotesTitle.get(i).click(); 
			break;
		 }
	 }
	 
	 String quotationTitlle = driver.findElement(By.xpath("//span[@class='fw-normal']")).getText();
	 
	 
	// Assert.assertEquals(expectedQuotesTitle, quotationTitlle);
	 
	 List<WebElement> tableOption = driver.findElements(By.xpath("//tbody/tr[@class='sub-section-row']"));
	 
	 for(int i = 0;i<tableOption.size();i++)
	 {
		 
	 }
	
	
	}

}
