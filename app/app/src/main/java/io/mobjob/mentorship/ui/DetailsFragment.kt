package io.mobjob.mentorship.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import io.mobjob.mentorship.R

class DetailsFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: NewActivityViewModel by activityViewModels()

    companion object {
        fun newInstance(): DetailsFragment {
            return DetailsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        view.findViewById<Button>(R.id.goto_home_fragment_button).setOnClickListener {
            viewModel.toggleFragment()
        }
        return view

    }
}