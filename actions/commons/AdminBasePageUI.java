package commons;

public class AdminBasePageUI {
	public static final String MENU_LINK_BY_NAME="//ul[@role='menu']/li/a/p[contains(text(),'%s')]";
	public static final String SUB_MENU_LINK_BY_NAME="//ul[@class='nav nav-treeview' and @style]//p[contains(text(),'Products')]";
	public static final String UPLOAD_FILE_BY_CARD_NAME = "//div[@id='product-%s']//input[@type='file']";
	public static final String PRODUCT_IMAGE_UPLOAD_BY_FILE_NAME = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";

}
