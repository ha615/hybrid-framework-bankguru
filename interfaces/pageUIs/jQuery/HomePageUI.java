package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_ACTIVE = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String ICON_BY_COUNTRY = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	public static final String ROWS_VALUE_FEMALE_COUNTRY_MALE_TOTAL = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String HEADER_NAME_INDEX = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_BY_COLUMN_AND_ROW_INDEX_TEXTBOX = "//tr[%s]/td[%s]/input";
	public static final String ADD_REMOVE_ROW_BUTTON = "//button[@title='%s']";
	public static final String ICON_ACTION_BUTTON = "//tr[@id][%s]//button[@title='%s']";
}
