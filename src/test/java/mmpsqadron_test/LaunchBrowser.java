package mmpsqadron_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	
	WebDriver driver; 
	// admin login page url 
	String adminLoginUrl = "http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/admin/login.php";
	// patient login page url 
	String patientLoginUrl ="http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/portal/login.php";
	
	public LaunchBrowser(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	public WebDriver launchPage(WebDriver driver, String url)
	{
		this.driver = driver;
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get(url);
		
		return driver;
		
	} 


	public void closeBrowser(WebDriver driver) {
		this.driver = driver; 
		driver.quit();
		
	}

}
