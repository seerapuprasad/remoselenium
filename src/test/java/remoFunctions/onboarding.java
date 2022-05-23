package remoFunctions;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import accelerators.Actiondrivers;
import remoPages.myEventsPage;
import remoPages.onboardingPages;

public class onboarding extends Actiondrivers{
	// Onboarding Steps
	public void continueSteps() throws Throwable
	{
		Thread.sleep(2000);
		click(onboardingPages.steps1Btn,"When you enter the event you’ll be seated at a virtual table");
		Thread.sleep(1000);
		click(onboardingPages.steps2Btn,"You can move freely by double clicking on any table");
		Thread.sleep(1000);
		click(onboardingPages.steps3Btn,"Start interacting with each other by turning ON your Cam and Mic");
		Thread.sleep(1000);
		click(onboardingPages.steps4Btn,"One more thing: Take a couple of minutes to set up your profile");
		Thread.sleep(1000);
		click(onboardingPages.steps5Btn,"User at Save Profile and Join Event page");
		Thread.sleep(1000);
	}
	
	// Mic and cam check page
	public void micaAndCam() throws Throwable
	{
		waitForVisibilityOfElement(onboardingPages.joinEventMicCamCheckbtn);
		click(onboardingPages.joinEventMicCamCheckbtn,"");
	}
	
	// Create Event
	public void skipSteps() throws Throwable
	{

	}
}
