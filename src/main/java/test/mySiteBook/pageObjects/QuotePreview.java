package test.mySiteBook.pageObjects;

import java.util.List;

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

	@FindBy(xpath = "//table/tbody/tr[@class='sub-section-row']")
	List<WebElement> rowsCount;

	public String getQuotationTitle() {
		String quoationName = quotationName.getText();
		return quoationName;
	}

	public String getProjectName() {
		String projectName1 = projectName.getText();
		return projectName1;
	}

	public void validateCost() {
		try {
			Thread.sleep(3000);

			for (int i = 1; i < rowsCount.size(); i++) {
				int tr = 1;
				while (true) {
					List<WebElement> nextSubSectionRow = driver
							.findElements(By.xpath("//table/tbody/tr[@class='sub-section-row'][" + i
									+ "]/following-sibling::tr[" + tr + "][@class='sub-section-row']"));

					// Break the loop if the next 'sub-section-row' is found
					if (!nextSubSectionRow.isEmpty()) {
						break;
					}

					String quanity = driver.findElement(By.xpath("//table/tbody/tr[@class='sub-section-row'][" + i
							+ "]/following-sibling::tr[" + tr
							+ "]/td[count(//table[@class='table']/thead/tr/th[text()='Quantity']/preceding-sibling::th)+1]"))
							.getText().trim();
					String rate = driver.findElement(By.xpath("//table/tbody/tr[@class='sub-section-row'][" + i
							+ "]/following-sibling::tr[" + tr
							+ "]/td[count(//table[@class='table']/thead/tr/th[text()=' Rate (₹)']/preceding-sibling::th)+1]"))
							.getText().trim();

					if (!quanity.isEmpty() && !rate.isEmpty()) {
						double total = Double.parseDouble(quanity.replace(",", ""))
								* Double.parseDouble(rate.replace(",", ""));

						System.out.println("The total cost of " + quanity + "and " + rate + " = " + total);
						tr++;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
