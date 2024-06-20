package test.mySiteBook.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.mySiteBook.AbstractComponents.AbstractComponents;

public class QuotesAllPage extends AbstractComponents{
	WebDriver driver;

	public QuotesAllPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[@class='visible']/descendant::p[contains(@class,'quote-title-web')]")
	List<WebElement> allQuotesTitle;
	
	public List<WebElement> getAllQuotesTitle()
	{
		return allQuotesTitle;
	}
	
	public QuotePreview selectQuotesTitle(String quotesTitle) throws Exception
	{
		String expectedQuotesTitle = quotesTitle;

		Thread.sleep(3000);
		for (int i = 0; i < allQuotesTitle.size(); i++) {
			Thread.sleep(3000);
			String getQuotesTotle = allQuotesTitle.get(i).getText();
			Thread.sleep(1000);
			if (getQuotesTotle.equals(expectedQuotesTitle)) {
				allQuotesTitle.get(i).click();
				break;
			}
		}
		QuotePreview quotePreview = new QuotePreview(driver);
		return quotePreview;
	}
	
	
	
	

}
