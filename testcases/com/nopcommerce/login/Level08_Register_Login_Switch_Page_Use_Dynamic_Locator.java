package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.nopCommerce.HomePageObject;
import pageObject.user.nopCommerce.LoginPageObject;
import pageObject.user.nopCommerce.MyAccountPageObject;
import pageObject.user.nopCommerce.OrderPageObject;
import pageObject.user.nopCommerce.PageGeneratorManager;
import pageObject.user.nopCommerce.RegisterPageObject;
import pageObject.user.nopCommerce.SearchPageObject;



public class Level08_Register_Login_Switch_Page_Use_Dynamic_Locator extends BaseTest {
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
		searchPage = homePage.openSearchPage(driver,"Search");
		//Search Page -> My Account Page
		myAccountPage = searchPage.openMyAccountPage(driver,"My account");
//		//My Account Page -> Order Page
//		orderPage = myAccountPage.openOrderPage(driver);
//		//Order Page -> My Account Page
//		myAccountPage = orderPage.openMyAccountPage(driver);
//		//My Account Page -> Search Page
//		searchPage = myAccountPage.openSearchPage(driver);
//		//Search Page -> Order Page
//		orderPage = searchPage.openOrderPage(driver);
	}
	@Test
	public void Login_04_Open_Page_At_Footer() {
		//Hom Page -> Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		Assert.assertTrue(searchPage.isSearchPageDisplayed());
		//Search Page -> My Account Page
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver,"My account");
		Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
		//My Account Page -> Order Page
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver,"Orders");
		//Order Page -> My Account Page
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver,"My account");
		//My Account Page -> Search Page
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver, "Search");
		//Search Page -> Order Page
		orderPage = (OrderPageObject) searchPage.getFooterPageByName(driver, "Orders");
	}
	@Test
	public void Login_05_Open_Page_At_Footer() {

		//Order Page -> My Account Page
		orderPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		//My Account Page -> Search Page
		myAccountPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		//Search Page -> Order Page
		searchPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
		//Order Page ->  Search Page
		orderPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		//Search Page -> My Account Page
		searchPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		//My Account Page -> Order Page
		myAccountPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
