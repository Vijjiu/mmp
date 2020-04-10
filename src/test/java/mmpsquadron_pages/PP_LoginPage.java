package mmpsquadron_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PP_LoginPage {
	
	WebDriver driver;
	
	private String patientUserName = "vijayatest";
	private String patientPassword ="Vijayatest1";
	
	String userNameXpath = "//input[@id='username']";
	String passwordXpath = "//input[@id='password']";
	String submitXpath = "//input[@name='submit']";
	
	String patientPortalHomeHeaderXpath = "//h3[@class='page-header']";
	String expectedPPHeadertext = "vijayatest";
	
	
	
	public PP_LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean patientLogin() {
		
		System.out.println("driver in login===>"+driver);
		System.out.println("usernameXpath==>"+userNameXpath);
		
		WebElement userNameField = driver.findElement(By.xpath(userNameXpath));
		userNameField.sendKeys(patientUserName);
		
		
		WebElement passwordNameField = driver.findElement(By.xpath(passwordXpath));
		passwordNameField.sendKeys(patientPassword);
		
		WebElement submitButton = driver.findElement(By.xpath(submitXpath));
		submitButton.click();
		
		WebElement patientPortalHomeHeader = driver.findElement(By.xpath(patientPortalHomeHeaderXpath));
		
		String actualPPHeaderText = patientPortalHomeHeader.getText();
		// result = 0 when the values are same. 
		int result = expectedPPHeadertext.compareTo(actualPPHeaderText);
		
		System.out.println("expected text -> " + expectedPPHeadertext);
		System.out.println("actual text -> " + actualPPHeaderText);
		System.out.println("result -> " + result);
		
		if(result == 0) {
			System.out.println("patient portal logged in successfully");
			return true;
		}else {
			System.out.println("patient portal login failed");
			return false;
		}
		
	}


}
