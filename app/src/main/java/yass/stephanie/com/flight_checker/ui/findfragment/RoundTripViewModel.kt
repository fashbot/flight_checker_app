package yass.stephanie.com.flight_checker.ui.findfragment

import android.arch.lifecycle.ViewModel;
import java.util.ArrayList

class RoundTripViewModel : ViewModel() {

    private var airports: ArrayList<String> = ArrayList()
    private var data = AirportData()


    init{
        populateAirport()
    }


    fun getAirportList(): MutableList<String>{
        return airports
    }


    private fun populateAirport() {
        val dataList = listOf<String>(
            data.AMS,
            data.CGD,
            data.DEL,
            data.DEN,
            data.DXB,
            data.FRA,
            data.HKA,
            data.HND,
            data.ICN,
            data.IST,
            data.LAX,
            data.LHR,
            data.ORD,
            data.PEK,
            data.PVG
        )
        airports.addAll(dataList)
    }


}
