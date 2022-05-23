package accelerators;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.Accessories;
import utilities.Property;
import utilities.Read_XLS;

public class Base {
	public static String xlfile = (System.getProperty("user.dir") + "\\TestData\\RC_Test_Data.xlsx");
	public static Read_XLS dataReader = new Read_XLS(xlfile);
	static String driverPath = System.getProperty("user.dir") + "\\Drivers\\";
	public static String timeStamp = Accessories.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	public static Property configProps = new Property("config.properties");
	public static int role ;
	public static String Env;
	public static String UrlContains;
	public static int eventdata = 2;
	public static String screenshots;
	public static WebDriver driver;
	public static FirefoxOptions firefox_options;
	static String browser = null;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String eventURL = null;
	public static String eventTitle = null;
	public static String companyName;
	@BeforeSuite(alwaysRun = true)
	public static void setupSuite() throws Throwable {
		// Initializing reporter paths and tests
		intializeextentReport();
		browser = configProps.getProperty("browserType");
		UrlContains = configProps.getProperty("URL");
		if(UrlContains.contains("live"))
		{
			Env = "live";
			role = 2;
		}else if(UrlContains.contains("next"))
		{
			Env = "next";
			role = 3;
		}else if(UrlContains.contains("staging"))
		{
			Env = "staging";
			role = 4;
		}else if(UrlContains.contains("dev"))
		{
			Env = "dev";
			role = 5;
		} else
		{
			Env = "vercel";
			role = 6;
		}
		if (browser.toString().equalsIgnoreCase("chrome")) {
			ChromeOptions chrome_options = new ChromeOptions();
			chrome_options.addArguments("--use-fake-ui-for-media-stream");
			chrome_options.addArguments("--use-fake-device-for-media-stream");
			chrome_options.addArguments("--use-fake-ui-for-media-stream");
			chrome_options.addArguments("--use-fake-device-for-media-stream");
			chrome_options.addArguments("--use-fake-ui-for-media-stream");
			chrome_options.addArguments("--use-fake-device-for-media-stream");
			chrome_options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			chrome_options.addArguments("--disable-extensions");
			chrome_options.addArguments("test-type");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			chrome_options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver100.exe");
			driver = new ChromeDriver(chrome_options);

			driver.get(configProps.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if (browser.toString().equalsIgnoreCase("firefox"))
		{
			//Setting webdriver.gecko.driver property
			System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
			//Instantiating driver object and launching browser
			firefox_options = new FirefoxOptions();
			firefox_options.addPreference("dom.webnotifications.enabled", false);
			firefox_options.addArguments("--disable-infobars");
			firefox_options.addArguments("use-fake-ui-for-media-stream");
			firefox_options.addArguments("start-maximized");
			firefox_options.addArguments("--disable-extensions");
			firefox_options.addPreference("media.navigator.streams.fake", true);
			firefox_options.addPreference("permissions.default.microphone", 1);
			firefox_options.addPreference("permissions.default.camera", 1);
			driver = new FirefoxDriver(firefox_options);
			driver.get(configProps.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if (browser.toString().equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setCapability("dom.webnotifications.enabled", 1);
			edgeOptions.setCapability("permissions.default.microphone", 1);
			edgeOptions.setCapability("permissions.default.camera", 1);					
			driver = new EdgeDriver(edgeOptions);
			driver.get(configProps.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}

	public static void intializeextentReport() {
		reporter = new ExtentSparkReporter(Actiondrivers.resultsPath() + "//Summary_" + Base.timeStamp + ".html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Remo Selenium Results");
		reporter.config().setReportName("REMO Virtual Office Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Author", "Prasad Seerapu");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown(ITestContext ctx) throws Throwable {
		Accessories.calculateSuiteExecutionTime();
		//driver.quit();
	}

	@AfterClass(alwaysRun = true)
	public static void closeBrowser()
	{
		driver.quit();
	}


}