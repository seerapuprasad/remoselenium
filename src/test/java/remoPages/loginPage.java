package remoPages;
import org.openqa.selenium.By;

public class loginPage {
	
	public static By email = By.id("email");
	public static By password = By.id("password");
	public static By login = By.xpath("//div[@class='email-container']//div[contains(text(),'Log in')]");	
	
}
