package pageObject.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_ACTIVE, pageNumber);
	}

	public void enterValueToHeaderTextbox(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER,headerName);
		
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.ICON_BY_COUNTRY,countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY, countryName, iconAction);
	}

	public boolean isRowsValueDisplayd(String females, String country, String males, String total) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.ROWS_VALUE_FEMALE_COUNTRY_MALE_TOTAL, females,country,males,total);
		System.out.println(getElementText(driver, HomePageUI.ROWS_VALUE_FEMALE_COUNTRY_MALE_TOTAL, females,country,males,total));
		return isElementDisplayed(driver, HomePageUI.ROWS_VALUE_FEMALE_COUNTRY_MALE_TOTAL, females,country,males,total);
	}

	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
		int columnIndex = getElementsSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		waitForElementVisible(driver, HomePageUI.CELL_BY_COLUMN_AND_ROW_INDEX_TEXTBOX, rowIndex, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.CELL_BY_COLUMN_AND_ROW_INDEX_TEXTBOX, value, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToAddOrRemoveButton(String value) {
		waitForElementClickable(driver, HomePageUI.ADD_REMOVE_ROW_BUTTON,value);
		clickToElement(driver, HomePageUI.ADD_REMOVE_ROW_BUTTON, value);
	}

	public void clickToActionIcon(String rowIndex, String coloumnIndex) {
		waitForElementClickable(driver, HomePageUI.ICON_ACTION_BUTTON,rowIndex,coloumnIndex);
		clickToElement(driver, HomePageUI.ICON_ACTION_BUTTON,rowIndex,coloumnIndex);
		
	}


}
