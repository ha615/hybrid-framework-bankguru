package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;

public class ProductSearchPageObject extends BasePage {

	WebDriver driver;
	ProductSearchPageObject productSearchPage;
	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterProductNameTextbox(String value) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_SEARCH_BY_NAME_TEXTBOX);
		sendKeyToElement(driver, ProductSearchPageUI.PRODUCT_SEARCH_BY_NAME_TEXTBOX, value);
		
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
	}

	public ProductDetailPageObject clickToEditButtonByName(String value) {
		waitForElementClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, value);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, value);		
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isSuccessMessagerDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPictureImageUpdated(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

}
