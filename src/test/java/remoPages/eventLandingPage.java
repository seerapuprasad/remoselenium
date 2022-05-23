package remoPages;

import org.openqa.selenium.By;

public class eventLandingPage {
	public static By getButtonText = By.xpath("//button[@data-testid='join-event-button']");
	public static By joinEvent = By.xpath("//div[contains(text(),'Join Event')]");
	public static By joinLobby = By.xpath("//div[contains(text(),'Join Lobby')]");
	public static By emailTxt = By.xpath("//input[@name='email']");
	public static By continuebtn = By.xpath("//div[contains(text(),'Continue')]");
	public static By nameTxt = By.xpath("//input[@name='name']");
	public static By passwordTxt = By.xpath("//input[@name='password']");
	public static By checkBox = By.xpath("//span[@aria-disabled='false']");
	public static By NGjoinEventbtn = By.xpath("//div[contains(text(),'Join Event')]");
	public static By EGjoinEventbtn = By.xpath("//button[@id='enter-password-modal_primary-cta-join-event-now']");
}
