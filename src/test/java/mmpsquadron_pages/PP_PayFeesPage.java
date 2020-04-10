package mmpsquadron_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PP_PayFeesPage {
	
	WebDriver driver;
	
	// xpath to the list of patient fees 
	String patientFeesListXpath = "//div[@class='col-md-6']//li";
	// xpath for the Pay fee now button on the pay fees page
	String payNowButtonXpath = "//button[contains(text(),'Pay Now')]";
	
	// Patient Portal Pay fees now header text xpath -> 
	String pPPayFeesHeaderXpath = "//h3[@class='panel-title']";
	// Patient Portal pay fees now header text  -> 
	String expectedPayFeesHeadertext = "Pay Now";
	
	public PP_PayFeesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean validateFeeDetail() {
		
		String expectedFeeEntry = null;
		boolean finalResult = false;
		
		if(AP_AddFeePage.finalServiceFeeHMap!=null) {
			
			expectedFeeEntry  = AP_AddFeePage.finalServiceFeeHMap.get("service") +" "
			+AP_AddFeePage.finalServiceFeeHMap.get("date") + ":...... "
					+ AP_AddFeePage.finalServiceFeeHMap.get("fee");
			
			System.out.println("hashmap value ->" + AP_AddFeePage.finalServiceFeeHMap.get("date"));
			System.out.println("hashmap value ->" + AP_AddFeePage.finalServiceFeeHMap.get("service"));
			System.out.println("hashmap value ->" + AP_AddFeePage.finalServiceFeeHMap.get("fee"));
			
		}
		
		boolean itemEnd = true; 
		while(itemEnd!=true) {
			// start from index 0
			int i = 0;
			WebElement itemsFeesListed = driver.findElement(By.xpath(patientFeesListXpath+"["+i+"]"));
			String currentListItemText = itemsFeesListed.getText();
			int result = currentListItemText.compareTo(expectedFeeEntry);
			if(result==0) {	
				return true;
			}	
			else {
				i = i+1;
				if(driver.findElement(By.xpath(patientFeesListXpath+"["+i+"]")) == null) {
					itemEnd= false;
				}
			}
		}
		// exit while and no match found
		return false;
		
	}
	
	
	public boolean clickPayNow() {
		
		WebElement payNowButton = driver.findElement(By.xpath(payNowButtonXpath));
		payNowButton.click();
		
		//validate the page navigation to pay fees now page 
		WebElement payFeesNowHeader = driver.findElement(By.xpath(pPPayFeesHeaderXpath));

		String actualPayNowFeesHeaderText = payFeesNowHeader.getText();
		
		// result = 0 when the values are same. 
		int result = expectedPayFeesHeadertext.compareTo(actualPayNowFeesHeaderText);
		
		System.out.println("actual pay now header" + actualPayNowFeesHeaderText);
		System.out.println("expected pay now header" +actualPayNowFeesHeaderText);
		
		if(result == 0) {
			System.out.println("pay now header validated successfully");
			return true;
		}else {
			System.out.println("pay now header validation failed");
			return false;
		}
		
	}
	

}
