package selenium.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageelements.LeftNavItems;

/**
 * Created by vijayb on 12/31/2014.
 */
public class HotelsPage {

    public String hotelsHeader = ".//h1[contains(text(),'Search for hotels')]";

    WebDriver driver;
    WebDriverWait wait;

    public HotelsPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }

    LeftNavItems leftNavItems = new LeftNavItems();

    public void verifyHotelsPage()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(hotelsHeader)));
    }

    public FlightsPage navigateToFlightsPage()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(leftNavItems.flightstab)));
        driver.findElement(By.cssSelector(leftNavItems.flightstab)).click();
        return new FlightsPage(getDriver());
    }

}
