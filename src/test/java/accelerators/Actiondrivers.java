package accelerators;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import com.aventstack.extentreports.MediaEntityBuilder;

import utilities.Read_XLS;

public class Actiondrivers extends Base {

	public static WebDriverWait wait;

	public static boolean type(By locator, String value, String type) throws Throwable {
		Thread.sleep(500);
		WebElement elem = driver.findElement(locator);
		boolean flag = false;
		try {
			Actions builder = new Actions(driver);
			Action mouseOver = builder.moveToElement(elem).click().sendKeys(elem, value).build();
			mouseOver.perform();
			Thread.sleep(250);
			passReport("Successfully Entered " + type + ": " + value);
			return true;
		} catch(NoSuchElementException e) {
			flag = true;
			return false;
		} finally {
			if (flag) {} else {}
		}
	}

	// Using action builders we can send the text
	public static boolean click(By elem, String location) throws Throwable {
		boolean flag = false;
		try {
			Thread.sleep(500);
			Actions builder = new Actions(driver);
			Action mouseOver = builder.moveToElement(driver.findElement(elem)).click().build();
			mouseOver.perform();
			Thread.sleep(250);
			passReport("Successfully clicked on : " + location);
			return true;
		} catch(NoSuchElementException e) {
			flag = true;
			return false;
		} finally {
			if (flag) {
				/*
				 * Reporters.failureReport("Type ", "Data typing action is not perform on: " +
				 * locatorName+" with data is "+testdata);
				 */
				// throw new ElementNotFoundException("", "", "");

			} else {
				// Reporters.SuccessReport("Type ","Data typing action is performed on:" +
				// locatorName+" with data is "+testdata);
			}
		}
	}

	// Using action builders we can send the text
	public static boolean click(WebElement ele) {
		boolean flag = false;
		try {

			Actions builder = new Actions(driver);
			Action mouseOver = builder.moveToElement(ele).click().build();
			mouseOver.perform();
			return true;
		} catch(NoSuchElementException e) {
			flag = true;
			return false;
		} finally {
			if (flag) {
				/*
				 * Reporters.failureReport("Type ", "Data typing action is not perform on: " +
				 * locatorName+" with data is "+testdata);
				 */
				// throw new ElementNotFoundException("", "", "");

			} else {
				// Reporters.SuccessReport("Type ","Data typing action is performed on:" +
				// locatorName+" with data is "+testdata);
			}
		}
	}

	// Wait for element to invisible

	public static void waitForElementToDisappear(By locator) throws Throwable {

		for (int i = 0; i < 200; i++) {
			if (!driver.findElement(locator).isDisplayed()) {
				break;
			} else {
				Thread.sleep(50);
			}
		}
	}

	// Creating a method getScreenshot and passing two parameters
	// driver and screenshotName
	public static String getScreenshot() throws Exception {
		// below line is just to append the date format with the screenshot name to
		// avoid duplicate names
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		//String destination = System.getProperty("user.dir") + "/Screenshots/" + dateName + ".png";
		String destination = ScreenshotsPath() + dateName + ".png";
		String fileName = dateName + ".png";

		//System.out.println("Test " + destination);
		//String destination = screenshots + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		// Returns the captured file path
		return fileName;
	}

	public static void endTest() throws InterruptedException,
	FindFailed {

		extent.flush();

	}

	public static void startTest(String testcase, String category) throws InterruptedException,
	FindFailed {

		logger = extent.createTest(testcase);
		//logger.assignCategory(category);

	}
	public static void startTest(String testcase) throws InterruptedException,
	FindFailed {

		logger = extent.createTest(testcase);
	}

	public static void skipTest(String testcase, String category, String details) throws InterruptedException,
	FindFailed {

		logger = extent.createTest(testcase);
		logger.assignCategory(category);
		logger.skip(details);

	}

