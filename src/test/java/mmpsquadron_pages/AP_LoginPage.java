package mmpsquadron_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AP_LoginPage {
	
	
	WebDriver driver;
	
	private String adminUserName = "Thomas_444";
	private String adminPassword ="Edison_444";
	
	String userNameXpath = "//form[@id='login1']//input[@id='username']";
	String passwordXpath = "//form[@id='login1']//input[@id='password']";
	String submitXpath = "//input[@name='admin']";
	
	String adminPortalHomeHeaderXpath = "//h3[@class='panel-title']";
	String expectedAPHeadertext = "Admin Portal";
	
	
	
	public AP_LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean adminLogin() {
		
		System.out.println("driver in login===>"+driver);
		System.out.println("usernameXpath==>"+userNameXpath);
		
		WebElement userNameField = driver.findElement(By.xpath(userNameXpath));
		userNameField.sendKeys(adminUserName);
		
		
		WebElement passwordNameField = driver.findElement(By.xpath(passwordXpath));
		passwordNameField.sendKeys(adminPassword);
		
		WebElement submitButton = driver.findElement(By.xpath(submitXpath));
		submitButton.click();
		
		WebElement adminPortalHomeHeader = driver.findElement(By.xpath(adminPortalHomeHeaderXpath));
		
		String actualAPHeaderText = adminPortalHomeHeader.getText();
		// result = 0 when the values are same. 
		int result = expectedAPHeadertext.compareTo(actualAPHeaderText);
		
		if(result == 0) {
			System.out.println("Admit portal logged in successfully");
			return true;
		}else {
			System.out.println("Admit portal login failed");
			return false;
		}
	}

}
