package geb.modules

import geb.Module

/**
 * Created by vijayb on 12/5/2014.
 */
class LeftNavModule extends Module{

    static content ={
        flightstab{$(".navGroup.productNav li.flightApp")}
        hotelstab{$(".navGroup.productNav li.hotelApp")}
        trainstab{$(".navGroup.productNav li.trainsApp")}
        bussestab{$(".navGroup.productNav li.busApp.hideB2B")}
    }
}
