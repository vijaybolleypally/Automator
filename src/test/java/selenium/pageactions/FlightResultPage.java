package selenium.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageelements.FlightResultPageElements;

/**
 * Created by vijayb on 12/31/2014.
 */
public class FlightResultPage implements FlightResultPageElements {

    WebDriver driver;
    WebDriverWait wait;

    public FlightResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void verifyFlightResultPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchsummaryheader));
    }

}
