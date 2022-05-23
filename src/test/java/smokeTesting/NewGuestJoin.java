package smokeTesting;
import org.testng.annotations.Test;
import accelerators.Actiondrivers;
import remoFunctions.onboarding;
import remoFunctions.Authentication;

public class NewGuestJoin extends Actiondrivers {

	static String name;
	static String email;
	static String password;

	@Test(priority = 1, enabled = true)
	// Join event as new guest
	public static void TC_NewGuestJoin_1() throws Throwable {
		startTest("Login into Remo as New Guest");
		Thread.sleep(3000);
		Authentication guest = new Authentication();
		guest.JoinEventNG();
		endTest();
	}
	@Test(priority = 2, enabled = true)
	// Check Onboarding steps
	public static void TC_NewGuestJoin_2() throws Throwable {
		startTest("Onboarding steps");
		Thread.sleep(1000);
		onboarding s = new onboarding();
		s.continueSteps();
		endTest();
	}

	@Test(priority = 3, enabled = true)
	// Check gear test page
	public static void TC_NewGuestJoin_3() throws Throwable {
		startTest("Mic and cam check page");
		Thread.sleep(1000);
		onboarding m = new onboarding();
		m.micaAndCam();
		endTest();
	}

	@Test(priority = 4, enabled = true)
	// Check Lobby, if no lobby it should go to event space
	public static void TC_NewGuestJoin_4() throws Throwable {
		startTest("Validating Lobby");
		endTest();
	}
}