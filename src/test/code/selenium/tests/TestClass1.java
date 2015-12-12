package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import selenium.config.Configuration;
import selenium.pageactions.FlightResultPage;
import selenium.pageactions.FlightsPage;
import selenium.pageactions.HotelsPage;


/**
 * Created by vijayb on 12/29/2014.
 */
public class TestClass1 {

    Configuration config;
    WebDriver driver;
    FlightsPage flightsPage;
    HotelsPage hotelsPage;
    FlightResultPage flightResultPage;
    String[] flightDetails = {"Hyd", "Bangalore", "12/12/2015", "3", "2", "1"};

    @BeforeClass
    void createConfiguration() throws Exception {
        config = new Configuration();
        driver = config.createDriverFromConfig();
    }

    @Test
    void gotoflightTrip() {
        driver.get("http://www.cleartrip.com/");
        flightsPage = new FlightsPage(driver);
        flightsPage.goToGivenURL();
        flightsPage.verifyFlightsPage();
        flightsPage.enterFlightDetails(flightDetails);
        flightResultPage = flightsPage.clickSearchflights();
        flightResultPage.verifyFlightResultPage();
    }

    @Test
    public void checkNavigation() {
        flightsPage = new FlightsPage(driver);
        flightsPage.goToGivenURL();
        flightsPage.verifyFlightsPage();
        hotelsPage = flightsPage.navigateToHotelsPage();
        hotelsPage.verifyHotelsPage();
        flightsPage = hotelsPage.navigateToFlightsPage();
        flightsPage.verifyFlightsPage();
    }

    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void closeAll() {
        driver.quit();
    }
}
