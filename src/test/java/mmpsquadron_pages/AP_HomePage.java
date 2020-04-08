package mmpsquadron_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AP_HomePage {
	
	WebDriver driver;
	
	// xpath for the patient link on the home page
	String patientLinkXpath = "//span[contains(text(),'Patients')]";
	
	// Admin Portal header text xpath -> needed to verify if the link on patient takes it to admin portal page. 
	String adminPortalHeaderXpath = "//h3[@class='panel-title']";
	// Admin Portal header text  -> needed to verify if the link on patient takes it to admin portal page. 
	String expectedAPPortalHeadertext = "Admin Portal";
	
	public AP_HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean clickPatientLink() {
		
		WebElement patientLink = driver.findElement(By.xpath(patientLinkXpath));
		patientLink.click();
		
		WebElement adminPortalHeader = driver.findElement(By.xpath(adminPortalHeaderXpath));
	
		String actualAPPortalHeaderText = adminPortalHeader.getText();
		// result = 0 when the values are same. 
		int result = expectedAPPortalHeadertext.compareTo(actualAPPortalHeaderText);
		
		if(result == 0) {
			System.out.println("Admit portal logged in successfully");
			return true;
		}else {
			System.out.println("Admit portal login failed");
			return false;
		}
		
	}

}
