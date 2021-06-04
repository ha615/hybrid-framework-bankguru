package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.nopCommerce.DashboardPageObject;
import pageObject.admin.nopCommerce.LoginPageObject;
import pageObject.admin.nopCommerce.PageGeneratorManager;
import pageObject.admin.nopCommerce.ProductDetailPageObject;
import pageObject.admin.nopCommerce.ProductSearchPageObject;


public class Level10_Admin_Upload_File_Use_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	DashboardPageObject dashBoardPage;
	LoginPageObject loginPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailPageObject productDatailPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void Admin01_Upload_File() {
		dashBoardPage = loginPage.clickToLoginButton(driver);
		
		
	}

	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
