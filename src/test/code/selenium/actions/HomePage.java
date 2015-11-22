package selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.locators.LeftNavItems;

/**
 * Created by t_bollv on 22/11/15.
 */
public class HomePage {

    WebDriver driver;
    WebDriverWait waitDriver;


    public HomePage(WebDriver driver1){
        this.driver = driver1;
        waitDriver = new WebDriverWait(driver1, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void gotoHome(String url){
        driver.get(url);
    }

    public LeftNavAction goControlToLeftAction(){
        return new LeftNavAction(getDriver());
    }
}
