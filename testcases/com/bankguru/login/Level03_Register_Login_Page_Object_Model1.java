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
import pageObject.bankGuru.LoginPageObject;
import pageObject.bankGuru.RegisterPageObject;

public class Level03_Register_Login_Page_Object_Model1{
	WebDriver driver;
	String userName, password, currentURL;
	String locatorPath = System.getProperty("user.dir");
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", locatorPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.get("http://demo.guru99.com/V4/index.php");
		loginPage = new LoginPageObject(driver);
		currentURL = driver.getCurrentUrl();

		loginPage.clickHereLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.enterEmailAddressTextbox(getRandomEmail());
		registerPage.clickToSubmitButton();
		userName = registerPage.getInfoUserName();
		password = registerPage.getInfoPassword();
	}
	//mngr316362 teqEsEd
	@Test
	public void Login_02_Login_To_System() {
		driver.get(currentURL);
		loginPage = new LoginPageObject(driver);
		loginPage.enterUserIDTextbox(userName);
		loginPage.enterPasswordTextbox(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isWellcomeMessageDisplayed());
		loginPage.clickToLogoutLink();
		Assert.assertEquals(loginPage.getLogoutMessageDisplayed(),"You Have Succesfully Logged Out!!");
	}



	/**
	 * Get random email
	 * 
	 * @return String
	 * @author Administrator
	 * @param null
	 */
	private String getRandomEmail() {
		Random rand = new Random();
		return "zinzin" + rand.nextInt(99999) + "@hotmail.com";
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
