package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;



public class Level05_Register_Login_Page_Factory extends BaseTest {
	WebDriver driver;
	String email, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		email = getRandomEmail();
		password = "123123";
	}

	@Test
	public void Login_01_Register_To_System() {
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		sleepInSecond(3);
		registerPage.clickToGenderRadio();
		registerPage.enterFirstNameTextbox("zin");
		registerPage.enterLastNameTextbox("zin");
		registerPage.enterEmailTextbox(email);
		registerPage.enterPasswordTextbox(password);
		registerPage.enterConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.verifySucessMessageDisplayed());
		registerPage.clickToLogoutLink();
		sleepInSecond(3);
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());
		
	}

	@Test
	public void Login_02_Login_To_System() {
		homePage.clikToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterEmailTextbox(email);
		loginPage.enterPassword(password);
		loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());
	}

	/**
	 * Get random email
	 * 
	 * @return String
	 * @author Administrator
	 * @param null
	 */

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
