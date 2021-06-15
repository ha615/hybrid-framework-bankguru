package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	private String imgUploadName = "Trump.jpg";
	private String pictureNameText = "Adobe Photoshop CS4";
	private String altText="Donal";
	private String titleText="Trump";
	private String displayText="1";
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPasswordTextbox("admin");
		dashBoardPage = loginPage.clickToLoginButton(driver);
		dashBoardPage.openSubMenuPageByName(driver, "Catalog", "Products");
		productSearchPage = PageGeneratorManager.getProductSearchPage(driver);
		productSearchPage.enterProductNameTextbox("Adobe Photoshop CS4");
		productSearchPage.clickToSearchButton();
		productDatailPage = productSearchPage.clickToEditButtonByName(pictureNameText);
		
	}

	@Test
	public void Admin01_Upload_File() {
		productDatailPage.clickToExpandPanelByName("Pictures");
		productDatailPage.uploadFileAtCardName(driver,"pictures", imgUploadName);
		Assert.assertTrue(productDatailPage.isPictureUploadSucessByFileName(imgUploadName));
		productDatailPage.enterToAltTextbox(altText);
		productDatailPage.enterToTitleTextbox(titleText);
		productDatailPage.clickToDisplayedOrderTextbox("Increase");
		productDatailPage.clickToAdProductPictureButton();
		Assert.assertTrue(productDatailPage.isPictureImageDisplayed(pictureNameText,displayText,altText,titleText));
		productSearchPage = productDatailPage.clickToSaveButton();
		
		Assert.assertTrue(productSearchPage.isSuccessMessagerDisplayed("The product has been updated successfully."));
		productSearchPage.enterProductNameTextbox(pictureNameText);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated("adobe-photoshop-cs4",pictureNameText));
		productDatailPage = productSearchPage.clickToEditButtonByName(pictureNameText);
		productDatailPage.clickToDeleteButtonAtPictureName(titleText);//accept alert
		Assert.assertTrue(productDatailPage.isSuccessMessagerDisplayedByTable("No data available in table"));
		productSearchPage = productDatailPage.clickToSaveButton();
		productSearchPage.enterProductNameTextbox(pictureNameText);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageUpdated("default-image",pictureNameText));
		
	}

	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
