package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HRM.AddEmployeePageObject;
import pageObjects.HRM.DashboardPageObject;
import pageObjects.HRM.EmployeeListPageObject;
import pageObjects.HRM.LoginPageObject;
import pageObjects.HRM.PageGenerator;
import pageObjects.HRM.PersonalDetailPageObject;


public class Level16_Live_Coding extends BaseTest {
	String employeeID, statusValue ;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		log.info("Pre-Condition Step 01: Open browser: '" + browserName + "' and navigate to: '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGenerator.getLoginPage(driver);
		log.info("Pre-Condition Step 02: Login with admin role");
		dashboardPage = loginPage.loginToSystem("Admin","admin123");
		statusValue = "Enabled";
	}	
	
	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open Employee List Page");
		employeeListPage = dashboardPage.openEmployeeListPage();
		
		log.info("Add_New_01 - Step 02: Click To 'Add' button");
		addEmployeePage = employeeListPage.clickToAddButton();
		
		log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterToFirstNameTextbox("zin");
		
		log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterToLastNameTextbox("zin");
		
		log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getEmployeeID();
		
		log.info("Add_New_01 - Step 06: Click To 'Create Login Detail' checkbox");
		addEmployeePage.clickToCreateLoginDetailCheckbox();
		
		log.info("Add_New_01 - Step 07: Enter valid info 'User Name' textbox");
		addEmployeePage.enterToUserNameTextbox("zinzin");
		
		log.info("Add_New_01 - Step 08: Enter valid info 'Password' textbox");
		addEmployeePage.enterToPasswordTextbox("zinzin123");
		
		log.info("Add_New_01 - Step 09: Enter valid info 'Confirm Password' textbox");
		addEmployeePage.enterToConfirmPasswordTextbox("zinzin123");
		
		log.info("Add_New_01 - Step 10: Select 'Enabled' value in 'Status' dropdown");
		addEmployeePage.selectValueInStatusDropdwn(statusValue);
		
		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		personalDeatailPage = addEmployeePage.clickToSaveButton();
		
		log.info("Add_New_01 - Step 12: Open Employee List Page");
		employeeListPage = personalDeatailPage.openEmployeeListPage();
		
		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		employeeListPage.enterToEmployeeNameTextbox("zinzin");
		
		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToSearchButton();
		
		log.info("Add_New_01 - Step 15: Verify Employee Information displayed at 'Result Table'");
		verifyTrue(employeeListPage.isEmployeeInformationDisplayedAtTable(employeeID));
	}

	@Test
	public void Employee_02_Upload_Avatar() {
		
	}

	@Test
	public void Employee_03_Personal_Detail() {
		
	}
	
	@Test
	public void Employee_04_Contact_Detail() {
		
	}

	@Test
	public void Employee_05_Emergency_Detail() {
		
	}

	@Test
	public void Employee_06_Assigned_Deparment() {
		
	}

	@Test
	public void Employee_07_Edit_View_Job() {
		
	}

	@Test
	public void Employee_08_Edit_View_Salary() {
		
	}

	@Test
	public void Employee_09_Edit_View_Tax() {
		
	}

	@Test
	public void Employee_10_Qualification() {
		
	}

	@Test
	public void Employee_11_Search_Employee() {
		
	}

	@Test

	@AfterClass
	public void quitBrowser() {
		log.info("Post Condition: Close browser");
		driver.quit();
	}
	
	WebDriver driver;
	LoginPageObject loginPage;
	AddEmployeePageObject addEmployeePage;
	DashboardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	PersonalDetailPageObject personalDeatailPage;
}
