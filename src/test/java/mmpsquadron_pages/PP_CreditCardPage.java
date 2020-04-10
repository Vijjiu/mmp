package mmpsquadron_pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PP_CreditCardPage {
	
	WebDriver driver;
	
	// xpath to the drop down of patient fees to be paid 
	String ppPayeeNameXpath = "//input[@id='name']";
	//xpath to select card type 
	String ppSelectCardXpath = "//select[@id='card_name']";
	//xpath to enter card number
	String cardNumberXpath = "//input[@id='cid']";
	//card month expiry drop down
	String ppSelectCardMonthXpath = "//select[@id='cardMonth']";
	// card year expiry drop down
	String ppSelectCardYearXpath = "//select[@id='cardYear']";
	// card cvv 
	String ppCardCCVXpath = "//input[@id='cvv']";
	// xpath for the Pay fee now button on the pay fees page
	String submitButtonXpath = "//form[@id='myform']//p//input";
	
	String payeeTestName = "Sam J";
	String cardNumber ="3456456712347896";
	String cvv = "456";
	
	
	public PP_CreditCardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public boolean submitCardInfoPay() {
		
		// enter payee name
		WebElement payeeName = driver.findElement(By.xpath(ppPayeeNameXpath));
		payeeName.sendKeys(payeeTestName);
		
		// select the type of credit card from the drop down 
		WebElement payeeCardType = driver.findElement(By.xpath(ppSelectCardXpath));
		// Click on drop down so the drop down list shows
		payeeCardType.click();
		Select mySelectCardType = new Select(payeeCardType);
		
		//generate random number from the indexes available
		List<WebElement> itemsInDropdown = mySelectCardType.getOptions();
		// Getting size of options available
		int size = itemsInDropdown.size();
		// Generate a random number with in range. starting from 1 as the option 0 has 'select appointments' as option
		int randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		// Selecting random value
		itemsInDropdown.get(randnMumber).click();
		
		//=====
		// enter card number
		WebElement cardNumberEle = driver.findElement(By.xpath(cardNumberXpath));
		cardNumberEle.sendKeys(cardNumber);
		
		//=====
		
		// select the expiry month from the drop down
		WebElement selectMonth = driver.findElement(By.xpath(ppSelectCardMonthXpath));
		// Click on drop down so the drop down list shows
		selectMonth.click();
		Select mySelectMonth = new Select(selectMonth);
		
		// Waiting till options in drop down are visible
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@class='menu transition visible']"))));*/
		
		//generate random number from the indexes available
		itemsInDropdown.clear();
		itemsInDropdown = mySelectMonth.getOptions();
		// Getting size of options available
		size = itemsInDropdown.size();
		// Generate a random number with in range. starting from 1 as the option 0 has 'select appointments' as option
		randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		
		System.out.println("index picked"+randnMumber);
		System.out.println("size of list"+size);
		
		itemsInDropdown.get(randnMumber).click();
		
		// Selecting random value
		//WebElement listItem = itemsInDropdown.get(randnMumber);
		//listItem.click();
		//listItem.click();
		//String itemSelected = itemsInDropdown.get(randnMumber).getText();
		
		//=====
		//select expiry year
		
		// select the expiry year from the drop down
		WebElement selecYear = driver.findElement(By.xpath(ppSelectCardYearXpath));
		// Click on drop down so the drop down list shows
		selecYear.click();
		Select mySelectYear = new Select(selecYear);
		
		// Waiting till options in drop down are visible
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@class='menu transition visible']"))));*/
		
		//generate random number from the indexes available
		itemsInDropdown.clear();
		itemsInDropdown = mySelectYear.getOptions();
		// Getting size of options available
		size = itemsInDropdown.size();
		// Generate a random number with in range. starting from 1 as the option 0 has 'select appointments' as option
		randnMumber = ThreadLocalRandom.current().nextInt(1, size);
		
		System.out.println("index picked"+randnMumber);
		System.out.println("size of list"+size);
		itemsInDropdown.get(randnMumber).click();
		// Selecting random value
		//WebElement listItem = itemsInDropdown.get(randnMumber);
		//listItem.click();
		//listItem.click();
		//String itemSelected = itemsInDropdown.get(randnMumber).getText();
		
		//=====
		//enter 3 digit cvv code 
		WebElement cardCVV = driver.findElement(By.xpath(ppCardCCVXpath));
		cardCVV.sendKeys(cvv);
		
		//======
		//click submit 
		

		WebElement submitButton = driver.findElement(By.xpath(submitButtonXpath));
		submitButton.click();
		
		//validate the page navigation to credit card info page 
		//TODO: Sumit button is not doing anything as of now. 
		// ones it is fixed ... need to add validation to check the alert success.
		
		return true;
		
		
	}


}
