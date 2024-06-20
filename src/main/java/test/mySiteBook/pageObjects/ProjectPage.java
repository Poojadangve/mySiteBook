package test.mySiteBook.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.mySiteBook.AbstractComponents.AbstractComponents;

public class ProjectPage extends AbstractComponents {

	WebDriver driver;

	public ProjectPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='container-fluid']/div/mbc-projects-card/descendant::span")
	List<WebElement> allSampleProjects;

	public List<WebElement> getAllSampleProject() {
		return allSampleProjects;
	}

	public QuotesAllPage selectProject(String projectName) throws Exception {
		// String expectedSampleProject = "Sample Bungalow Project G+1 - Detailed
		// Estimate";

		String expectedSampleProject = projectName;
		for (int i = 0; i < allSampleProjects.size(); i++) {
			Thread.sleep(5000);
			String getSampleProject = allSampleProjects.get(i).getText();
			Thread.sleep(3000);
			if (getSampleProject.equalsIgnoreCase(expectedSampleProject)) {
				System.out.println(allSampleProjects.get(i).getText());
				allSampleProjects.get(i).click();
				break;

			}
		}
		
		QuotesAllPage quotesTitle = new QuotesAllPage(driver);
		return quotesTitle;
	}

}
