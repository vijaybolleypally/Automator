package geb.pages

import geb.Page
import geb.modules.LeftNavModule

/**
 * Created by Welcome on 12/7/2014.
 */
class TrainsPage extends Page{

    static at ={
        trainsHeader.displayed
        driver.currentUrl.endsWith("/trains")
    }

    static content ={
        leftNavModule {module LeftNavModule}
        trainsHeader{$('h1',text: contains("Search trains"))}
    }
}
