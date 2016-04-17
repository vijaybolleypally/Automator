package selenium.pageelements;

import org.openqa.selenium.By;

/**
 * Created by t_bollv on 17/04/16.
 */
public interface LeftNavElements {
    By flightstab = By.cssSelector(".navGroup.productNav li.flightApp");
    By hotelstab = By.cssSelector(".navGroup.productNav li.hotelApp");
    By trainstab = By.cssSelector(".navGroup.productNav li.trainsApp");
    By bussestab = By.cssSelector(".navGroup.productNav li.busApp.hideB2B");
}
