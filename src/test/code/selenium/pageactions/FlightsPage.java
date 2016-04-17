package selenium.pageactions;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageelements.FlightsPageElements;
import selenium.pageelements.LeftNavElements;

/**
 * Created by vijayb on 12/29/2014.
 */
public class FlightsPage implements FlightsPageElements, LeftNavElements {

    WebDriver driver;
    WebDriverWait wait;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void verifyFlightsPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(flightsHeader));

    }

    public HotelsPage navigateToHotelsPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(hotelstab));
        driver.findElement(hotelstab).click();
        return new HotelsPage(getDriver());
    }

    public void enterFlightDetails(JSONObject flightDetailsList) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(String.format(tagwithid, "FromTag"))));
        driver.findElement(By.cssSelector(String.format(tagwithid, "FromTag"))).sendKeys(flightDetailsList.get("from").toString());
        driver.findElement(By.cssSelector(String.format(tagwithid, "ToTag"))).sendKeys(flightDetailsList.get("to").toString());
        driver.findElement(By.cssSelector(String.format(tagwithid, "DepartDate"))).sendKeys(flightDetailsList.get("doj").toString());
        driver.findElement(By.cssSelector(String.format(tagwithid, "Adults"))).sendKeys(flightDetailsList.get("adults").toString());
        driver.findElement(By.cssSelector(String.format(tagwithid, "Childrens"))).sendKeys(flightDetailsList.get("childrens").toString());
        driver.findElement(By.cssSelector(String.format(tagwithid, "Infants"))).sendKeys(flightDetailsList.get("infants").toString());
    }

    public FlightResultPage clickSearchflights() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchflightsbtn));
        driver.findElement(searchflightsbtn).click();
        return new FlightResultPage(getDriver());
    }
}
