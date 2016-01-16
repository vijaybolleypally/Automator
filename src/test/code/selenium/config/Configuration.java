package selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.lib.AccessPropertiesFile;

/**
 * Created by t_bollv on 12/12/15.
 */
public class Configuration {

    private String fileSeparatot = System.getProperty("file.separator");
    private String projectNameDirectory = System.getProperty("user.dir");
    private String configFilePath = projectNameDirectory + "/src/test/resources/SeleniumConfig.properties".replace("/", fileSeparatot);
    private AccessPropertiesFile configFileObj;
    public WebDriver driver;

    public Configuration() throws Exception {
        configFileObj = new AccessPropertiesFile(configFilePath);
    }

    public WebDriver createDriverFromConfig() {
        String requiredDriverValue = configFileObj.getPropValues("browser");

        if (requiredDriverValue.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (requiredDriverValue.equalsIgnoreCase("chrome")) {
            String pathToChromedriver = projectNameDirectory;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                pathToChromedriver =  pathToChromedriver + "/src/test/resources/lib/windows/chromedriver.exe".replace("/", fileSeparatot);
            } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                pathToChromedriver = pathToChromedriver + "/src/test/resources/lib/mac/chromedriver".replace("/", fileSeparatot);
            }
            System.setProperty("webdriver.chrome.driver", pathToChromedriver);
            driver = new ChromeDriver();

        } else {
            System.out.print("check browser value in SeleniumConfig.properties");
        }
        return driver;
    }
}
