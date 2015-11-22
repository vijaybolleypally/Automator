package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import selenium.actions.HomePage;
import selenium.actions.LeftNavAction;

/**
 * Created by t_bollv on 22/11/15.
 */
public class TestClass1 {

    HomePage homePage;
    String sUrl= "http://www.cleartrip.com";
    LeftNavAction leftNavAction;

    @Test
    public void myTest1(){
        homePage = new HomePage(new FirefoxDriver());
        homePage.gotoHome(sUrl);
        leftNavAction = homePage.goControlToLeftAction();
        leftNavAction.isHeaderExistByName("Search flights");
        leftNavAction.clickOnGivenHeader("hotelApp","Search for hotels");
//        leftNavAction.clickOnGivenHeader("hotelApp","Search for hotels");
    }

}