	public void clear() throws InterruptedException,
	FindFailed {

		Thread.sleep(2000);
		Screen screen = new Screen();
		// Pattern img2 = new Pattern("D:\\Sippi\\MVN Projects\\SME9JA
		// Live\\Sikuli\\open.jpg");
		// screen.type(img1,"D:\\Sippi\\MVN Projects\\SME9JA Live\\images\\goods\\good1
		// (1).jpg");
		screen.click("C:\\Users\\Praniksha\\git\\riotlysocial\\riotlysocial\\clear.png");
		Thread.sleep(2000);

	}

	//upload Image
	public static void upload(String path) throws Throwable {
		Thread.sleep(2000);
		String filepath = "D:\\SELENIUM\\remoConference\\uploads\\AutoIT\\"+path;
        Runtime.getRuntime().exec(filepath);
        Thread.sleep(10000);
	}

	public static void openNewBrowser(String URL)
	{
		driver.navigate().to(URL);;
	}

	public static String resultsPath() {
		String strDirectoy = configProps.getProperty("browserType")+"\\";
		if (strDirectoy.equalsIgnoreCase("Chrome")) {

			new File(configProps.getProperty("extentresultspath") + strDirectoy + Base.timeStamp).mkdirs();
		}
		return configProps.getProperty("extentresultspath") + strDirectoy + Base.timeStamp + "\\";
	}

	public static String ScreenshotsPath() {
		String strDirectoy = "";
		if (configProps.getProperty("browserType").equalsIgnoreCase("chrome")) {
			strDirectoy = "Chrome_";
		}

		if (strDirectoy != "") {
			new File(configProps.getProperty("extentresultspath") + strDirectoy + Base.timeStamp);
		}
		return configProps.getProperty("extentresultspath") + strDirectoy + Base.timeStamp + "\\";
	}

	public static void closeBrowser()
	{
		driver.quit();
	}

	public static void passReport(String stepDetails) throws Throwable
	{
		
		//logger.pass(stepDetails, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
	}

	public static void failReport(String stepDetails) throws Throwable
	{
		logger.pass(stepDetails, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
	}
	public static void waitForElementPresent(By locator) throws Throwable {
		for (int i = 0; i < 200; i++) {
			if (driver.findElement(locator).isDisplayed()) {
				break;
			} else {
				Thread.sleep(50);
			}
			{
				try {
					driver.wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void waitForVisibilityOfElement(By by){

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", driver.findElement(by));

	}

	//19.
	//To Check Element is Displayed or No.
	public static void isElementDisplayed(WebElement element) {
		boolean elementDisplayed = element.isDisplayed();
		if (elementDisplayed) {
			System.out.println("Element is Displayed");
		} else {
			System.out.println("Element is not Displayed");
		}
	}

	public static void selectDate(By locator, int value) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> dates = driver.findElements(locator);
		//System.out.println(dates.size());
		dates.get(value).click();
		Thread.sleep(2000);
	}

	// Using action builders we can send the text
	public static boolean moveToElement(By elem) {
		boolean flag = false;
		try {

			Actions builder = new Actions(driver);
			Action mouseOver = builder.moveToElement(driver.findElement(elem)).build();
			mouseOver.perform();
			return true;
		} catch(NoSuchElementException e) {
			flag = true;
			return false;
		} finally {
			if (flag) {
				/*
				 * Reporters.failureReport("Type ", "Data typing action is not perform on: " +
				 * locatorName+" with data is "+testdata);
				 */
				// throw new ElementNotFoundException("", "", "");

			} else {
				// Reporters.SuccessReport("Type ","Data typing action is performed on:" +
				// locatorName+" with data is "+testdata);
			}
		}
	}
	
	// Using action builders we can send the text
		public static void autoIT()
		{
			/*
			//Shift focus to the file upload windows 
			//set text/path into file name edit box 
			//click open to upload file Au3info- record window component objects Build Script -scite.exe Save it- .au3 extenstion Convert file into .exe by compiling .au3 file Call .exe file with Runtime class in java into your selenium tests 

			ControlFocus("Open","","Edit1") 
			ControlSetText("Open","","Edit1","C:\Users\rahul\Documents\check\visit.pdf") 
			ControlClick("Open","","Button1") */
		}
	
}