package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.MyAccountPageObject;
import pageObject.nopCommerce.OrderPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;
import pageObject.nopCommerce.SearchPageObject;



public class Level07_Register_Login_Page_Switch_Page extends BaseTest {
	WebDriver driver;
	String email, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	OrderPageObject orderPage;
	MyAccountPageObject myAccountPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		email = getRandomEmail();
		password = "123123";
		homePage = PageGeneratorManager.getHomePape(driver);

	}

	@Test
	public void Login_01_Register_To_System() {
		registerPage = homePage.clickToRegisterLink();
		sleepInSecond(3);
		registerPage.clickToGenderRadio();
		registerPage.enterFirstNameTextbox("zin");
		registerPage.enterLastNameTextbox("zin");
		registerPage.enterEmailTextbox(email);
		registerPage.enterPasswordTextbox(password);
		registerPage.enterConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isVerifySucessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
		sleepInSecond(3);
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());
		
	}

	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clikToLoginLink();
		loginPage.enterEmailTextbox(email);
		loginPage.enterPassword(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.verifyHomePageSliderDisplayed());
	}
	@Test
	public void Login_03_Switch_At_Footer() {
		//Hom Page -> Search Page
		searchPage = homePage.openSearchPage(driver);
		//Search Page -> My Account Page
		myAccountPage = searchPage.openMyAccountPage(driver);
		//My Account Page -> Order Page
		orderPage = myAccountPage.openOrderPage(driver);
		//Order Page -> My Account Page
		myAccountPage = orderPage.openMyAccountPage(driver);
		//My Account Page -> Search Page
		searchPage = myAccountPage.openSearchPage(driver);
		//Search Page -> Order Page
		orderPage = searchPage.openOrderPage(driver);
	}
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
