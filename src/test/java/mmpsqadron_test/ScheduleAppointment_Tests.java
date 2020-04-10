package mmpsqadron_test;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleAppointment_Tests {

	WebDriver driver;
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		launchBrowser();
		HashMap<String,String> hMap = bookanAppointment("Beth","02/25/2020","10Am","Fever");
		sa.assertTrue(validateApptDetailsinHomePage(hMap));
		sa.assertTrue(validateApptDetailsinScheduleApptPage(hMap));
		sa.assertAll();
	}
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/sheduleappointments.php");
	}
	public HashMap<String, String> bookanAppointment(String doctor,String date,String time,String sym) throws InterruptedException
	{
		HashMap<String,String> hMap = new HashMap<String,String>();
		driver.findElement(By.xpath(" //input[@type='submit']")).click();
		driver.findElement(By.xpath("//h4[text()='Dr."+doctor+"']//ancestor::ul/following-sibling::button")).click();
		hMap.put("doctor",doctor);
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).sendKeys(date);
		hMap.put("date",date);
		new Select(driver.findElement(By.id("time"))).selectByValue(time);
		hMap.put("time", time);
		Thread.sleep(2000);
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("sym")).sendKeys(sym);
		hMap.put("sym", sym);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return hMap;
	}
	public boolean validateApptDetailsinHomePage(HashMap hMap)
	{
		boolean result = false;
		String trData = driver.findElement((By.xpath("//table[@class='table']/tbody/tr[1]"))).getText();
		String tr[] = trData.split(" ");
		if(hMap.get("date").equals(tr[0])&& 
					hMap.get("time").equals(tr[1])&&
					hMap.get("sym").equals(tr[2])&&
					hMap.get("doctor").equals(tr[3]))
		{
			result = true;
			System.out.println("Data is matching in HomePage");
		}
		else
		{
			result = false;
			System.out.println("Data not matching in HomePage");
		}
		return result;
		
	}
	public boolean validateApptDetailsinScheduleApptPage(HashMap hMap)
	{
		boolean result = false;
		//Click on ScheduleAppointments Tab
		driver.findElement(By.xpath("//li[4]//a[1]")).click();
		String date = driver.findElement(By.xpath("(//h3[@class='panel-title'])[2]")).getText();
		String time = driver.findElement(By.xpath("//a[contains(text(),'Time : 10Am')]")).getText().split("\\:")[1].trim();
		String doctor = driver.findElement(By.xpath("//a[contains(text(),'Provider:Beth')]")).getText().split("\\:")[1].trim();
		String sym = driver.findElement(By.xpath("//a[contains(text(),'Symptoms:Fever')]")).getText().split("\\:")[1].trim();
		if(hMap.get("date").equals(date)&& 
				hMap.get("time").equals(time)&&
				hMap.get("sym").equals(sym)&&
				hMap.get("doctor").equals(doctor))
		{
			System.out.println("Data matching in ScheduleAppointment Page");
			result = true;
		}
		else
		{
			result = false;
			System.out.println("Data not matching in ScheduleAppointment Page");
		}
		return result;
	}

}

