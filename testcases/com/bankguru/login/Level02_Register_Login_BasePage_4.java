package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObject.LoginPageObject;

public class Level02_Register_Login_BasePage_4 extends LoginPageObject {
	WebDriver driver;
	String userName, password, currentURL;
	String locatorPath = System.getProperty("user.dir");
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", locatorPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		currentURL = getCurrentURL(driver);
	}

	@Test
	public void Login_01_Register_To_System() {

		clickToElement(driver, "//a[text()='here']");
		sendKeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");

		userName = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
	}

	@Test
	public void Login_02_Login_To_System() {
		openPageUrl(driver, currentURL);
		sendKeyToElement(driver, USER_ID_TEXTBOX, userName);
		sendKeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		// mngr318742 gUjypYs

		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"),
				"Welcome To Manager's Page of Guru99 Bank");
	}

	/**
	 * Get random email
	 * 
	 * @return String
	 * @author Administrator
	 * @param null
	 */
	private String getRandomEmail() {
		Random rand = new Random(9999);
		return "zinzin" + rand.nextInt(99999) + "@hotmail.com";
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
