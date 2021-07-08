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
		log.info("Register 01 - Step 1: Kiem tra email textbox hien thi");
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		log.info("Register 01 - Step 2: Kiem tra confirm email textbox khong hien thi");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUnDisplayed());
		log.info("Register 01 - Step 3: Nhap email textbox");
		registerPage.enterEmailTextbox("zinzin@yahoo.com");
		sleepInSecond(3);
		log.info("Register 01 - Step 4: Kiem tra confirm email textbox hien thi");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		log.info("Register 01 - Step 5: Kiem tra email textbox khong hien thi");
		Assert.assertFalse(registerPage.isEmailTextboxUnisplayed());
		log.info("Register 01 - Step 6: Lam moi trang web");
		registerPage.refreshCurrentPage(driver);
	}
	
	@Test
	public void Register_02_Verify() {
		log.info("Register 02 - Step 1: Kiem tra email textbox hien thi");
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		log.info("Register 02 - Step 2: Kiem tra confirm email textbox khong hien thi");
		verifyFalse(registerPage.isConfirmEmailTextboxUnDisplayed());		
		log.info("Register 02 - Step 3: Nhap email textbox");
		registerPage.enterEmailTextbox("zinzin@yahoo.com");
		sleepInSecond(3);
		log.info("Register 02 - Step 4: Kiem tra confirm email textbox hien thi");
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());	
		log.info("Register 02 - Step 5: Kiem tra email textbox khong hien thi");
		verifyFalse(registerPage.isEmailTextboxUnisplayed());
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
