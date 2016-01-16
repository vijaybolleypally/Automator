package selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.lib.AccessPropertiesFile;

/**
 * Created by t_bollv on 12/12/15.
 */
public class Configuration {
    String configFilePath = System.getProperty("user.dir")+"/src/test/resources/resources1/configMe.properties".replace("/",System.getProperty("file.separator"));
    public AccessPropertiesFile configFileObj;
    WebDriver driver;

    public Configuration() throws Exception {
        configFileObj = new AccessPropertiesFile(configFilePath);
    }

    public WebDriver createDriverFromConfig() {
        String requiredDriverValue = configFileObj.getPropValues("browser");
        if (requiredDriverValue.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.print("NO Such Drive Defined");
        }
        return driver;
    }
}
