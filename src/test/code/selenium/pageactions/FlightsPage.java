package selenium.pageactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageelements.LeftNavItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijayb on 12/29/2014.
 */
public class FlightsPage {

    WebDriver driver;
    WebDriverWait wait;

    public FlightsPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebDriver getDriver() {
        return driver;
    }

    LeftNavItems leftNavItems = new LeftNavItems();

    public String sURL= "http://www.cleartrip.com";
    public String flightsHeader = ".//h1[contains(text(),'Search flights')]";
    public String searchflightsbtn = "#SearchBtn";
    public String tagwithid = "#%s";

    public void goToGivenURL()
    {
        driver.get(sURL);
        driver.manage().window().maximize();
    }

    public void verifyFlightsPage()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(flightsHeader)));

    }

    public HotelsPage navigateToHotelsPage()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(leftNavItems.hotelstab)));
        driver.findElement(By.cssSelector(leftNavItems.hotelstab)).click();
        return new HotelsPage(getDriver());
    }

    public void enterFlightDetails(String[] flightDetailsList)
    {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(String.format(tagwithid,"FromTag"))));
        driver.findElement(By.cssSelector(String.format(tagwithid,"FromTag"))).sendKeys(flightDetailsList[0]);
        driver.findElement(By.cssSelector(String.format(tagwithid,"ToTag"))).sendKeys(flightDetailsList[1]);
        driver.findElement(By.cssSelector(String.format(tagwithid,"DepartDate"))).sendKeys(flightDetailsList[2]);
        driver.findElement(By.cssSelector(String.format(tagwithid,"Adults"))).sendKeys(flightDetailsList[3]);
        driver.findElement(By.cssSelector(String.format(tagwithid,"Childrens"))).sendKeys(flightDetailsList[4]);
        driver.findElement(By.cssSelector(String.format(tagwithid,"Infants"))).sendKeys(flightDetailsList[5]);
    }

    public FlightResultPage clickSearchflights()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(searchflightsbtn)));
        driver.findElement(By.cssSelector(searchflightsbtn)).click();
        return new FlightResultPage(getDriver());
    }
}
