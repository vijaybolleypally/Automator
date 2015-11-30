package geb.tests

import geb.testng.GebTest
import geb.pages.*
import org.testng.annotations.Test

/**
 * Created by vijayb on 12/5/2014.
 */
class TestClass1 extends GebTest {

    //Test Data
    ArrayList flightDetails = ["Hyd","Bangalore","12/12/2015","3","2","1"]

    @Test
    void gotoflightTrip()
    {
        waitFor {to FlightsPage}
        enterFlightDetails(flightDetails)
        clickSearchflights()
        waitFor {at FlightResultPage}
    }

    @Test
    void checkNavigation()
    {
        waitFor {to FlightsPage}
        waitFor {leftNavModule.hotelstab.displayed}
        leftNavModule.hotelstab.click()

        waitFor {at HotelsPage}
        waitFor {leftNavModule.trainstab.displayed}
        leftNavModule.trainstab.click()

        waitFor {at TrainsPage}
        waitFor {leftNavModule.bussestab.displayed}
        leftNavModule.bussestab.click()

        waitFor {at BusesPage}
        waitFor {leftNavModule.flightstab.displayed}
        leftNavModule.flightstab.click()
        waitFor {at FlightsPage}
    }

}
