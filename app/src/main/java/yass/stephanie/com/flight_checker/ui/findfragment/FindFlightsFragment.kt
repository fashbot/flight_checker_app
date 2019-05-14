package yass.stephanie.com.flight_checker.ui.findfragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yass.stephanie.com.flight_checker.R

class FindFlightsFragment : Fragment() {

    private lateinit var viewModel: FindFlightsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.book_flights_fragment, container, false)
        val viewPager: ViewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = BookFlightsTabAdapter(fragmentManager, this.requireActivity())
        val tabLayout: TabLayout = view.findViewById(R.id.book_flights_tab_layout)
        tabLayout.setupWithViewPager(viewPager)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindFlightsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
