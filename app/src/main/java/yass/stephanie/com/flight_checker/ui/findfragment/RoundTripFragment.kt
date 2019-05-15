package yass.stephanie.com.flight_checker.ui.findfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import yass.stephanie.com.flight_checker.R

class RoundTripFragment : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    companion object {
        fun newInstance() = RoundTripFragment()
    }

    private lateinit var viewModel: RoundTripViewModel
    private lateinit var fromDateSelector: TextView
    private lateinit var toDateSelector: TextView
    private lateinit var fromAirportDropDown: Spinner
    private lateinit var toAirportDropDown: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.round_trip_fragment, container, false)

        fromDateSelector = view.findViewById(R.id.round_trip_from_spinner)
        fromDateSelector.setOnClickListener(this)

        toDateSelector = view.findViewById(R.id.round_trip_to_spinner)
        toDateSelector.setOnClickListener(this)

        fromAirportDropDown = view.findViewById(R.id.round_trip_from_dropdown)
        fromAirportDropDown.onItemSelectedListener = this

        toAirportDropDown = view.findViewById(R.id.round_trip_to_dropdown)
        toAirportDropDown.onItemSelectedListener = this

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RoundTripViewModel::class.java)
        showAirportDropDown(fromAirportDropDown)
        showAirportDropDown(toAirportDropDown)
    }

    private fun showDatePickerDialog(view: View) {
        val datePicker = DatePickerFragment()
        datePicker.passDateToView(getView()!!, view.id)
        datePicker.show(fragmentManager, "datePicker")
    }

    private fun showAirportDropDown(spinner: Spinner) {
        val dataAdapter =
            ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, viewModel.getAirportList())
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = dataAdapter

    }

    override fun onClick(v: View) {
        return when (v.id) {
            R.id.round_trip_from_spinner -> showDatePickerDialog(v)
            R.id.round_trip_to_spinner -> showDatePickerDialog(v)
            else -> {
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) = Toast.makeText(
        parent?.context,
        "OnItemSelectedListener : " + parent?.getItemAtPosition(position).toString(),
        Toast.LENGTH_SHORT
    ).show()
}







