package hooks;

import base.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.BaseProperties;

import java.io.File;
import java.util.HashMap;

public class Hooks extends Base {

    private BaseProperties baseProperties = new BaseProperties();

    public static void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    @Before
    public void setup() {
        baseProperties.createDownloadDirURL();
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
        if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", BaseProperties.driverDirLinux );
            BaseProperties.createDownloadDir();
            chromePrefs.put("download.default_directory", baseProperties.createDownloadDirURL());
            deleteAllFilesFolder(baseProperties.createDownloadDirURL());

        } else {
            System.setProperty("webdriver.chrome.driver", BaseProperties.driverDir);
            BaseProperties.createDownloadDir();
            chromePrefs.put("download.default_directory", baseProperties.createDownloadDirURL());
            deleteAllFilesFolder(baseProperties.createDownloadDirURL());
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
