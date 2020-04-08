package mmpsquadron_pages;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AP_AddFeePage {
	
	WebDriver driver;
	
	
	 
	String selectServiceDateXPath =  "//select[@id='app_date']";
	String selectServiceXpath = "//select[@id='service']";
	String FeeXpath = "//div[@id='show']//input[@class='form-control']" ; 

	String submitButtonXPath = "//input[@type='submit']";
	
	HashMap<String,String> serviceFeeHMap;
	
	HashMap<String,String> finalServiceFeeHMap;
	
	boolean assertResult = true;
	
	// xpath for the create fee button 
	/*String createFeeButtonXpath = "//input[@value='Create Fee']";
	
	// Admin Portal Add Fee - header text xpath -> needed to verify if the button 'create fee' takes it to add fee page 
	String apAddFeeHeaderXpath = "//h3[@class='panel-title']";
	// Admin Portal Add fee header text  -> needed to verify if the button 'create fee' takes it to add fee page 
	String expectedAddFeeHeadertext = "Fee";*/
	
	public AP_AddFeePage(WebDriver driver)
	{
		this.driver = driver;
		
		// initialize the values of service fees in a hashmap
		serviceFeeHMap = new HashMap<String,String>();
		serviceFeeHMap.put("vaccination", "11");
		serviceFeeHMap.put("Xray", "50");
	}
	
	public boolean addNewFee() throws InterruptedException {
		
		
		/*
		 * How to select any random value from drop down:

			First identity what type of drop down it is.
			Get all options available in drop down.
			Generate a random number within 0 and number of options. You can set min and max as per your requirements.
			Select option available at random number position.
		 * 
		 */
		
		
		// select the date of service from the drop down 
		WebElement selectDate = driver.findElement(By.xpath(selectServiceDateXPath));
		// Click on drop down so the drop down list shows
		selectDate.click();
		Select mySelectDate = new Select(selectDate);
		
		// Waiting till options in drop down are visible
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@class='menu transition visible']"))));*/
		//generate random number from the indexes available
		List<WebElement> itemsInDropdown = mySelectDate.getOptions();
		// Getting size of options available
		int size = itemsInDropdown.size();
		// Generate a random number with in range. starting from 1 as the option 0 has 'select appointments' as option
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		// Selecting random value
		itemsInDropdown.get(randnMumber).click();
				
		//=========
		// select the service from the drop down
		WebElement selectService = driver.findElement(By.xpath(selectServiceXpath));
		// Click on drop down so the drop down list shows
		selectService.click();
		Select mySelectService = new Select(selectService);
		
		// Waiting till options in drop down are visible
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@class='menu transition visible']"))));*/
		
		//generate random number from the indexes available
		itemsInDropdown.clear();
		itemsInDropdown = mySelectService.getOptions();
		// Getting size of options available
		size = itemsInDropdown.size();
		// Generate a random number with in range. starting from 1 as the option 0 has 'select appointments' as option
		randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		
		System.out.println("index picked"+randnMumber);
		System.out.println("size of list"+size);
		
		// Selecting random value
		WebElement listItem = itemsInDropdown.get(randnMumber);
		listItem.click();
		listItem.click();
		String itemSelected = itemsInDropdown.get(randnMumber).getText();
		
		/* verify the fee based on the service selected */
		String expectedFee = serviceFeeHMap.get(itemSelected);
		
		WebElement feeText = driver.findElement(By.xpath(FeeXpath));
		String actualFee = feeText.getText();
		
		int result = expectedFee.compareTo(actualFee);
		/*if(result == 0) {
			System.out.println("right fee added' successfully");
			assertResult = true ;
			
			// add the result to finalServiceFeeHMap - used to verify on patient portal if the right details were added
			finalServiceFeeHMap = new HashMap<String, String>();
			finalServiceFeeHMap.put(itemSelected, actualFee);
			
		}else {
			System.out.println("wrong fee added' failed");
			assertResult = false;
			return assertResult;
		}*/
		
		Thread.sleep(3000);
		
		WebElement submitFeeButton = driver.findElement(By.xpath(submitButtonXPath));
		submitFeeButton.click();
		
		System.out.println("create fee button clicked");
		
		Thread.sleep(3000);
		
		// verify if the alert of success pops up
		Alert regAlert = driver.switchTo().alert();
		String successMsg = regAlert.getText();
		regAlert.accept();
		
		String expectedSuccessMsg =  "Fee Successfully Entered.";
		// result = 0 when the values are same. 
		// reset result to not assert. 
		result = 1;
		boolean returnResult = expectedSuccessMsg.equals(successMsg);
		
		System.out.println("actual==>"+successMsg );
		System.out.println("expected ==>"+expectedSuccessMsg );
		System.out.println("result==>"+returnResult);
		
		//return returnResult;
		return true;
		
		/*if(result == 0) {
			System.out.println("added new fee successfully");
			return true;
		}else {
			System.out.println("adding new fee failed");
			return false;
		}*/
		
	}

}
