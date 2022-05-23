package remoFunctions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.openqa.selenium.By;
import accelerators.Actiondrivers;
import remoPages.createEventPage;
import remoPages.myEventsPage;

public class Events extends Actiondrivers {

	// Create Event
	public void startEventCreation() throws Throwable {

		Thread.sleep(2000);
		waitForVisibilityOfElement(myEventsPage.createEventBtn);
		// Click on Create event button
		click(myEventsPage.createEventBtn,"");
		Thread.sleep(500);

		waitForVisibilityOfElement(myEventsPage.createcustomEventbtn);
		// Click on Create Custom Event Button
		click(myEventsPage.createcustomEventbtn,"");
		Thread.sleep(500);
		passReport("Entered into create event model");
	}

	// Validate Left Tabs
	public void validateMainMenus() throws Throwable {
		waitForElementPresent(createEventPage.prepare);
		//assertEquals(driver.findElement(createEventPage.prepare).getText(), "Prepare");
		//assertEquals(driver.findElement(createEventPage.agenda).getText(), "Agenda");
		//assertEquals(driver.findElement(createEventPage.invitations).getText(), "Invitations");
		//assertEquals(driver.findElement(createEventPage.extras).getText(), "Extras");
		//assertEquals(driver.findElement(createEventPage.summary).getText(), "Summary");
	}

	// Prepare
	public void eventDetails() throws Throwable {
		String eTitle = dataReader.getCellData("Events", "title", 2);
		String eTitleDes = dataReader.getCellData("Events", "description", 2);
		String ePageDes = dataReader.getCellData("Events", "pageDescription", 2);
		LocalDateTime myDateObj = LocalDateTime.now();  

		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy, HH:MM:SS");  

		String formattedDate = myDateObj.format(myFormatObj);  

		// validate prepare form and fields
		prepareFormValidation();

		waitForElementPresent(createEventPage.eventTitleTxt);
		eventTitle = eTitle + formattedDate;

		// Enter event title
		type(createEventPage.eventTitleTxt, eventTitle, "");
		Thread.sleep(500);

		//Enter event title description
		type(createEventPage.eventTitleDesTxt, eTitleDes, "");
		Thread.sleep(500);

		/*
		// Start time
		click(createEventPage.eventStartTime,"Start Time");
		Thread.sleep(500);
		selectStartDateTime();

		// End time
		Thread.sleep(500);
		click(createEventPage.eventEndTime, "End Time");
		Thread.sleep(500);
		selectEndDateTime();
		Thread.sleep(500);
		*/

		// Event Description
		type(createEventPage.eventPageDesTxt, ePageDes, "Entered the event description");
		Thread.sleep(500);

		// Event type
		click(createEventPage.eventtype,"");
		Thread.sleep(500);
		click(createEventPage.chooseEventType,"");
		Thread.sleep(500);

		// Click on next button
		next();
		Thread.sleep(2000);
	}

	// Select Event
	public void goToPreprare() throws Throwable
	{
		waitForVisibilityOfElement(createEventPage.prepare);
		click(createEventPage.prepare,"Prepare Tab");
		// select Prepare tab

	}

	// Select Floor plan add attendee limit
	public void selectFloorPlan() throws Throwable
	{
		//String fType = dataReader.getCellData("floorplans", "name", 2);
		String fAttandance = dataReader.getCellData("floorplans", "attandance", 2);
		String LeftBillVideoURL = dataReader.getCellData("floorplans", "VideoURL", 2);
		String videoAutoplay = dataReader.getCellData("floorplans", "Autoplay", 2);
		String RightTitle = dataReader.getCellData("floorplans", "RightBillTitle", 2);
		String RightDescripion = dataReader.getCellData("floorplans", "RightBillDescription", 2);

		// Select the floor plan

		// Add the attendance
		driver.findElement(createEventPage.attendance).clear();
		type(createEventPage.attendance,fAttandance, "");

		//Expand Left Billboard details
		click(createEventPage.LeftBTab, "Left Tab");

		// Enter the Video URL
		type(createEventPage.LeftVideoURL, LeftBillVideoURL, "");

		// Set auto play video option
		if(videoAutoplay.equalsIgnoreCase("Yes"))
		{
			click(createEventPage.LeftVideoAutoplay, "Expand Section");
		}

		// Expand Right Billboard details
		click(createEventPage.RightBTab,"Right billboard tab");

		// Enter Right bill board title
		type(createEventPage.RightBTitle,RightTitle, "Right billboard Title");

		// Enter Right bill board Description
		type(createEventPage.RightBDescription,RightDescripion, "Right billboard Description");

		// Go next
		next();
	}

