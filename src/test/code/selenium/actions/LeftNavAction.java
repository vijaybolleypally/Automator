package selenium.actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.locators.LeftNavItems;

/**
 * Created by t_bollv on 22/11/15.
 */
public class LeftNavAction {


    LeftNavItems leftNavItems=new LeftNavItems();

    WebDriver driver;
    WebDriverWait waitDriver;


    public LeftNavAction(WebDriver driver1){
        this.driver = driver1;
        waitDriver = new WebDriverWait(driver, 20);
    };

    public void isHeaderExistByName(String headerName){
        waitDriver.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(String.format(leftNavItems.pageHeaderName,headerName))));
    };

    public void clickOnGivenHeader(String header,String resultHead){
        String eleCss = String.format(leftNavItems.givenTab,header);
        waitDriver.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(eleCss)));
        driver.findElement(By.cssSelector(eleCss)).click();
        isHeaderExistByName(resultHead);
    };


}
