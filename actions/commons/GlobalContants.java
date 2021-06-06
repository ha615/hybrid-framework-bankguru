package commons;

import java.io.File;

public class GlobalContants {
	public static final long SHORT_TIME = 5;
	public static final long LONG_TIME = 30;
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWLOAD_FOLDER_PATH =  PROJECT_PATH + File.separator + "dowloadFiles";
		
	public static final String DEV_APP_URL = "https://demo.nopcommerce.com";
	public static final String STAGING_APP_URL = "https://staging.nopcommerce.com";
	public static final String TESTING_APP_URL = "https://testing.nopcommerce.com";
	
	public static final String DEV_DB_URL = "";
	public static final String DEV_DB_USER = "";
	public static final String DEV_DB_PASS = "";

	public static final String STAGING_DB_URL = "";
	public static final String STAGING_DB_USER = "";
	public static final String STAGING_DB_PASS = "";
}
