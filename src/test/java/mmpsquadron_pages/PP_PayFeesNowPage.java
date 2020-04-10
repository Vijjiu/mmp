package mmpsquadron_pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PP_PayFeesNowPage {
	
	
	WebDriver driver;
	
	// xpath to the drop down of patient fees to be paid 
	String patientFeesSelectXpath = "//select[@id='amount']";
	// xpath for the Pay fee now button on the pay fees page
	String contineuButtonXpath = "//input[@type='submit']";
	
	// Patient Portal Pay fees now header text xpath -> 
	String pPCardInfoHeaderXpath = "//h3[@class='panel-title']";
	// Patient Portal pay fees now header text  -> 
	String expectedCardInfoHeadertext = "Card Information";
	
	public PP_PayFeesNowPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public boolean selectFeeToPay() {
		
		// select the fees to pay from the drop down 
		WebElement selectFees = driver.findElement(By.xpath(patientFeesSelectXpath));
		// Click on drop down so the drop down list shows
		selectFees.click();
		Select mySelectFees = new Select(selectFees);
		
		
		//generate random number from the indexes available
		List<WebElement> itemsInDropdown = mySelectFees.getOptions();
		// Getting size of options available
		int size = itemsInDropdown.size();
		// Generate a random number with in range. starting from 1 as the option 0 has 'select appointments' as option
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		// Selecting random value
		itemsInDropdown.get(randnMumber).click();
		
		WebElement continueButton = driver.findElement(By.xpath(contineuButtonXpath));
		continueButton.click();
		
		//validate the page navigation to credit card info page 
		WebElement cardInfoHeader = driver.findElement(By.xpath(pPCardInfoHeaderXpath));

		String actualCardInfoHeaderText = cardInfoHeader.getText();
		
		// result = 0 when the values are same. 
		int result = expectedCardInfoHeadertext.compareTo(actualCardInfoHeaderText);
		
		System.out.println("actual pay now header" + actualCardInfoHeaderText);
		System.out.println("expected pay now header" +expectedCardInfoHeadertext);
		System.out.println("result=>"+result);
		
		if(result == 0) {
			System.out.println("card info header validated successfully");
			return true;
		}else {
			System.out.println("card info header validation failed");
			return false;
		}
		
		
	}

}
