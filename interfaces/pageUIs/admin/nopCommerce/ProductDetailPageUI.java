package pageUIs.admin.nopCommerce;

public class ProductDetailPageUI {
	public static final String TOGGLE_ICON_BY_CARD_NAME = "//div[@class='card-title' and contains(string(),'%s')]/following-sibling::div//i";
	//div[@id='product-pictures']//input[@type='file']
	//div[@id='product-downloadable']//div[@id='pnlDownloadFile']//input[@type='file']
	//div[@id='product-downloadable']//div[@id='pnlSampleDownloadFile']//input[@type='file']
	public static final String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_UP_DOWN_ICON = "//input[@id='AddPictureModel_DisplayOrder']/parent::span//span[@title='%s value']";
	public static final String ADD_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String PRODUCT_IMAGE_UPLOAD_BY_PICTURE_ORDER_ALT_TITLE = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String SAVE_CONTINUE_BUTTON = "//button[@name='save-continue']";
	public static final String DELETE_BUTTON_BY_IMAGE_PRODUCT = "//td[text()='%s']/following-sibling::td/a[contains(string(),'Delete')]";
	public static final String MESSAGE_DISPLAYED_BY_TABLE = "//div[@id='specificationattributes-grid_wrapper']//td[text()='%s']";
	
	
	
}
