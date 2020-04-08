package mmpsquadron_pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AP_PortalPage {
	
	
	WebDriver driver;
	
	// xpath for the patient serach box and search button on admin portal to search for patien with ssn
	String patientSearchSSNTextXpath = "//input[@id='search']";
	String patientSearchButtonXpath = "//input[@class='tfbutton']";
	
	String searchSSN ="5675464567";
	
	Boolean assertPatientDetails = true; 
	
	// xpath to click on patient name after search 
	String patientNameLinkXpath = "//body//td[1]/a";
	//xpath to text showing patient name
	String patientDetailsNameXpath = "//body//tr[1]/td";
	//String expectedAPPatientName = "VijayaTestPatient";
	String expectedAPPatientName = "Patient Name:VijayaTestPatient";
	 
	
	public AP_PortalPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	/*  need to fix the validity part also the return parameters*/
	//public HashMap<String, String> retrievePatientBySSN(){
	public boolean retrievePatientBySSN() throws InterruptedException{
		HashMap<String,String> hExpectedMap = new HashMap<String,String>();
		hExpectedMap.put("Name","Vijaya");
		hExpectedMap.put("SSN","5675464567");
		hExpectedMap.put("AGE", "35");
		
		HashMap<String,String> hActualMap = new HashMap<String,String>();
		
		
		WebElement patientSearchSSNText = driver.findElement(By.xpath(patientSearchSSNTextXpath));
		patientSearchSSNText.sendKeys(searchSSN);
		
		WebElement patientSearchButton = driver.findElement(By.xpath(patientSearchButtonXpath));
		patientSearchButton.click();
	
		//String actualAPPortalHeaderText = adminPortalHeader.getText();
		// result = 0 when the values are same. 
		/*int result = expectedAPPortalHeadertext.compareTo(actualAPPortalHeaderText);
		
		if(result == 0) {
			System.out.println("Admit portal logged in successfully");
			return true;
		}else {
			System.out.println("Admit portal login failed");
			return false;
		}*/
		
		//validate the patient details page
		Thread.sleep(3000);
		
		boolean verified = clickPatientLink();
		
		
		return  verified;
		
	}
	
	/*yet to fix this part */
	public boolean validatePatientSearchResult(HashMap hMap)
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
	
	/*yet to fix this */
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
		
		//clickPatientLink();
		return result;
	}
	
	
	/* Function to click on the patent name to see details of the patient*/
	public boolean clickPatientLink() {
		
		WebElement patientNameLink = driver.findElement(By.xpath(patientNameLinkXpath));
		patientNameLink.click();
		
		//validate the page navigation to patient details.
		WebElement patientName = driver.findElement(By.xpath(patientDetailsNameXpath));
		// if we want just the name of the patient as the actual text is Patient Name:VijayaTestPatient
		//String actualPatientNameText = patientName.getText().split("\\:")[1].trim();
		
		//or change the expected text. 
		String actualPatientNameText = patientName.getText();
		
		// result = 0 when the values are same. 
		int result = expectedAPPatientName.compareTo(actualPatientNameText);
		
		System.out.println("actual name" + actualPatientNameText);
		System.out.println("expected name" +expectedAPPatientName);
		
		if(result == 0) {
			System.out.println("Patient Name validated successfully");
			return true;
		}else {
			System.out.println("Patient Name validation failed");
			return false;
		}
		
	}

}
