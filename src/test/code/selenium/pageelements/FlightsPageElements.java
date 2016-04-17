package selenium.pageelements;

import org.openqa.selenium.By;

/**
 * Created by t_bollv on 17/04/16.
 */
public interface FlightsPageElements {

    By flightsHeader = By.xpath(".//h1[contains(text(),'Search flights')]");
    By searchflightsbtn = By.cssSelector("#SearchBtn");
    String tagwithid = "#%s";

}
