package remoFunctions;
import accelerators.Actiondrivers;
import remoPages.companyRegisterPage;

public class BeaHost extends Actiondrivers {

	// Register Company
	public void companyRegister(String name) throws Throwable {
	
		Thread.sleep(2000);
		
		//waitForVisibilityOfElement(companyRegisterPage.menu);
		driver.findElement(companyRegisterPage.menu).click();
		//click(companyRegisterPage.menu, "Left Menu");
		
		Thread.sleep(1000);
		
		click(companyRegisterPage.beaHost, "Left Menu");
		Thread.sleep(2000);
		
		driver.findElement(companyRegisterPage.companyName).sendKeys(name);
		Thread.sleep(2000);
		//type(companyRegisterPage.companyName, name , "Company Name");
		
		driver.findElement(companyRegisterPage.uploadCompanyLogo).click();
        upload("companyLogo.exe");
        
        Thread.sleep(2000);
		//click(companyRegisterPage.saveAndContinue,"Save and Continue button");
		
		// Set timezone
		click(companyRegisterPage.timeZone,"Set the time zone to Asia/calcuta");
		
		// Set Predefined event
		click(companyRegisterPage.predefineEvent,"Set predefined event");
		
		// Mic and cam check page
		
	}
}
