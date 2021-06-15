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

	public boolean isSuccessMessagerDisplayed(String value) {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE, value);
		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_MESSAGE, value);
	}

	public boolean isPictureImageUpdated(String imgProduct, String productName) {
		//productName = productName.replace((" "), ("-")).toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_NAME, productName,imgProduct);
		return isElementDisplayed(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_NAME, productName,imgProduct);
	}

}
