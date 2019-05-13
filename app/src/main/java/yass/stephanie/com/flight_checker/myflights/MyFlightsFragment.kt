package yass.stephanie.com.flight_checker.myflights

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yass.stephanie.com.flight_checker.R


class MyFlightsFragment : Fragment() {

    companion object {
        fun newInstance() = MyFlightsFragment()
    }

    private lateinit var viewModel: MyFlightsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_flights_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyFlightsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
