package smokeTesting;
import org.testng.annotations.Test;
import accelerators.Actiondrivers;
import remoFunctions.Authentication;
import remoFunctions.BeaHost;

public class NewAccount extends Actiondrivers {
	// SignUp into remo as new User
	@Test(priority = 1, enabled = true)
	public static void TC_NewAccount_1() throws Throwable {

		startTest("Signup As New User into Remo account from signup page");
		Authentication host = new Authentication(); 
		host.singUp(); 
		endTest();
		
		/*
		 * startTest("Verfiy Login into Remo as existing Host Account");
		 * System.out.println(role); Authentication host = new Authentication();
		 * host.login("automation+fgndlqaz@remo.co", "03g55a0204"); endTest();
		 */
	}

	// Become as Host and Create a new company
	@Test(priority = 2, enabled = true)
	public static void TC_NewAccount_2() throws Throwable {
		startTest("Become as Host and Create a new company");
		BeaHost create = new BeaHost();
		create.companyRegister(companyName);
		endTest();
	}

	// Create a default my first event
	@Test(priority = 3, enabled = true)
	public static void TC_NewAccount_3() throws Throwable {
		startTest("Create a My first event");
		Thread.sleep(1000);
		endTest();
	}

	// Do some basic operation
	@Test(priority = 4, enabled = true)
	public static void TC_NewAccount_4() throws Throwable {
		startTest("Doing basic Operation on Event space");
		endTest();
	}
}