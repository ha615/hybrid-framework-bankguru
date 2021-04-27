package com.liveguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;

public class Level04_Register_Login_Multipe_Browser extends BaseTest{

	WebDriver driver;
	HomePageObject homePage ;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;
	
	@Parameters({"browser", "url"})
	//@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		//driver.get("http://live.demoguru99.com");

	}
	@Test
	public void TC_01_Login_Empty_Email_And_Password() {
		homePage = new HomePageObject(driver);
		homePage.clickToMyAcountLink();
		loginPage = new LoginPageObject(driver);
		loginPage.loginToSystem("", "");
		Assert.assertEquals(loginPage.getMessageWarningEmptyEmailAndPassword(), "This is a required field.");
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email() {
		loginPage.refreshPage(driver);
		loginPage = new LoginPageObject(driver);
		loginPage.enterEmailAddressTextbox("3321@345667");
		loginPage.enterPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getMessageWarningInValidEmail(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test
	public void TC_03_Login_With_Invalid_Password() {
		loginPage.refreshPage(driver);
		loginPage = new LoginPageObject(driver);
		loginPage.loginToSystem("3321@345667.com", "1231");
		Assert.assertEquals(loginPage.getMessageWarningInValidPassword(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_Login_With_Incorrect_Email() {
		loginPage.refreshPage(driver);
		loginPage = new LoginPageObject(driver);
		loginPage.loginToSystem("zinzin@hotmail.com","123123");
		Assert.assertEquals(loginPage.getMessageWarningInCorrectEmail(), "Invalid login or password.");

	}
	
	@Test
	public void TC_05_Login_With_Incorrect_Password() {
		
		loginPage.refreshPage(driver);
		loginPage = new LoginPageObject(driver);
		loginPage.enterEmailAddressTextbox("zinzin@hotmail.com");
		loginPage.enterPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getMessageWarningInCorrectPassword(), "Invalid login or password.");
	}
	
	@Test
	public void TC_06_Login_With_Valid_Email_And_Password() {
		loginPage.refreshPage(driver);
		loginPage = new LoginPageObject(driver);
		loginPage.enterEmailAddressTextbox("dam@gmail.com");
		loginPage.enterPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isMyDashboarDisplayed());
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
