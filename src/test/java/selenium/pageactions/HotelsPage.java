package selenium.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageelements.HotelsPageElements;
import selenium.pageelements.LeftNavElements;

/**
 * Created by vijayb on 12/31/2014.
 */
public class HotelsPage implements HotelsPageElements, LeftNavElements {


    WebDriver driver;
    WebDriverWait wait;

    public HotelsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void verifyHotelsPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(hotelsHeader));
    }

    public FlightsPage navigateToFlightsPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(flightstab));
        driver.findElement(flightstab).click();
        return new FlightsPage(getDriver());
    }

}
