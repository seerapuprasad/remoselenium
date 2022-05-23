package smokeTesting;
import org.testng.annotations.Test;
import accelerators.Actiondrivers;
import remoFunctions.MyEvents;
import remoFunctions.Authentication;
import remoFunctions.Events;

public class EventCreation extends Actiondrivers {

	static String name;
	static String email;
	static String password;

	// Login as Host 
	@Test(priority = 1, enabled = true)
	public static void TC_FullEvent_1() throws Throwable {
		startTest("Enter into REMO Application as Host");
		name = dataReader.getCellData("Sign Up", "name", role);
		email = dataReader.getCellData("Sign Up", "email", role);
		password = dataReader.getCellData("Sign Up", "password", role);
		Authentication host = new Authentication();
		host.login(email, password);
		endTest();
	}
	
	// Create an Event
	@Test(priority = 2, enabled = true)
	public static void TC_FullEvent_2() throws Throwable {
		startTest("Start creating new event by starting with event details");
		Events e = new Events();
		e.startEventCreation();
		endTest();
	}
	
	// Filling the event details
	@Test(priority = 3, enabled = true)
	public static void TC_FullEvent_3() throws Throwable {
		startTest("Prepare Event");
		Events p = new Events();
		p.eventDetails();
		endTest();
	}
	
	// Selecting floor plan
	@Test(priority = 4, enabled = true)
	public static void TC_FullEvent_4() throws Throwable {
		startTest("Select floor plan");
		Events f = new Events();
		f.selectFloorPlan();
		endTest();
	}
	
	// Adding sponsors
	@Test(priority = 5, enabled = true)
	public static void TC_FullEvent_5() throws Throwable {
		startTest("Start adding sponsors");
		Events s = new Events();
		s.addSponsors(10);
		endTest();
	}
	
	@Test(priority = 6, enabled = true)
	public static void TC_FullEvent_6() throws Throwable {
		startTest("Add Speakers and Guests Invitations");
		Events a = new Events();
		a.addSpeakerInvitation();
		a.addGuestInvitation();
		endTest();
	}	
	
	@Test(priority = 7, enabled = true)
	public static void TC_FullEvent_7() throws Throwable {
		startTest("Save and Publish the event");
		Events p = new Events();
		Thread.sleep(1000);
		p.publishEevnt();
		endTest();
	}
	
	@Test(priority = 8, enabled = false)
	public static void TC_FullEvent_8() throws Throwable {
		startTest("Filling the Agenda Details");
		MyEvents p = new MyEvents();
		Events a = new Events();
		p.selectEvent();
		a.agendaEventAgenda();
		endTest();
	}
	
	
}