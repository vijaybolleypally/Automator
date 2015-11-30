package geb.tests

import geb.testng.GebTest
import geb.pages.*
import org.testng.Assert
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

/**
 * Created by vijayb on 12/5/2014.
 */
class TestClass2 extends GebTest {

    //Test Data
    ArrayList flightDetails = ["Hyd","Bangalore","12/12/2015","3","2","1"]

    @Test
    void failedTestScreen()
    {
        waitFor {to FlightsPage}
        enterFlightDetails(flightDetails)
        Assert.assertEquals(1,2)
        waitFor {at FlightResultPage}
    }

    @AfterMethod
    void takeScreen(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE) {
            println("Test "+result.getMethod().methodName+" is Failed")
            report result.getMethod().methodName
        }
    }

}
