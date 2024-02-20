package utils;

public class Constants {
    public static final String CONFIG_FILE_PATH= System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
    public  static final int EXPLICIT_WAIT=20;
    public static final int IMPLICIT_WAIT=10;
    public static final String EXCEL_FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/testdata/batch18excel.xlsx";


    public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir")+"/screenshots/"; //because here will decide name file from common method failed or pass

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
