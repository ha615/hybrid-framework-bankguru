package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.RegisterPageObject;



public class Level03_Register_Login_Page_Object_Model {
	WebDriver driver;
	String firstName, lastName, email, password, currentURL;
	String locatorPath = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", locatorPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		email = getRandomEmail();
		password = "123123";
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);

	}

	@Test
	public void Login_01_Register_To_System() {
		driver.get("https://demo.nopcommerce.com/");
		Assert.assertTrue(homePage.isVerifyHomePageSliderDisplayed());	
		homePage.clickToRegisterLink();
		registerPage.clickToGenderRadio();
		registerPage.enterFirstNameTextbox("zin");
		registerPage.enterLastNameTextbox("zin");
		registerPage.enterEmailTextbox(email);
		registerPage.enterPasswordTextbox(password);
		registerPage.enterConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isVerifySucessMessageDisplayed());
		registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isVerifyHomePageSliderDisplayed());
		
	}

	@Test
	public void Login_02_Login_To_System() {
		homePage.clikToLoginLink();
		loginPage.enterEmailTextbox(email);
		loginPage.enterPassword(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isVerifyHomePageSliderDisplayed());
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
		return "zinzin" + rand.nextInt(9999) + "@hotmail.com";
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
