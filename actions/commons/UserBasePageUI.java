package commons;

public class UserBasePageUI {
	public static final String SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
	public static final String MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String ORDER_LINK = "//div[@class='footer']//a[text()='Orders']";
	public static String DYNAMIC_LOCATOR_FOOTER = "//div[@class='footer']//a[text()='%s']";	
	public static String DYNAMIC_LOCATOR_ITEM = "//ul[@role='menu']/li[@class='nav-item has-treeview']/a[1]//p[contains(text(),'%s')]";
}
