package selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.lib.AccessPropertiesFile;

/**
 * Created by t_bollv on 12/12/15.
 */
public class Configuration {
    //String configFilePath = "/Users/t_bollv/Documents/code-v/Automator/src/test/resources/resources1/configMe.properties";
//String configFilePath = "../src/test/resources/resources1/configMe.properties";
    String configFilePath = "D:\\codev\\Automator\\src\\test\\resources\\resources1\\configMe.properties";
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
