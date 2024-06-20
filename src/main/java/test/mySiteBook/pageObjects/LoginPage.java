package test.mySiteBook.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.mySiteBook.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(linkText = "LOGIN")
	WebElement clickOnLoginButton;
	
	By waitForContactField = By.xpath("//div[@class='w-75']/child::input");
	@FindBy(xpath = "//div[@class='w-75']/child::input")
	WebElement enterContactNumber;
		
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement clickOnContinueButton;
	
	By waitForPasswordField = By.xpath("//input[@type='password']");
	@FindBy(xpath = "//input[@type='password']")
	WebElement enterPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement onLoginPageClickOnLogin;

	
	public ProjectPage moveToLoginPage(String phnNum, String password)
	{
		clickOnLoginButton.click();	
		
		Set<String> window = driver.getWindowHandles();
		
		
		Iterator<String> it = window.iterator();
		
		String homeWindow = it.next();
		
		String loginWindow = it.next();
		
		driver.switchTo().window(loginWindow);
		
		
		waitForElementToAppear(waitForContactField);
		
		
		enterContactNumber.sendKeys(phnNum);
		
		clickOnContinueButton.click();

		waitForElementToAppear(waitForPasswordField);
		
		enterPassword.sendKeys(password);
		
		onLoginPageClickOnLogin.click();
		
		ProjectPage projectPage = new ProjectPage(driver);
		return projectPage;

	}


}
