package mmpsqadron_test;
	
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mmpsquadron_pages.RegisterPatientPage;

public class PatientApprove_Tests {

	
	@Test(description="US_004 Validating the approve patient")
	public void approvePatient() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		
		RegisterPatientPage regPage = new RegisterPatientPage(driver);
		
		Random rnd = new Random();
		String username = "testun"+ (char)(65+rnd.nextInt(26))  + rnd.nextInt(100);
		String password = "testpd"+(char)(65+rnd.nextInt(26))+rnd.nextInt(200);
		HashMap<String,String> hMap = regPage.register(username, password);
		Set<String> keySetValues = hMap.keySet();
		for(String key : keySetValues)
		{
			System.out.println("Key is ::"   + key);
			System.out.println("Value is ::" +hMap.get(key));
		}
		String expectedMsg = "Thank you for registering with MMP.";
		String actualMsg = hMap.get("message");
		Assert.assertEquals(actualMsg.trim(),expectedMsg.trim());
					
		
	}
}
