package mmpsquadron_pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
	
	  private final WebDriver driver;
	
	public RegisterPatientPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HashMap<String, String> register(String userName,String password) throws InterruptedException
	{
		    Random rnd = new Random();
			HashMap<String,String> hMap = new HashMap<String,String>();
		    
		   
			
			WebElement stateTxtField = driver.findElement(By.id("state")); 
			stateTxtField.sendKeys("New York");
			hMap.put("state", stateTxtField.getAttribute(("value")));
		 
			WebElement cityTxtField = driver.findElement(By.id("city")); 
			cityTxtField.sendKeys("seattle");
			hMap.put("city", cityTxtField.getAttribute(("value")));
			
			WebElement addressTxtField = driver.findElement(By.id("address")); 
			addressTxtField.sendKeys("10 Street");
			hMap.put("address", addressTxtField.getAttribute(("value"))); 
			
			WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
			long zipValue = 10000 + rnd.nextInt(90000);
			zipcodeTxtField.sendKeys(""+zipValue);
			hMap.put("zipcode", zipcodeTxtField.getAttribute(("value")));
			
			 
			WebElement ageTxtField = driver.findElement(By.id("age"));
			long ageValue = rnd.nextInt(90);
			ageTxtField.sendKeys(""+ageValue);
			hMap.put("age", ageTxtField.getAttribute(("value")));
			
			WebElement heightTxtField = driver.findElement(By.id("height"));
			long heightValue = 10+rnd.nextInt(90);
			heightTxtField.sendKeys(""+heightValue);
			hMap.put("height", heightTxtField.getAttribute(("value")));
			
			WebElement weightTxtField = driver.findElement(By.id("weight"));
			long weightValue = rnd.nextInt(90);
			weightTxtField.sendKeys(""+weightValue);
			hMap.put("weight", weightTxtField.getAttribute(("value")));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			WebElement datePickerTxtField= driver.findElement(By.id("datepicker"));
			datePickerTxtField.sendKeys(sdf.format(new Date()));
			
			WebElement firstNameTxtField = driver.findElement(By.id("firstname"));
			firstNameTxtField.sendKeys("testFN"+(char)(65+rnd.nextInt(26))+""+(char)(65+rnd.nextInt(26)));
			hMap.put("firstname", firstNameTxtField.getAttribute(("value")));
			
			WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
			lastnameTxtField.sendKeys("testLN"+(char)(65+rnd.nextInt(26))+""+(char)(65+rnd.nextInt(26)));
			hMap.put("lastname", lastnameTxtField.getAttribute(("value")));
			
			 
			WebElement emailTxtField = driver.findElement(By.id("email"));
			emailTxtField.sendKeys("testEmail"+((char)(65+rnd.nextInt(26))+""+
										(char)(65+rnd.nextInt(26)))+ "@gmail.com");
			hMap.put("email", emailTxtField.getAttribute(("value")));
			
			
			WebElement usernameTxtField = driver.findElement(By.id("username"));
			usernameTxtField.sendKeys(userName);
			hMap.put("username", usernameTxtField.getAttribute(("value")));
			
			WebElement passwordTxtField = driver.findElement(By.id("password"));
			passwordTxtField.sendKeys(password);
			hMap.put("password", passwordTxtField.getAttribute(("value")));
			 
			WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
			confirmpasswordTxtField.sendKeys(password);
			hMap.put("confirmpassword", confirmpasswordTxtField.getAttribute(("value")));
			 
			new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your best friend name");			
			 
			
			WebElement answerTxtField = driver.findElement(By.id("answer"));
			answerTxtField.sendKeys(userName);
			hMap.put("answer", answerTxtField.getAttribute(("value")));
			  
			WebElement licenseTxtField = driver.findElement(By.id("license")); 
 			Long licenseValue = new Long(10000000 + rnd.nextInt(90000000));
        	System.out.println("License::" + licenseValue + "--" + licenseValue.toString().length());
			licenseTxtField.click();
			licenseTxtField.sendKeys(licenseValue.toString().trim());
			hMap.put("license", licenseTxtField.getAttribute(("value")));
			licenseTxtField.click();
			
			Thread.sleep(3000);
			
			WebElement ssnTxtField = driver.findElement(By.id("ssn")); 
			long ssnValue = rnd.nextInt(999999999);
			ssnTxtField.sendKeys(""+ssnValue);
			hMap.put("ssn", ssnTxtField.getAttribute(("value")));
			ssnTxtField.click();
			
				
			driver.findElement(By.name("register")).click();
			
			Alert regAlert = driver.switchTo().alert();
			String successMsg = regAlert.getText();
			regAlert.accept();
			
		    hMap.put("message", successMsg);
		    
			return hMap;
	}
}
