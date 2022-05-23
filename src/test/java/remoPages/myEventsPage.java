package remoPages;

import org.openqa.selenium.By;

public class myEventsPage {

	public static By createEventBtn = By.xpath("//div[contains(text(),'Create Event')]");
	public static By createcustomEventbtn = By.xpath("//button[@id='create-custom-event']");
	
	public static By copyURL = By.xpath("//button[@id='event-create_secondary-cta-copy-link']");
	public static By closePopUP = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root close-button']");
	
	public static By userAvatar = By.xpath("//div[@id='tr-avatar']");
	public static By myProfile = By.xpath("//span[contains(text(),'My Profile')]");
	public static By signOut = By.xpath("//span[contains(text(),'Sign Out')]");
	
	public static By eventTitle = By.xpath("//span[@title='Testing']");
	public static By editEvent = By.xpath("//a[@title='Edit this event']");
	
}
