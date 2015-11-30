package geb.pages

import geb.Page

/**
 * Created by vijayb on 12/5/2014.
 */
class FlightResultPage extends Page {

    static at = {
        modifysearch.eq(1).isDisplayed()
        searchsummaryheader.displayed
    }
    static content ={
        searchsummaryheader{$(".searchSummary")}
        modifysearch{$("a#modifySearchLink")}
    }
}
