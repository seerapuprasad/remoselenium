package remoFunctions;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import org.openqa.selenium.By;

import accelerators.Actiondrivers;
import remoPages.createEventPage;
import remoPages.myEventsPage;

public class MyEvents extends Actiondrivers{
	// Select Event
	public void selectEvent() throws Throwable
	{
		Thread.sleep(5000);
		// Close the pop up
		click(myEventsPage.closePopUP,"");
		
		// Move over the event title
		moveToElement(By.xpath("//span[@title='"+eventTitle+"']"));
		Thread.sleep(1000);
		
		// Click on Edit the event
		click(myEventsPage.editEvent,"");
		Thread.sleep(2000);
	}
	
}
