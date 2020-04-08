package mmpsquadron_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AP_LogoutPage {
	
	WebDriver driver;
	
	String logoutLinkXpath = "//span[contains(text(),'Logout')]";
	String adminLoginPageHeader = "//h1[contains(text(),'Admin Login')]";

	public AP_LogoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean logoutAdminPortal(WebDriver driver) {
		
		WebElement logoutButton = driver.findElement(By.xpath(logoutLinkXpath));
		logoutButton.click();
		
		String expectedAdminHeader ="Admin Login";
		
		WebElement adminHeader = driver.findElement(By.xpath(adminLoginPageHeader));
		boolean result = expectedAdminHeader.equals(adminHeader.getText());
		
		return result;
		
		
		//return true;
	}

}
