package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import java.lang.reflect.Method;

import commons.BaseTest;
import pageObject.user.nopCommerce.HomePageObject;
import pageObject.user.nopCommerce.LoginPageObject;
import pageObject.user.nopCommerce.RegisterPageObject;
//import reportConfig.ExtentTestManager;

public class Level13_Register_Login_Log_Extend_Report_V2 extends BaseTest {
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
	public void User_01_Register_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Open Home Page");
//		homePage = new HomePageObject(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 02: Open Register Page");
//		registerPage = homePage.clickToRegisterLink();
//		sleepInSecond(3);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 03: Click To Gender Radio Button");
//		registerPage.clickToGenderRadio();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 04: Enter Frist Name Textbox");
//		registerPage.enterFirstNameTextbox("zin");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 05: Enter Last Name Textbox");
//		registerPage.enterLastNameTextbox("zin");
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 06: Enter Email textbox with value: " + email);
//		registerPage.enterEmailTextbox(email);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 07: Enter Password textbox with value: " + password);
//		registerPage.enterPasswordTextbox(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 08: Enter Confirm Password Textbox with value: " + password);
//		registerPage.enterConfirmPasswordTextbox(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 09: Click To Register Button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 10: Verify User Created Success Message");
//		verifyTrue(registerPage.isVerifySucessMessageDisplayed());
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 11: click to Logout link");
//		homePage = registerPage.clickToLogoutLink();
//		sleepInSecond(3);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_01_Register - Step 12: Verify Home page is Displayed");
//		verifyTrue(homePage.verifyHomePageSliderDisplayed());	
//		ExtentTestManager.endTest();
	}

	@Test
	public void User_02_Login_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_02_Login_To_System");
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 01: Click To Login link");
//		loginPage = homePage.clikToLoginLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 02: Enter Email textbox with value: " + email);
//		loginPage.enterEmailTextbox(email);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 03: Enter Password textbox with value: " + password);
//		loginPage.enterPassword(password);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 04: click to Login button");
//		homePage = loginPage.clickToLoginButton();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"User_02_Login - Step 05: Verify Home Page is displayed");
//		verifyFalse(homePage.verifyHomePageSliderDisplayed());
//		ExtentTestManager.endTest();
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
