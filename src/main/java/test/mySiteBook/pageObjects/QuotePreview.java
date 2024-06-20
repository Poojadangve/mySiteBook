package test.mySiteBook.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotePreview {

	WebDriver driver;

	public QuotePreview(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//label[@class='quote-details']/span")
	WebElement quotationName;
	
	@FindBy(className = "name")
	WebElement projectName;

	public String getQuotationTitle() {
		String quoationName = quotationName.getText();
		return quoationName;
	}
	public String getProjectName() {
		String projectName1 = projectName.getText();
		return projectName1;
	}


}
