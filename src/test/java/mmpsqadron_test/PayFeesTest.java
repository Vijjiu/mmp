package mmpsqadron_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmpsquadron_pages.AP_LoginPage;
import mmpsquadron_pages.AP_LogoutPage;
import mmpsquadron_pages.PP_CreditCardPage;
import mmpsquadron_pages.PP_LeftNavMenuPage;
import mmpsquadron_pages.PP_LoginPage;
import mmpsquadron_pages.PP_PayFeesNowPage;
import mmpsquadron_pages.PP_PayFeesPage;

public class PayFeesTest {
	
	WebDriver driver;
	
	//@Test(description="Pay fees by loggin into patient portal")
	public void payFees() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
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
		
		Thread.sleep(3000);
		//initialize the patient pay fee page driver 
		PP_PayFeesPage patientPayFeesPageObj = new PP_PayFeesPage(driver);
		//click on pay  button
		sa.assertTrue(patientPayFeesPageObj.clickPayNow());
		
		
		Thread.sleep(3000);
		//initialize the patient pay now  driver 
		PP_PayFeesNowPage patientPayFeesNowPageObj = new PP_PayFeesNowPage(driver);
		//selecte fees to pay
		sa.assertTrue(patientPayFeesNowPageObj.selectFeeToPay());
		
		Thread.sleep(3000);
		//initialize the patient card info  driver 
		PP_CreditCardPage patientCardPayPageObj = new PP_CreditCardPage(driver);
		//selecte fees to pay
		sa.assertTrue(patientCardPayPageObj.submitCardInfoPay());
		
		//logout - SEEMS BROKEN. Nav menu is not showing while auto testing in browswer.
		/*Thread.sleep(5000);
		//PP_LeftNavMenuPage pPLeftNavMenuObj2 = new PP_LeftNavMenuPage(driver);
		// log out of the admin portal page. 
		//sa.assertTrue(pPLeftNavMenuObj2.clickLogout());
		sa.assertTrue(pPLeftNavMenuObj.clickLogout());
		//
		//sa.assertAll();
		Thread.sleep(5000);
		
		// close driver and browser 
		patientBrowserObj.closeBrowser(driver);*/
		
		sa.assertAll();
		
		
	}

}
