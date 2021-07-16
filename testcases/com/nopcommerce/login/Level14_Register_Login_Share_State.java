package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Login;

import java.lang.reflect.Method;

import commons.BaseTest;
import pageObject.user.nopCommerce.HomePageObject;
import pageObject.user.nopCommerce.LoginPageObject;
import pageObject.user.nopCommerce.PageGeneratorManager;
import pageObject.user.nopCommerce.RegisterPageObject;

public class Level14_Register_Login_Share_State extends BaseTest {
	WebDriver driver;
	String email, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Pre-condition: Open browser: "+ browserName + " and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		email = getRandomEmail();
		password = "123123";
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("User_01_Login - Step 01: Click To Login link");
		loginPage = homePage.clikToLoginLink();
		
		log.info("User_01_Login - Step 02: Set login page cookie");
		loginPage.setCookies(driver, Common_01_Login.loginCookiePage);
		loginPage.sleepSecond(5);
		loginPage.refreshCurrentPage(driver);
		
		log.info("User_01_Login - Step 03: Switch to HomePage");
		homePage = loginPage.openHomePage();
		
		log.info("User_01_Login - Step 04: Verify Home Page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.verifyHomePageSliderDisplayed());
	}
	
	@Test
	public void User_01_XXX() {
		
	}
	@Test
	public void User_02_XXX() {
		
	}
	
	@Test
	public void User_03_XXX() {
		
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
