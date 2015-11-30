package selenium.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageelements.LeftNavItems;

/**
 * Created by vijayb on 12/31/2014.
 */
public class FlightResultPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightResultPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String searchsummaryheader = ".searchSummary";

    public void verifyFlightResultPage()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(searchsummaryheader)));
    }

}
