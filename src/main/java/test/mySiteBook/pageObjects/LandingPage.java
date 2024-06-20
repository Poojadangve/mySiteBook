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

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='close']/img")
	WebElement clickOnPopupCloseIcon;
	
	
	public LoginPage goTo() throws Exception {
		driver.get("https://mysitebook.io/");
		
		Thread.sleep(3000);
		
		clickOnPopupCloseIcon.click();
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	

}
