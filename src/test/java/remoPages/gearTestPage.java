package remoPages;
import org.openqa.selenium.By;

public class gearTestPage {
	
	public static By systemCheckPass = By.xpath("//span[contains(text(),'System Check Passed!')]");
	public static By systemCheckFail = By.xpath("//span[contains(text(),'System Check Failed!')]");
	public static By joinEvent = By.xpath("//div[contains(text(),'Join Event')]");
	public static By seeMore = By.xpath("//p[contains(text(),'See more')]");
	public static By testAudio = By.xpath("//div[contains(text(),'Test Audio')]");
	public static By skipAndJoinEvent = By.xpath("//div[contains(text(),'Skip & Join Event')]");

		
}
