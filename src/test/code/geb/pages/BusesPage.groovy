package geb.pages

import geb.Page
import geb.modules.LeftNavModule

/**
 * Created by Welcome on 12/7/2014.
 */
class BusesPage extends Page{

    static at = {
        busesHeader.displayed
        driver.currentUrl.endsWith("/buses")
    }

    static content ={
        busesHeader{$('h1',text: contains("Search buses"))}
        leftNavModule {module LeftNavModule}
    }
}
