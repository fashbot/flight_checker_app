package yass.stephanie.com.flight_checker.ui.findfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import yass.stephanie.com.flight_checker.R

class RoundTripFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = RoundTripFragment()
    }

    private lateinit var viewModel: RoundTripViewModel
    private lateinit var fromDateSelector: TextView
    private lateinit var toDateSelector: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.round_trip_fragment, container, false)

        fromDateSelector = view.findViewById(R.id.round_trip_from_spinner)
        fromDateSelector.setOnClickListener(this)

        toDateSelector = view.findViewById(R.id.round_trip_to_spinner)
        toDateSelector.setOnClickListener(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RoundTripViewModel::class.java)
        // TODO: Use the ViewModel
    }


    private fun showDatePickerDialog(view: View) {
        val datePicker = DatePickerFragment()
        datePicker.passDateToView(getView()!!, view.id)
        datePicker.show(fragmentManager, "datePicker")
    }

    override fun onClick(v: View) {
        return when (v.id) {
            R.id.round_trip_from_spinner -> showDatePickerDialog(v)
            R.id.round_trip_to_spinner -> showDatePickerDialog(v)
            else -> Toast.makeText(context, "nah mate", Toast.LENGTH_SHORT).show()
        }
    }


}



