package geb.pages

import geb.Page
import geb.modules.LeftNavModule

/**
 * Created by Welcome on 12/7/2014.
 */
class HotelsPage extends Page{

    static at ={
        hotelsHeader.displayed
        driver.currentUrl.endsWith("/hotels")
    }

    static content ={
        leftNavModule {module LeftNavModule}
        hotelsHeader{$('h1',text: contains("Search for hotels"))}
    }
}
