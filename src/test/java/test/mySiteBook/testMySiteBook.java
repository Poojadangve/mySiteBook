package test.mySiteBook;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import test.mySiteBook.pageObjects.LoginPage;
import test.mySiteBook.pageObjects.ProjectPage;
import test.mySiteBook.pageObjects.QuotePreview;
import test.mySiteBook.pageObjects.QuotesAllPage;
import test.mySiteBook.test.BaseTest;

public class testMySiteBook extends BaseTest {

	@Test
	public void validation() throws Exception {
		String expectedSampleProject = "Sample Bungalow Project G+1 - Detailed Estimate";
		String expectedQuotesTitle = "Detailed Estimate";
		LoginPage loginPage = landingPage.goTo();

		ProjectPage projectPage = loginPage.moveToLoginPage("7821049181", "Test@123");

		Thread.sleep(3000);

		List<WebElement> allSampleProjects = projectPage.getAllSampleProject();
		QuotesAllPage quotesTitle = projectPage.selectProject(expectedSampleProject);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> allQuotesTitle = quotesTitle.getAllQuotesTitle();
		QuotePreview quotePreview = quotesTitle.selectQuotesTitle(expectedQuotesTitle);
		
		 String quotationTitle = quotePreview.getQuotationTitle();
		 Assert.assertEquals(quotationTitle, expectedQuotesTitle);
		 
		 String actualProjectName = quotePreview.getProjectName();
		 Boolean result =  expectedSampleProject.contains(actualProjectName);
		

		// String quotationTitlle =
		// driver.findElement(By.xpath("//span[@class='fw-normal']")).getText();

		// Assert.assertEquals(expectedQuotesTitle, quotationTitlle);

		/*
		 * List<WebElement> tableOption =
		 * driver.findElements(By.xpath("//tbody/tr[@class='sub-section-row']"));
		 * 
		 * for (int i = 0; i < tableOption.size(); i++) {
		 * 
		 * }
		 */

	}

}
