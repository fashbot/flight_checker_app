package yass.stephanie.com.flight_checker.ui.findfragment

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import yass.stephanie.com.flight_checker.R

class RoundTripFragment : Fragment() {

    companion object {
        fun newInstance() = RoundTripFragment()
    }

    private lateinit var viewModel: RoundTripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.round_trip_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RoundTripViewModel::class.java)
        // TODO: Use the ViewModel
    }


}