	// Select Floor plan add attendee limit
	public void addSponsors(int j) throws Throwable
	{
		for(int i = 2; i <= j+1; i++)
		{
			String sName = dataReader.getCellData("Sponsors", "name", i);
			String sponsorAds = dataReader.getCellData("Sponsors", "sponsorAds", i);
			String sType = dataReader.getCellData("Sponsors", "type", i);
			String sMedia = dataReader.getCellData("Sponsors", "media", i);
			String sCalltoActionLabel = dataReader.getCellData("Sponsors", "callToText", i);
			String sCalltoActionLink = dataReader.getCellData("Sponsors", "callToLink", i);
			String addCTAButton = dataReader.getCellData("Sponsors", "addCTAButton", i);

			Thread.sleep(1000);

			// Click on the sponsor tab
			click(createEventPage.addSponsorsBtn,"Sponsor Tab");
			Thread.sleep(1000);

			// Enter the sponsor name
			type(createEventPage.sname,sName, "Sponsor Title");

			// Enter the sponsor banner
			click(createEventPage.sbannerLogo,"sponsor banner logo");

			// Upload Banner Ad image which shows on event map
			upload(sponsorAds);

			// Select the sponsor type
			if(sType.equalsIgnoreCase("VideoURL"))
			{
				// Video Media is selected
				type(createEventPage.smedia, sMedia, "");

			}else if (sType.equalsIgnoreCase("ImageURL"))
			{
				// Image Media is selected
				click(createEventPage.stypeImageURL,"Image URL");

				// Enter the media Image URL
				type(createEventPage.smedia, sMedia, "sponsor media title");

			}else
			{
				// Select upload image option
				click(createEventPage.stypeUpload,"sponsor image");

				// Click on Upload Image 
				click(createEventPage.sbannerimage,"");
				Thread.sleep(1000);

				// Upload banner image that will be showing inside the event
				upload(sMedia);
			}
			// Select Add to CTA button
			if(addCTAButton.equalsIgnoreCase("Yes"))
			{
				// Choose Call in button details
				click(createEventPage.addCTAButton,"");

				// Enter the button label
				type(createEventPage.scallToText, sCalltoActionLabel, "");

				// Enter the call to action url
				type(createEventPage.scallToLink, sCalltoActionLink, "");
			}

			// Save the sponsor
			click(createEventPage.SaveSponsor,"");
			Thread.sleep(1000);
		}
	}

	// Add Event Speakers
	public void addSpeakerInvitation() throws Throwable
	{
		String emails = dataReader.getCellData("InviteEmails", "speakersEmails", 2);

		// Select Invitation Tab
		click(createEventPage.invitation,"");
		Thread.sleep(1000);
		
		// Select Speakers tab
		click(createEventPage.speakersInvites,"");

		// Add email to the Speakers list
		type(createEventPage.addemailsList,emails, "");

		// Click on Add to List and send email button
		click(createEventPage.addspeakers,"");
		Thread.sleep(1000);
	}

	// Add Guests to the Event.
	public void addGuestInvitation() throws Throwable
	{
		String emails = dataReader.getCellData("InviteEmails", "guestsemails", 2);
		Thread.sleep(500);
		
		// Select Guests Tab
		click(createEventPage.guestsInvites,"");
		Thread.sleep(500);
		
		// Add Emails to list 
		type(createEventPage.addemailsList,emails, "");

		// Click on Add to Guest list
		click(createEventPage.addGuestsToList,"");
	}

	public void prepareFormValidation() throws Throwable {

	}

	// Verify Prepare fields
	public void verifyPreparefields() throws Throwable {

	}

	// Verify prepare Sponsors
	public void prepareSponsors() throws Throwable {

	}

