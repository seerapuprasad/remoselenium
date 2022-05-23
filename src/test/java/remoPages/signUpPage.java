package remoPages;
import org.openqa.selenium.By;

public class signUpPage {
	
	public static By singup = By.xpath("//span[contains(text(),'Sign up now')]");
	public static By name = By.xpath("//input[@id='name']");
	public static By email = By.id("email");
	public static By password = By.id("password");
	public static By checkBox = By.xpath("//span[@aria-disabled='false']");
	public static By submit = By.xpath("//div[contains(text(),'Sign up')]");
	
			
}
