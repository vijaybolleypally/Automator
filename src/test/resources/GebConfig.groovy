import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities

/**
 * Created by vijayb on 12/5/2014.
 */
//driver = "firefox"

driver = {
    def firefox = new FirefoxDriver()
    firefox.manage().window().maximize()
    return firefox
}


environments {

    firefox {
        driver = {
            def firefox = new FirefoxDriver()
            firefox.manage().window().maximize()
            return firefox
        }
    }

    chrome {
        driver = {
            System.setProperty("webdriver.chrome.driver","E:/MyIDEAPROJ/sample-code-master/sample-code/examples/java/GebAdvanced/src/lab/chromedriver.exe")

            /*You are using an unsupported command-line flag:
            ignore-certificate-errors.*/
            DesiredCapabilities capabilities = DesiredCapabilities.chrome()
            ChromeOptions options = new ChromeOptions()
            options.addArguments("test-type", "start-maximized", "disable-extensions")
            capabilities.setCapability(ChromeOptions.CAPABILITY, options)
            capabilities.setCapability("chrome.binary","E:/MyIDEAPROJ/sample-code-master/sample-code/examples/java/GebAdvanced/src/lab/chromedriver.exe")
            def chrome = new ChromeDriver(capabilities)
            return chrome
        }
    }

    ie {
        driver = { new InternetExplorerDriver() }
    }
}

//baseUrl = "http://www.cleartrip.com"



waiting {
    timeout = 10
    retryInterval = 1
    presets {
        longwait {
            timeout = 90
        }
        shortwait {
            timeout = 45
        }
        quick {
            timeout = 30
            retryInterval = 0.1
        }
        shortwaitWithRetry {
            timeout = 45
            retryInterval = 0.5
        }
    }
}







reportsDir = (new File(".").getCanonicalPath() + "/geb-reports/screenshots/").replace('/', File.separator)


