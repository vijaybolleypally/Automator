package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import selenium.config.Configuration;
import selenium.lib.AccessJsonFile;
import selenium.pageactions.FlightResultPage;
import selenium.pageactions.FlightsPage;
import selenium.pageactions.HotelsPage;


/**
 * Created by vijayb on 12/29/2014.
 */
public class TestClass1 {

    public Configuration config;
    public WebDriver driver;
    public FlightsPage flightsPage;
    public HotelsPage hotelsPage;
    public FlightResultPage flightResultPage;
    public AccessJsonFile accessJsonFile;

    @BeforeClass
    void createConfiguration() throws Exception {
        config = new Configuration();
        driver = config.createDriver();
        accessJsonFile = new AccessJsonFile();
    }

    @BeforeMethod
    void goToBaseUrl(){
        driver.get(accessJsonFile.getString("baseUrl"));
        driver.manage().window().maximize();
    }

    @Test
    void gotoflightTrip() {
        flightsPage = new FlightsPage(driver);
        flightsPage.verifyFlightsPage();
        flightsPage.enterFlightDetails(accessJsonFile.getInnerJson("flightDetails"));
        flightResultPage = flightsPage.clickSearchflights();
        flightResultPage.verifyFlightResultPage();
    }

    @Test
    public void checkNavigation() {
        flightsPage = new FlightsPage(driver);
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
