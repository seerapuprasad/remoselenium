package remoFunctions;

import org.apache.commons.lang3.RandomStringUtils;
import accelerators.Actiondrivers;
import remoPages.eventLandingPage;
import remoPages.loginPage;
import remoPages.signUpPage;

public class Authentication extends Actiondrivers {

	// Login into Account from Signup page
	public void singUp() throws Throwable {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		String name = generatedstring;
		companyName = generatedstring + " PVT Limited";
		String  email = "automation+"+ generatedstring+"@remo.co";
		String password = "03g55a0204";
		
		// Click on SingUp form
		click(signUpPage.singup,"Sign Up button");

		// Enter Name
		type(signUpPage.name, name, "Name");
		//logger.log(LogStatus.PASS, "Navigated to the specified URL");

		// Enter email
		type(signUpPage.email, email , "Email");
		
		// Enter password
		type(signUpPage.password, password , "Password");
		
		// Accept the terms and conditions
		click(signUpPage.checkBox, "Terms and conditions checkbox");

		// Click on Sign UP
		click(signUpPage.submit,"Signup button");
	}

	// Login into Account from singup Page
	public void login(String email, String password) throws Throwable {
		// Enter email
		type(loginPage.email, email, "Email");
		
		// Enter password
		type(loginPage.password, password, "Password");
		passReport("Successfully Entered password : " + password);

		// Click on Sign UP
		click(loginPage.login, "Login button");
		Thread.sleep(2000);
	}
	
	// Login into Account from event landing page
	public void JoinEventEG(String email, String password) throws Throwable {
			//waitForVisibilityOfElement(eventLandingPage.getButtonText);
			Thread.sleep(3000);
			// Click on sing into to join the button
			String bName= driver.findElement(eventLandingPage.getButtonText).getText();
			if(bName.contains("Join Event"))
			{
				click(eventLandingPage.joinEvent, bName+ " button");
				Thread.sleep(500);
				
			} else if(bName.contains("Join Lobby"))
			{
				click(eventLandingPage.joinLobby, bName+ " button");
				Thread.sleep(500);
			}
			
			// Enter email
			type(eventLandingPage.emailTxt,email, "Email");
			
			// Click on continue button
			click(eventLandingPage.continuebtn,"Contine button");
			Thread.sleep(500);
			
			// Enter the password
			type(eventLandingPage.passwordTxt,password , "Password");
			
			// Click on continue
			click(eventLandingPage.EGjoinEventbtn, "Join Event button");
			Thread.sleep(1000);
		}

	// signup into Event as guest from event landing page
	public void JoinEventNG() throws Throwable {
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		String name = "automation+";
		String  email = name+ generatedstring+"@remo.co";
		String password = "03g55a0204";
		Thread.sleep(2000);
		// Click on sing into to join the button
		String bName= driver.findElement(eventLandingPage.getButtonText).getText();
		if(bName.contains("Join Event"))
		{
			click(eventLandingPage.joinEvent, bName+ " button");
			Thread.sleep(500);
						
		} else if(bName.contains("Join Lobby"))
			{
				click(eventLandingPage.joinLobby, bName+ " button");
				Thread.sleep(500);
			}
		// Enter the email
		type(eventLandingPage.emailTxt,email,"Email");
		
		// Click on Continue button
		click(eventLandingPage.continuebtn,"Contine button");
		Thread.sleep(500);
		
		// Enter the name
		type(eventLandingPage.nameTxt,generatedstring,"Name");
		
		// Enter the password
		type(eventLandingPage.passwordTxt,password,"Password");
		
		// Accept the terms and conditions
		click(eventLandingPage.checkBox, "Terms and conditions checkbox");
		
		// Click on continue
		click(eventLandingPage.NGjoinEventbtn,"Join event button");
		Thread.sleep(500);
	}

}
