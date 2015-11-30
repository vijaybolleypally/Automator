package geb.pages

import geb.Page
import geb.modules.LeftNavModule

/**
 * Created by vijayb on 11/30/2014.
 */
class FlightsPage extends Page {

    static url = "http://www.cleartrip.com/"

    static at ={
        flightsHeader.displayed
        searchflightsbtn.displayed
    }

    static content ={
        flightsHeader{$('h1',text: contains("Search flights"))}
        searchflightsbtn{$("#SearchBtn")}
        tagwithid{id->$("#"+id)}
        leftNavModule {module LeftNavModule}
    }

    def enterFlightDetails(List<ArrayList> flightDetailsList)
    {
        waitFor {tagwithid("FromTag").displayed}
        tagwithid("FromTag") << flightDetailsList.get(0)
        tagwithid("ToTag") << flightDetailsList.get(1)
        tagwithid("DepartDate") << flightDetailsList.get(2)
        tagwithid("Adults") << flightDetailsList.get(3)
        tagwithid("Childrens") << flightDetailsList.get(4)
        tagwithid("Infants") << flightDetailsList.get(5)
    }

    def clickSearchflights()
    {
        waitFor {tagwithid("SearchBtn").displayed}
        tagwithid("SearchBtn").click()
    }
}
