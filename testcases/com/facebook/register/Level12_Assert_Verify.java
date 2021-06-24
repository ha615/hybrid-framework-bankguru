package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.PageGeneratorManager;
import pageObject.facebook.RegisterPageObject;


public class Level12_Assert_Verify extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Assert() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		sleepInSecond(3);
		Assert.assertTrue(registerPage.isConfirmEmailUnDisplayed());
		registerPage.enterEmailTextbox("zinzin@yahoo.com");
		Assert.assertFalse(registerPage.isEmailTextboxDisplayed());
		Assert.assertTrue(registerPage.isEmailTextboxUnisplayed());
	}
	
	@Test
	public void Register_02_Verify() {
		verifyTrue(registerPage.isEmailTextboxDisplayed());
		sleepInSecond(3);
		verifyFalse(registerPage.isConfirmEmailUnDisplayed());
		registerPage.enterEmailTextbox("zinzin@yahoo.com");
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		verifyTrue(registerPage.isEmailTextboxUnisplayed());
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
