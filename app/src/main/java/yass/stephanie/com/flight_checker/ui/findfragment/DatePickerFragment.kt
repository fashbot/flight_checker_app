package yass.stephanie.com.flight_checker.ui.findfragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import yass.stephanie.com.flight_checker.R
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0
    private var calendar = Calendar.getInstance()
    private var mainView: View? = null
    private var capturedViewId: Int? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        var datePicker = DatePickerDialog(activity, this, year, month, day)
        datePicker.datePicker.minDate = calendar.time.time
        return datePicker
    }

    override fun onDateSet(view: DatePicker?, yearSet: Int, monthSet: Int, daySet: Int) {

        val selectedView = mainView!!.findViewById<TextView>(capturedViewId!!)
        selectedView.text = formatDate(yearSet, monthSet, daySet)
        selectedView.setBackgroundResource(R.drawable.ic_selected_spinner_background)
        selectedView.setTextColor(ContextCompat.getColor(context!!, R.color.white))
    }

    fun passDateToView(view: View, viewId: Int) {
        mainView = view
        capturedViewId = viewId
    }

    private fun formatDate(year: Int, inputedMonth: Int, day: Int): String {
        val monthsArray: ArrayList<String> =
            arrayListOf("Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec")
        val formattedMonth = monthsArray[inputedMonth]
        val formattedYear = year.toString().substring(2)
        return "$day $formattedMonth $formattedYear"
    }


}