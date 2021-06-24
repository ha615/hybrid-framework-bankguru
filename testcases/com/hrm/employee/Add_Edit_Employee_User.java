package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HRM.DashboardPageObject;
import pageObjects.HRM.EmployeeDetailPageOject;
import pageObjects.HRM.EmployeeListPageObject;
import pageObjects.HRM.LoginPageObject;
import pageObjects.HRM.PageGeneratorManager;


public class Add_Edit_Employee_User extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageOject employeeDetailPage;
	EmployeeListPageObject employeeListPage;
	
	String fullName, firstName, lastName, employeeID, national, licenseExpire;
	@Parameters({"browser","url"})
	@BeforeClass
	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition Step 01: Open browser: '" + browserName + "' and navigate to: '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		// open URL switch to login page
		loginPage = PageGeneratorManager.getLoginPage(driver);
		log.info("Pre-Condition Step 02: Enter to Username textbox");
		loginPage.enterToUsernameTextbox("Admin");
		log.info("Pre-Condition Step 03: Enter to Password textbox");
		loginPage.enterToPasswordTextbox("admin123");
		log.info("Pre-Condition Step 04: Click To Login button");
		dashboardPage = loginPage.clickToLoginButton();
		firstName = getRandomEmail();
		log.info("Pre-Condition Step 05: Set First Name " + firstName);
		lastName = "Ferguson";
		log.info("Pre-Condition Step 06: Set Last Name " + lastName);
		fullName = firstName + " " + lastName;
		//after login switch to dashboard page
	}
	
	@Test
	public void Emp_01_Add_Employee() {
		log.info("Emp_01 Step 01: Click to PIM Menu");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		log.info("Emp_01 Step 02: Click to Add button");
		employeeDetailPage = employeeListPage.clickToAddButton();	
		log.info("Emp_01 Step 03: Enter Fist Name textbox");
		employeeDetailPage.enterFistNameTextbox(firstName);
		log.info("Emp_01 Step 04: Enter Last Name textbox");
		employeeDetailPage.enterLastNameTextbox(lastName);
		employeeID = employeeDetailPage.getEmployeeIDInfoAtAdEmployeeForm();
		log.info("Emp_01 Step 05: Input Photograph file");
		employeeDetailPage.inputPhotographFile();
		log.info("Emp_01 Step 06: Click to Save button");
		employeeDetailPage.clickToSaveButton();
		log.info("Emp_01 Step 07: Verify with Full name " + fullName + " displayed at personal detail form");
		verifyTrue(employeeDetailPage.isFullNameDisplayedAtHeader(firstName +" "+ lastName));
		log.info("Emp_01 Step 08: Verify with First name " + firstName + " displayed at personal detail form");
		verifyEquals(employeeDetailPage.getFistNameValueAtPersonalDetailForm(), firstName);
		log.info("Emp_01 Step 09: Verify with Last name " + lastName + " displayed at personal detail form");
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), lastName);
		log.info("Emp_01 Step 10: Verify with Employee ID " + employeeID + " displayed at personal detail form");
		verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);
	}
	
	@Test
	public void Emp_02_Edit_Employee_By_Personal() {
		log.info("Emp_02 Step 01: Click to Edit button");
		employeeDetailPage.clickToFunctionButton("Personal Details","Edit");
		log.info("Emp_02 Step 02: Enter license expiry date textbox");
		employeeDetailPage.enterLicenseExpireDateTextbox("2020-02-01");
		log.info("Emp_02 Step 03: Choose Nationality on combobox");
		employeeDetailPage.chooseNationalityOnCombobox("American");
		log.info("Emp_02 Step 04: Click To Save Button");
		employeeDetailPage.clickToFunctionButton("Personal Details","Save");
		licenseExpire = employeeDetailPage.getLisenceExpireDateAtPersonalDetailForm();
		national = employeeDetailPage.getNationalAtPersonalDetailForm();
		log.info("Emp_02 Step 05: Verify with License Expire Date " + licenseExpire + " at personal detail");
		verifyTrue(employeeDetailPage.isLicenseExpireDateDisplayedAtPersonalDetailForm(licenseExpire));
		log.info("Emp_02 Step 05: Verify with National " + national + " at personal detail");
		verifyTrue(employeeDetailPage.isNationalDisplayedAtPersonalDetail(national));
		sleepInSecond(5);
	}
	@Test
	public void Emp_03_Edit_Employee_By_Contact() {
		
	}	
	@Test
	public void Emp_04_Edit_Employee_By_Job() {
		
	}
	@Test
	public void Emp_05_Edit_Employee_By_Salary() {
		
	}
	@Test
	public void Emp_06_Search_Employee_By_Name() {

	}
	@Test
	public void Emp_07_Add_User_To_Employee() {
		
	}
	@Test
	public void Emp_08_Search_User() {
		
	}

	@AfterClass
	public void quitBrowser() {
		log.info("Post Condition: Close browser");
		driver.quit();
	}
}
