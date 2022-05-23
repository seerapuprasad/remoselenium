package remoPages;
import org.openqa.selenium.By;

public class companyRegisterPage {
	public static By menu = By.xpath("//a[@id='tl-menu-button']");
	public static By beaHost = By.xpath("//span[contains(text(),'Be a Host')]");
	public static By companyName = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/div[2]/input[1]");
	public static By uploadCompanyLogo = By.xpath("//div[contains(text(),'Upload company logo')]");
	public static By saveAndContinue = By.xpath("//div[contains(text(),'Save and Continue')]");
	public static By timeZone = By.xpath("//div[contains(text(),'Save Timezone')]");
	public static By predefineEvent = By.xpath("//h5[contains(text(),'Jump Right into a Pre-Configured Event')]");
}
