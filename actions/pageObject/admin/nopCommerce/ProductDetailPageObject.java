package pageObject.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AdminBasePageUI;
import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {

	WebDriver driver;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
		// get tag i attribute
		String attributeName = getElementAttribute(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, "class", panelName); 
		
		if(attributeName.contains("fa-plus")){
			waitForElementClickable(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME,panelName);
		}
	}

	public boolean isPictureUploadSucessByFileName(String imgUploadName) {
		imgUploadName = imgUploadName.split("\\.")[0];
		waitForElementVisible(driver, AdminBasePageUI.PRODUCT_IMAGE_UPLOAD_BY_FILE_NAME, imgUploadName);
		return isElementDisplayed(driver, AdminBasePageUI.PRODUCT_IMAGE_UPLOAD_BY_FILE_NAME, imgUploadName);
	}

	public void enterToAltTextbox(String value) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX, value);
	}

	public void enterToTitleTextbox(String value) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX);
		sendKeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX, value);		
	}

	public void clickToDisplayedOrderTextbox(String upDownText) {
		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_UP_DOWN_ICON, upDownText);
		clickToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_UP_DOWN_ICON, upDownText);			
	}

	public void clickToAdProductPictureButton() {
		waitForElementClickable(driver, ProductDetailPageUI.ADD_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_PICTURE_BUTTON);

	}

	public boolean isPictureImageDisplayed(String pictureName, String oderDisplay, String alt, String title) {
		pictureName = pictureName.replace((" "), ("-")).toLowerCase();
		System.out.println(pictureName + "\n" + oderDisplay+ "\n" + alt + "\n" + title);
		waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_IMAGE_UPLOAD_BY_PICTURE_ORDER_ALT_TITLE,pictureName,oderDisplay,alt,title);
		return isElementDisplayed(driver, ProductDetailPageUI.PRODUCT_IMAGE_UPLOAD_BY_PICTURE_ORDER_ALT_TITLE, pictureName, oderDisplay, alt, title);
	}

	public ProductSearchPageObject clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteButtonAtPictureName(String titleProduct) {
		//imgProductText = imgProductText.replace((" "), ("-")).toLowerCase();
		waitForElementVisible(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_PRODUCT, titleProduct);
		clickToElement(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_PRODUCT, titleProduct);
		acceptAlert(driver);
	}

	public boolean isSuccessMessagerDisplayedByTable(String messageTable) {
		waitForElementVisible(driver, ProductDetailPageUI.MESSAGE_DISPLAYED_BY_TABLE, messageTable);
		return isElementDisplayed(driver, ProductDetailPageUI.MESSAGE_DISPLAYED_BY_TABLE, messageTable);
	}

}
