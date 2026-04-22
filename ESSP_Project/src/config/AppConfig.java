package config;

public class AppConfig {

    private AppConfig() {}

    public static final String APP_TITLE =
            "Employee Self Service Portal";

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 400;

    public static final String VERSION = "1.0";

    public static final String COMPANY =
            "Your Organization";

    public static final String DOCUMENT_PATH =
            System.getProperty("user.dir") + "/uploads/";
}