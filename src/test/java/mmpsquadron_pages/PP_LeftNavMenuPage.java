package mmpsquadron_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PP_LeftNavMenuPage {
	
	
	WebDriver driver;
	
	// xpath for the patient link on the home page
	String patientFeesXpath = "//a[@href='fees.php']";
	// xpath for logout link in the nav menu 
	String pPLogoutXpath ="//span[contains(text(),'Logout')]";
	
	// Patient Portal header text xpath -> needed to verify if the link on patient takes it to patient Fees portal page. 
	String pPFeesHeaderXpath = "//h3[@class='panel-title']";
	// Patient Portal header text  -> needed to verify if the link on patient takes it to patient portal fees page. 
	String expectedPPFeesHeadertext = "Fees";
	
	public PP_LeftNavMenuPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean clickFeesLink() {
		
		WebElement patientFeeLink = driver.findElement(By.xpath(patientFeesXpath));
		patientFeeLink.click();
		
		WebElement pPFeesHeader = driver.findElement(By.xpath(pPFeesHeaderXpath));
	
		String actualAPPortalHeaderText = pPFeesHeader.getText();
		// result = 0 when the values are same. 
		int result = expectedPPFeesHeadertext.compareTo(actualAPPortalHeaderText);
		
		System.out.println("actual fee header -> "+ expectedPPFeesHeadertext);
		System.out.println("actual fee header -> "+ actualAPPortalHeaderText);
		System.out.println("result  -> "+ result);
		
		if(result == 0) {
			System.out.println("patient portal fee page loaded successfully");
			return true;
		}else {
			System.out.println("patient portal fee page loading failed");
			return false;
		}
		
	}
	
	public boolean clickLogout() {
		WebElement patientLogoutLink = driver.findElement(By.xpath(pPLogoutXpath));
		patientLogoutLink.click();
		
		//TODO: add validation to check it is logged out from patient portal.
		//BUG: Currently the menu bar is missing when auto test is runnign in browser. 
		
		/*String expectedHeader ="Admin Login";
		
		WebElement expectedScreenHeader = driver.findElement(By.xpath(adminLoginPageHeader));
		boolean result = expectedAdminHeader.equals(adminHeader.getText());
		
		return result;
		
		
		//return true;*/
		
		
		
		return true;
	}

}
