package properties;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;

public class BaseProperties {
    static String baseDir = System.getProperty("user.dir");
    public static String driverDir = baseDir + "/src/drivers/chromedriver.exe";
    public static String driverDirLinux = baseDir + "/src/drivers/chromedriver";
//    public static String pictureDir = baseDir + "/src/test/java/pics/344.jpg";

    public static String createDownloadDirURL() {
        String downLoadsDir;
        if (SystemUtils.IS_OS_LINUX) {
            return downLoadsDir = baseDir + "/src/test/java/downloads/";
        } else {
            return downLoadsDir = baseDir + "\\src\\test\\java\\downloads";
        }
    }

    public static void createDownloadDir() {
        new File(createDownloadDirURL()).mkdir();
    }
}
