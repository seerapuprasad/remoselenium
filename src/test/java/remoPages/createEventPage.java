package remoPages;

import org.openqa.selenium.By;

public class createEventPage {
	
		// Left Tabs
		public static By prepare = By.xpath("//span[contains(text(),'Prepare')]");
		public static By floorplan = By.xpath("//span[contains(text(),'Floor Plan')]");
		public static By Sponsors = By.xpath("//span[contains(text(),'Sponsors')]");

		public static By agenda = By.xpath("//div[@id='root']/div/div[3]/div/div[2]/div/nav/a[3]/div[2]/span");
		public static By invitation = By.xpath("//span[contains(text(),'Invitations')]");
		
		public static By eventtype = By.xpath("//div[@id='event-type']");
		public static By chooseEventType = By.xpath("//div[@id='menu-eventType']/div[3]/ul/li[1]");
		public static By eventOutcome = By.xpath("//button[contains(text(),'Attendees making new connections')]");
		public static By saveAndPublish = By.xpath("//div[contains(text(),'Save and Publish Event')]");
		
		public static By eventTitleTxt = By.xpath("//input[@name='eventName']"); 
		public static By eventTitleDesTxt = By.xpath("//input[@name='eventShortDesc']"); 
		public static By eventPageDesTxt = By.xpath("//div[@class='DraftEditor-editorContainer']"); 

		public static By nextBtn = By.xpath("//button[@id='manage-event-next']"); 
		public static By eventStartTime = By.xpath("//input[@id='event-start-time-field']");
		public static By datePicker = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersDay-day MuiPickersDay-current']//span[1]");
		public static By selecHour = By.xpath("//span[@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiPickersClockNumber-clockNumberSelected MuiTypography-body1']");
		public static By hoursList = By.xpath("//span[@class='MuiTypography-root MuiPickersClockNumber-clockNumber MuiTypography-body1']");
		public static By eventEndTime= By.xpath("//input[@id='event-end-time-field']");
		
		// Save, Save and Publish and Next button
		//public static By publishEvent = By.xpath("//div[contains(text(),'Publish Event')]");
		public static By publishEvent = By.xpath("//header/div[1]/div[2]/div[1]/button[1]/div[1]");
		public static By closepopup = By.xpath("//button[@aria-label='close']");
		public static By saveAndClose = By.xpath("//span[contains(text(),'Save and Close')]");
		
		// Floor plans
		public static By attendance = By.xpath("//input[@name='eventCapacity']");
		public static By LeftBTab = By.xpath("//span[contains(text(),'Left Billboard')]");
		public static By LeftVideoURL = By.xpath("//input[@name='leftBillboard']");
		public static By LeftVideoAutoplay = By.xpath("//span[contains(text(),'Autoplay')]");
		public static By RightBTab = By.xpath("//span[contains(text(),'Right Billboard')]");
		public static By RightBTitle = By.xpath("//input[@name='rightBillboardTitle']");
		public static By RightBDescription = By.xpath("//textarea[@name='rightBillboardContent']");
		
		
		// Sponsors Section
		public static By addSponsorsBtn = By.xpath("//div[contains(text(),'Add Sponsor')]");
		public static By sname = By.xpath("//input[@name='name']");
		public static By sbannerLogo = By.xpath("//span[contains(text(),'Upload image')]");
		public static By stypeVideo = By.xpath("");
		public static By stypeImageURL = By.xpath("//span[contains(text(),'Image URL')]");
		public static By stypeUpload = By.xpath("//span[contains(text(),'Upload image')]");
		public static By sbannerimage = By.xpath("//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]");
		public static By smedia =  By.xpath("//input[@name='media']");
		public static By scallToText = By.xpath("//input[@name='ctaLabel']");
		public static By scallToLink = By.xpath("//input[@name='ctaLink']");
		public static By SaveSponsor = By.xpath("//div[contains(text(),'Save Sponsor')]"); 
		public static By addCTAButton = By.xpath("//div[3]/button/div/div");
	
		// Event Agenda
		public static By addAgendaBtn = By.xpath("//button[@id='event-agenda-add']");
		public static By addAgendaTitle = By.xpath("//input[@name='title']");
		public static By addAgendaDescription = By.xpath("//textarea[@name='description']");
		public static By saveAgenda = By.xpath("//div[contains(text(),'Save Item')]");
		public static By addRunOfShow = By.xpath("//span[contains(text(),'Run of Show')]");
		public static By openRunOfShow = By.xpath("//span[contains(text(),' Open Run of Show')]");
		public static By addItem = By.xpath("//button[@class='add-action-btn show']");
		public static By addItem2 = By.xpath("//button[@class='add-action-btn ']");
		public static By Setannoucement = By.xpath("//div[contains(text(),'Set Announcement')]");
		public static By startPresentation = By.xpath("//div[contains(text(),'Start Presentation')]");
		public static By stopPresentation = By.xpath("//div[contains(text(),'Stop Presentation')]");
		public static By SetVideo = By.xpath("//div[contains(text(),'Play Video Presentation Mode')]");
		public static By removeVideoRUL = By.xpath("//div[contains(text(),'Remove Video Presentation Mode')]");
		public static By notes = By.xpath("//div[contains(text(),'Create Note')]");
		public static By annoucement = By.xpath("//textarea[@name='announcement']");
		public static By videoURL = By.xpath("//textarea[@id='run-of-show-video-input']");
		public static By notesArea = By.xpath("//textarea[@class='custom-textarea']");
		public static By saveAction	 = By.xpath("//span[contains(text(),'Save Action')]");
		public static By closeROS = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text close-btn']");
		
		// Invitations
		public static By speakersInvites = By.xpath("//span[contains(text(),'Speakers')]");
		public static By guestsInvites = By.xpath("//div[@class='MuiListItemText-root']//span[contains(text(),'Guests')]");
		public static By addemailsList = By.xpath("//input[@placeholder='Add emails separated by pressing \"enter\"']");
		public static By addspeakers = By.xpath("//div[contains(text(),'Add to Speakers List')]");
		public static By addlist1 = By.xpath("//label[contains(text(),'Speaker Email')]");
		public static By addlist2 = By.xpath("//label[contains(text(),'Guest Emails')]");
		public static By yesSend = By.xpath("//div[contains(text(),'Yes, send email invitations')]");
		public static By addGuestsToList = By.xpath("//div[contains(text(),'Add to Guest List')]");

	}
