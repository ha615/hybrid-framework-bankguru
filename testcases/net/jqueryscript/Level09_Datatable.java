package net.jqueryscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;




public class Level09_Datatable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePape(driver);
	}

	//@Test
	public void Table_01_Paging() {
		homePage.openPageByNumber("13");	
		sleepInSecond(3);
		Assert.assertTrue(homePage.isPageActiveByNumber("13"));
		
		homePage.openPageByNumber("2");	
		sleepInSecond(3);
		Assert.assertTrue(homePage.isPageActiveByNumber("2"));
		
		homePage.openPageByNumber("20");	
		sleepInSecond(3);
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));
	}

	//@Test
	public void Table_02_Input_Header_Textbox() {
		homePage.enterValueToHeaderTextbox("Country","Cabo Verde");
		homePage.refreshCurrentPage(driver);

		homePage.enterValueToHeaderTextbox("Females", "150943");
		homePage.refreshCurrentPage(driver);

		homePage.enterValueToHeaderTextbox("Total", "223695");
		homePage.refreshCurrentPage(driver);
	
	}
	
	//@Test
	public void Table_03_Click_Icon() {
		homePage.clickToIconByCountryName("Argentina","remove");
		sleepInSecond(3);

		homePage.clickToIconByCountryName("Algeria","edit");
		sleepInSecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.clickToIconByCountryName("Antigua and Barbuda","remove");
		sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}

	//@Test
	public void Table_04_Verify_Rows_Values() {
		homePage.enterValueToHeaderTextbox("Country", "Argentina");
		Assert.assertTrue(homePage.isRowsValueDisplayd("338282","Argentina","349238","687522"));
		sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.enterValueToHeaderTextbox("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowsValueDisplayd("384187","Afghanistan","407124","791312"));
		sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	@Test 
	void Table05_Input_Rows_Textbox() {
		homePage.inputToTextboxByRowNumber("Contact Person", "3", "Steve Job");
		homePage.inputToTextboxByRowNumber("Company", "2", "FPT");
		homePage.inputToTextboxByRowNumber("Member Since", "1", "19/02/1990");
		homePage.clickToAddOrRemoveButton("Append Row");
		sleepInSecond(3);
		homePage.inputToTextboxByRowNumber("Member Since", "4", "19/02/1990");
		sleepInSecond(3);
		homePage.clickToAddOrRemoveButton("Remove Last Row");
		sleepInSecond(3);
	}

	@Test
	void Table06_With_Action_For_Rows() {
		homePage.clickToActionIcon("1","Insert Row Above");
		homePage.inputToTextboxByRowNumber("Member Since", "1", "19/02/1990");
		homePage.inputToTextboxByRowNumber("Company", "1", "VNPT");
		homePage.clickToActionIcon("3","Move Up");
		sleepInSecond(3);
		homePage.clickToActionIcon("1","Move Down");
		sleepInSecond(3);

	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
