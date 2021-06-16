package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;	
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	//private String localPath = System.getProperty("user.dir");
	
	private enum BROWSERS{
		CHROME, FIREFOX, IE, SAFARY, EDGE_LAGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSERS browser = BROWSERS.valueOf(browserName.toUpperCase());
		if(browser == BROWSERS.CHROME) {
			//System.setProperty("webdriver.gecko.driver", localPath + "\\browserDrivers\\geckodriver.exe");
			/*Sau khi cai dat thu vien Driver Manager*/
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Driver init at Base Test" + driver.toString());
		}
		else if(browser == BROWSERS.FIREFOX){
			//System.setProperty("webdriver.chrome.driver", localPath + "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser == BROWSERS.EDGE_CHROMIUM) {
			//System.setProperty("webdriver.edge.driver", localPath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			throw new RuntimeException("Browser InValid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com");
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if(browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", localPath + "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().driverVersion("47").setup();;
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", localPath + "\\browserDrivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().driverVersion("88.0.4324.96").setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge_chromium")) {
			//System.setProperty("webdriver.edge.driver", localPath + "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			throw new RuntimeException("Browser InValid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	
	protected String getRandomEmail() {
		Random rand = new Random();
		return "zinzin" + rand.nextInt(9999) + "@hotmail.com";
	}
	
	protected void sleepInSecond(long millis) {
		try {
			Thread.sleep(millis*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
