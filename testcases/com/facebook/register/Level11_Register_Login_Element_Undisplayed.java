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


public class Level11_Register_Login_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		registerPage.enterEmailTextbox("zinzin@yahoo.com");
		sleepInSecond(3);
	}
	
	@Test
	public void Register_05_Element_Undisplayed() {
		registerPage.enterEmailTextbox("");
		sleepInSecond(3);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUnDisplayed());
	}

	@Test
	public void Register_02_Element_Undisplayed_On_UI_And_Visible_In_DOM() {
		registerPage.enterEmailTextbox("");
		sleepInSecond(3);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUnDisplayed());
		
	}
	
	@Test
	public void Register_03_Element_Undisplayed_Not_Exist_In_DOM() {
		//un displayed: invisible on UI and not in DOM
		//wait maximum time of implicitWait
		Assert.assertFalse(registerPage.isLoginButtonDisplayed());
	}
	
	@Test
	public void Register_04_Element_Undisplayed_Not_Exist_In_DOM() {
		//un displayed: invisible on UI and not in DOM
		//wait maximum time of implicitWait => use List<WebElement> -> findElements
		//override timeout of implicit
		Assert.assertTrue(registerPage.isLoginButtonUnDisplayed());
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
