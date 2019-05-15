package yass.stephanie.com.flight_checker.ui.findfragment

import android.arch.lifecycle.ViewModel;

class RoundTripViewModel : ViewModel() {

    private var airports: MutableList<String> = mutableListOf()
    private var data = AirportData()

    init{
        populateAirport()
    }


    private fun getAirportList(): MutableList<String>{
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