	// Verify agenda Event Agenda
	public void agendaEventAgenda() throws Throwable {

		String aTitle = dataReader.getCellData("RunOfShow", "AgendaTitle", 2);
		String adescription = dataReader.getCellData("RunOfShow", "Agenda Description", 2);
		String annouce = dataReader.getCellData("RunOfShow", "Annoucement", 2);
		String sharevideo = dataReader.getCellData("RunOfShow", "Video URL", 2);
		String notes = dataReader.getCellData("RunOfShow", "Notes", 2);

		Thread.sleep(2000);
		click(createEventPage.agenda,"");
		Thread.sleep(500);

		// First Add Agenda
		click(createEventPage.addAgendaBtn,"");
		Thread.sleep(500);
		type(createEventPage.addAgendaTitle,aTitle, "");
		Thread.sleep(500);
		type(createEventPage.addAgendaDescription,adescription, "");
		Thread.sleep(500);
		click(createEventPage.saveAgenda,"");

		// Add Run of show items
		Thread.sleep(500);
		click(createEventPage.addRunOfShow,"");
		Thread.sleep(500);
		click(createEventPage.openRunOfShow,"");
		Thread.sleep(500);
		click(createEventPage.addItem,"");
		Thread.sleep(500);
		// Add Annoucement 
		click(createEventPage.Setannoucement,"");
		Thread.sleep(500);
		type(createEventPage.annoucement,annouce, "");
		click(createEventPage.saveAction,"");
		Thread.sleep(500);

		// Add Start Presentation 
		click(createEventPage.addItem2,"");
		Thread.sleep(500);
		click(createEventPage.startPresentation,"");
		Thread.sleep(500);
		click(createEventPage.saveAction,"");
		Thread.sleep(2000);

		// Start Presentation 
		click(createEventPage.addItem2,"");
		Thread.sleep(500);
		click(createEventPage.stopPresentation,"");
		Thread.sleep(500);
		click(createEventPage.saveAction,"");
		Thread.sleep(2000);

		// Add Share Video URL during Presentation 
		click(createEventPage.addItem2,"");
		Thread.sleep(500);
		click(createEventPage.SetVideo,"");
		Thread.sleep(500);
		type(createEventPage.videoURL, sharevideo, "");
		Thread.sleep(250);
		click(createEventPage.saveAction,"");
		Thread.sleep(2000);		

		// Stop Presentation 
		click(createEventPage.addItem2,"");
		Thread.sleep(500);
		click(createEventPage.removeVideoRUL,"");
		Thread.sleep(500);
		click(createEventPage.saveAction,"");
		Thread.sleep(2000);	

		// Add Notes 
		click(createEventPage.addItem2,"");
		Thread.sleep(500);
		click(createEventPage.notes,"");
		Thread.sleep(500);
		type(createEventPage.notesArea, notes, "");
		Thread.sleep(250);
		click(createEventPage.saveAction,"");
		Thread.sleep(2000);	
		// close Run of Show

		click(createEventPage.closeROS,"");
		Thread.sleep(500);
	}

	// Verify floor Plan
	public void agendaRunOfShow() throws Throwable {

	}

	// Verify floor Plan
	public void invitationsSpeakers() throws Throwable {

	}

	// Verify floor Plan
	public void invitationsAttendees() throws Throwable {

	}

	// Verify floor Plan
	public void extrasOnboarding() throws Throwable {

	}
	// Verify floor Plan
	public void extrasLobby() throws Throwable {

	}
	// Verify floor Plan
	public void postevent() throws Throwable {

	}

	// Next
	public void next() throws Throwable {
		click(createEventPage.nextBtn,"");
	}

	// Save and publish the event
	public void publishEevnt() throws Throwable {

		click(createEventPage.publishEvent,"Publish Event button");
		Thread.sleep(500);

		click(createEventPage.eventOutcome,"Set Attendees making new connections");
		Thread.sleep(500);

		click(createEventPage.saveAndPublish,"Save and Publish the event");
		Thread.sleep(500);

		passReport("The Event is successfully Created");

	}

	// Save and Close the event
	public void saveAndClose() throws Throwable {
		Thread.sleep(500);
		click(createEventPage.saveAndClose,"");
		Thread.sleep(500);
		passReport("The Event is Saved Successfully");
	}

	// select date and time
	public void selectStartDateTime() throws Throwable {

		Date date = new Date(); // given date
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date); // assigns calendar to given date
		/*
		 * calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format int h =
		 * calendar.get(Calendar.HOUR); // gets hour in 12h format
		 * calendar.get(Calendar.MONTH); // gets month number, NOTE this is zero based!
		 * System.out.println(calendar.get(Calendar.HOUR));
		 * System.out.println(calendar.get(Calendar.MONTH)+1);
		 */
		// Select the date
		click(createEventPage.datePicker,"");
		Thread.sleep(2000);
		click(By.xpath("//span[@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1']["
				+ calendar.get(Calendar.HOUR) + "]"),"");
		Thread.sleep(2000);
		click(By.xpath("//span[contains(text(),'OK')]"),"");
	}

	// select date and time
	public void selectEndDateTime() throws Throwable {

		Date date = new Date(); // given date
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date); // assigns calendar to given date
		/*
		 * calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format int h =
		 * calendar.get(Calendar.HOUR); // gets hour in 12h format
		 * calendar.get(Calendar.MONTH); // gets month number, NOTE this is zero based!
		 * System.out.println(calendar.get(Calendar.HOUR));
		 * System.out.println(calendar.get(Calendar.MONTH)+1);
		 */
		// Select the date
		click(createEventPage.datePicker,"");
		Thread.sleep(2000);
		System.out.println(calendar.get(Calendar.HOUR));
		int i = calendar.get(Calendar.HOUR) + 2;
		//click(By.xpath("//span[@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1'][" + i
		//		+ "]"));
		Thread.sleep(2000);
		click(By.xpath("//span[contains(text(),'OK')]"),"");
	}

	// Verify floor Plan
	public void logout() throws Throwable {

	}
}