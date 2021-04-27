package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	
	private String localPath = System.getProperty("user.dir");
	
	private enum BROWSERS{
		CHROME, FIREFOX, IE, SAFARY, EDGE_LAGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSERS browser = BROWSERS.valueOf(browserName.toUpperCase());
		if(browser == BROWSERS.CHROME) {
			System.setProperty("webdriver.gecko.driver", localPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser == BROWSERS.FIREFOX){
			System.setProperty("webdriver.chrome.driver", localPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser == BROWSERS.EDGE_CHROMIUM) {
			System.setProperty("webdriver.edge.driver", localPath + "\\browserDrivers\\msedgedriver.exe");
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
			System.setProperty("webdriver.gecko.driver", localPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", localPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge_chromium")) {
			System.setProperty("webdriver.edge.driver", localPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new RuntimeException("Browser InValid");
		}
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
