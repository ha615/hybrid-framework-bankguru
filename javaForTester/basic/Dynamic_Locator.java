package basic;

public class Dynamic_Locator {

	public static void main(String[] args) {
		//UI
		String GENDER_RADIO = "//input[@id='gender-male']";
		String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
		String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
		
		String DYNAMIC_LOCATOR = "//input[@id='%s']";
		String DYNAMIC_LOCATOR_FOOTER = "//div[@class='%s']//input[@id = '%s']";
		String DYNAMIC_LOCATOR_SIDEBAR = "//div[@id='%s']//div[@class='%s']//input[@id = '%s']";
		//PageObject
		clickToElement(GENDER_RADIO);
		clickToElement(FIRST_NAME_TEXTBOX);
		clickToElement(LAST_NAME_TEXTBOX);
		
		clickToElement(DYNAMIC_LOCATOR, "gender-male");
		clickToElement(DYNAMIC_LOCATOR, "FirstName");
		clickToElement(DYNAMIC_LOCATOR, "LastName");
		
		clickToElement(DYNAMIC_LOCATOR_FOOTER, "footer", "LastName");
		clickToElement(DYNAMIC_LOCATOR_SIDEBAR, "side", "bar","number");
	}
	
//	public static void clickToElement(String locator) {
//		System.out.println(locator);
//	}
//	
//	public static void clickToElement(String locator, String pageName) {
//		System.out.println(String.format(locator, pageName));
//	}
//	public static void clickToElement(String locator, String id, String pageName) {
//		System.out.println(String.format(locator,id, pageName));
//	}
//	public static void clickToElement(String locator, String id, String class1, String pageName) {
//		System.out.println(String.format(locator,id, class1, pageName));
//	}
//	
	public static void clickToElement(String locator, String...params) {
		System.out.println(String.format(locator, (Object[])params));
	}

	
	
}
