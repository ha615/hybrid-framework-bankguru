package commons;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	// private String localPath = System.getProperty("user.dir");

	public WebDriver getWebDriver() {
		return this.driver;
	}

	private enum BROWSERS {
		CHROME, FIREFOX, IE, SAFARY, EDGE_LAGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BROWSERS browser = BROWSERS.valueOf(browserName.toUpperCase());
		if (browser == BROWSERS.CHROME) {
			// System.setProperty("webdriver.gecko.driver", localPath +
			// "\\browserDrivers\\geckodriver.exe");
			/* Sau khi cai dat thu vien Driver Manager */
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Driver init at Base Test" + driver.toString());
		} else if (browser == BROWSERS.FIREFOX) {
			// System.setProperty("webdriver.chrome.driver", localPath +
			// "\\browserDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == BROWSERS.EDGE_CHROMIUM) {
			// System.setProperty("webdriver.edge.driver", localPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser InValid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com");
		return driver;
	} 

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if (browserName.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", localPath +
			// "\\browserDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().driverVersion("47").setup();
			;
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", localPath +
			// "\\browserDrivers\\chromedriver.exe");
			// WebDriverManager.chromedriver().driverVersion("88.0.4324.96").setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge_chromium")) {
			// System.setProperty("webdriver.edge.driver", localPath +
			// "\\browserDrivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser InValid");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info("-------------------------- PASSED --------------------------");
			} else {
				log.info("-------------------------- FAILED --------------------------");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info("-------------------------- PASSED --------------------------");
			} else {
				log.info("-------------------------- FAILED --------------------------");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("-------------------------- PASS --------------------------");
		} catch (Throwable e) {
			pass = false;
			log.info("-------------------------- FAILED --------------------------");
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected String getRandomEmail() {
		Random rand = new Random();
		return "zinzin" + rand.nextInt(9999) + "@yahoo.com";
	}

	protected void sleepInSecond(long millis) {
		try {
			Thread.sleep(millis * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.println("---------- START delete file in folder ----------");
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "\\allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		System.out.println("---------- END delete file in folder ----------");
	}

	protected void cleanBrowserAndDriver() {
		// Khai báo 1 biến command line để thực thi
		String cmd = "";
		try {
			// Get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);
			// Quit driver executable file in Task Manager
			if (driver.toString().contains("chrome")) {
				if (osName.contains("windows"))
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				else
					cmd = "pkill chromedriver";
			} else if (driver.toString().contains("internetexplorer")) {
				if (osName.contains("window"))
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
			} else if (driver.toString().contains("firefox")) {
				if (osName.contains("windows"))
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				else
					cmd = "pkill geckodriver";

			} else if (driver.toString().contains("edge")) {
				if (osName.contains("windows"))
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				else
					cmd = "pkill msedgedriver";
			}
			// Browser
			if (driver != null) {
				// IE browser
				driver.manage().deleteAllCookies();
				driver.quit();
			}
			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
				System.out.println("Run Comand line");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
