package smokeTesting;
import org.testng.annotations.Test;
import accelerators.Actiondrivers;
import remoFunctions.Authentication;
import remoFunctions.Events;
import remoFunctions.MyEvents;

public class HostConvAndPresentation extends Actiondrivers {

    static String name;
    static String email;
    static String password;

    @Test(priority = 1, enabled = true)
	public static void TC_HostConvAndPresentation_1() throws Throwable {
		startTest("Enter into REMO Application as Host");
		name = dataReader.getCellData("Sign Up", "name", role);
		email = dataReader.getCellData("Sign Up", "email", role);
		password = dataReader.getCellData("Sign Up", "password", role);
		Authentication host = new Authentication();
		host.login(email, password);
		endTest();
	}
	
	@Test(priority = 2, enabled = true)
	public static void TC_HostConvAndPresentation_2() throws Throwable {
		startTest("Start creating new event");
		Events e = new Events();
		e.startEventCreation();
		endTest();
	}
	
	@Test(priority = 3, enabled = true)
	public static void TC_HostConvAndPresentation_3() throws Throwable {
		startTest("Prepare Event");
		Events p = new Events();
		p.eventDetails();
		endTest();
	}
	
	@Test(priority = 4, enabled = true)
	public static void TC_HostConvAndPresentation_4() throws Throwable {
		startTest("Select floor plan");
		Events f = new Events();
		f.selectFloorPlan();
		endTest();
	}
	
	@Test(priority = 5, enabled = true)
	public static void TC_HostConvAndPresentation_5() throws Throwable {
		startTest("Start adding sponsors");
		Events s = new Events();
		s.addSponsors(4);
		endTest();
	}
	
	@Test(priority = 6, enabled = true)
	public static void TC_HostConvAndPresentation_6() throws Throwable {
		startTest("Save and Publish the event");
		Events p = new Events();
		p.publishEevnt();
		endTest();
	}
	
	@Test(priority = 7, enabled = true)
	public static void TC_HostConvAndPresentation_7() throws Throwable {
		startTest("Filling the Agenda Details");
		MyEvents p = new MyEvents();
		Events a = new Events();
		p.selectEvent();
		a.agendaEventAgenda();
		endTest();
	}
	
	@Test(priority = 8, enabled = true)
	public static void TC_HostConvAndPresentation_8() throws Throwable {
		startTest("Add Speakers and Guests Invitations");
		Events a = new Events();
		a.addSpeakerInvitation();
		a.addGuestInvitation();
		Thread.sleep(1000);
		a.saveAndClose();
		endTest();
	}
    
}