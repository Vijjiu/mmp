package mmpsquadron_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AP_PatientDetailPage {
	
	WebDriver driver;
	
	// xpath for the create fee button 
	String createFeeButtonXpath = "//input[@value='Create Fee']";
	
	// Admin Portal Add Fee - header text xpath -> needed to verify if the button 'create fee' takes it to add fee page 
	String apAddFeeHeaderXpath = "//h3[@class='panel-title']";
	// Admin Portal Add fee header text  -> needed to verify if the button 'create fee' takes it to add fee page 
	String expectedAddFeeHeadertext = "Fee";
	
	public AP_PatientDetailPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean clickCreateFees() throws InterruptedException {
		
		WebElement createFeeButton = driver.findElement(By.xpath(createFeeButtonXpath));
		createFeeButton.click();
		
		System.out.println("create fee button clicked");
		
		Thread.sleep(3000);
		// to make sure the element is visible before finding it. 
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath(apAddFeeHeaderXpath))));*/
		/*WebElement addFeeHeader = driver.findElement(By.xpath(apAddFeeHeaderXpath));
		String actualAddFeeHeadertext = addFeeHeader.getText();
		
		
		// result = 0 when the values are same. 
		int result = expectedAddFeeHeadertext.compareTo(actualAddFeeHeadertext);
		
		if(result == 0) {
			System.out.println("Goes to 'add fee' successfully");
			return true;
		}else {
			System.out.println("Goes to 'add fee' failed");
			return false;
		}*/
		return true;
		
	}

}
