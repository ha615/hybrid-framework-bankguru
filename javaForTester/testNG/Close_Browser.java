package testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Close_Browser {

	WebDriver driver;
	
	@BeforeClass // Pre-condition
	public void beforeClass() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		//init driver/browser
		//init page class
		//init data test
		//query to DB
		//creat flow for bellow testcase
		//abc function -> failed
		Thread.sleep(5000);;
	}

	@Test
	public void TC01() {
	}

	@Test
	public void TC02() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
