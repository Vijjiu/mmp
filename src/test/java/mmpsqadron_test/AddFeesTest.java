package mmpsqadron_test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmpsquadron_pages.AP_AddFeePage;
import mmpsquadron_pages.AP_HomePage;
import mmpsquadron_pages.AP_LoginPage;
import mmpsquadron_pages.AP_LogoutPage;
import mmpsquadron_pages.AP_PatientDetailPage;
import mmpsquadron_pages.AP_PortalPage;
import mmpsquadron_pages.PP_LeftNavMenuPage;
import mmpsquadron_pages.PP_LoginPage;
import mmpsquadron_pages.PP_PayFeesPage;

public class AddFeesTest {
	
	
	WebDriver driver;
	HashMap<String, String> finalServiceFeeMap;
	
	@Test(description="Add new fees test to a patient account using patient SSN")
	public void addNewFee() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		// Launch admin login page 
		LaunchBrowser adminBrowswerObj =  new LaunchBrowser(driver);
		// Launch admin login page 
		String adminLoginURL = adminBrowswerObj.adminLoginUrl;
		driver = adminBrowswerObj.launchPage(driver,adminLoginURL);
		
		Thread.sleep(3000);
		//initialize the Add new fees page driver 
		AP_LoginPage adminLoginPageObj = new AP_LoginPage(driver);
		//login into admin page
		sa.assertTrue(adminLoginPageObj.adminLogin());
		
		Thread.sleep(5000);
		
		//initialize the admin home page and click on the patient link
		AP_HomePage adminPortalHomeObj = new  AP_HomePage(driver);
		sa.assertTrue(adminPortalHomeObj.clickPatientLink());
		
		Thread.sleep(5000);
		 
		// Initialize the admin portal page and enter ssn of a patient to search for a patient
		AP_PortalPage adminPortalPageObj = new  AP_PortalPage(driver);
		sa.assertTrue(adminPortalPageObj.retrievePatientBySSN());
		 
		Thread.sleep(5000);
		// Initialize the admin portal page and enter ssn of a patient to search for a patient
		AP_PatientDetailPage adminPortalPatientDetailObj = new  AP_PatientDetailPage(driver);
		sa.assertTrue(adminPortalPatientDetailObj.clickCreateFees());
		 
		Thread.sleep(5000);
		// Initialize the admin portal page and enter ssn of a patient to search for a patient
		AP_AddFeePage adminPortalAddFeeObj = new  AP_AddFeePage(driver);
		sa.assertTrue(adminPortalAddFeeObj.addNewFee());
		//use adminPortalAddFeeObj.finalServiceFeeHMap to verify the values in the patient portal to see if the right values were added. 
		//this.finalServiceFeeMap = new HashMap<String, String>();
		//this.finalServiceFeeMap = adminPortalAddFeeObj.finalServiceFeeHMap;
		
		Thread.sleep(5000);
		
		// log out of the admin portal page. 
		AP_LogoutPage adminLogOutObj = new  AP_LogoutPage(driver);
		sa.assertTrue(adminLogOutObj.logoutAdminPortal(driver));
		//
		//sa.assertAll();
		Thread.sleep(5000);
		
		// close driver and browser 
		adminBrowswerObj.closeBrowser(driver);
		
		// launch browser and login to patient portal.
		// Login to patient portal to verify if the right details were added using hashmap values. 
		// launch browser to get patient url 
		LaunchBrowser patientBrowserObj =  new LaunchBrowser(driver);
		String patientLoginURL = patientBrowserObj.patientLoginUrl;
		driver = patientBrowserObj.launchPage(driver,patientLoginURL);
		
		// login into patient portal 
		Thread.sleep(3000);
		//initialize the login patient portal driver 
		PP_LoginPage patientLoginPageObj = new PP_LoginPage(driver);
		//login into patient page
		sa.assertTrue(patientLoginPageObj.patientLogin());
		
		Thread.sleep(3000);
		//click on patient fee on patient portal left navigation menu 
		PP_LeftNavMenuPage pPLeftNavMenuObj = new PP_LeftNavMenuPage(driver);
		//click on fee link
		sa.assertTrue(pPLeftNavMenuObj.clickFeesLink());
		
		
		//TODO: add validation of the fee listed with the fee added by the admin using values stored in hashmap.
		PP_PayFeesPage patientPayFeeObj = new PP_PayFeesPage(driver);
		sa.assertTrue(patientPayFeeObj.validateFeeDetail());
		
		// finally assert all
		//sa.assertAll();
		
		
	}
	
	
	

}
