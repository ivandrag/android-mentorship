package io.mobjob.mentorship.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import io.mobjob.mentorship.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: NewActivityViewModel by activityViewModels()

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<Button>(R.id.goto_details_fragment_button).setOnClickListener {
            viewModel.toggleFragment()
        }
        return view

    }
}
