package smokeTesting;
import org.testng.annotations.Test;
import accelerators.Actiondrivers;
import remoFunctions.onboarding;
import remoFunctions.Authentication;

public class ExistingGuestJoin extends Actiondrivers {

	static String name;
	static String email;
	static String password;

	@Test(priority = 1, enabled = true)
	public static void TC_Existing_Guest_1() throws Throwable {
		startTest("Login into Remo as existing Guest from event landing page");
		Thread.sleep(3000);
		Authentication guest = new Authentication();
		int row = 3;
		// Max is 12
		String existinguser = dataReader.getCellData("Existing Users", "email",row);
		guest.JoinEventEG(existinguser,"03g55a0204");
		endTest();	
	}
	
	@Test(priority = 2, enabled = true)
	public static void TC_Existing_Guest_2() throws Throwable {
		startTest("Mic and cam check page");
		Thread.sleep(1000);
		onboarding m = new onboarding();
		m.micaAndCam();
		endTest();
	}
	
	@Test(priority = 3, enabled = true)
	public static void TC_Existing_Guest_3() throws Throwable {
		startTest("Login into Remo as Existing Guest");
		endTest();
	}
}