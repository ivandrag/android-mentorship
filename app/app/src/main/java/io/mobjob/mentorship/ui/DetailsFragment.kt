package io.mobjob.mentorship.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.mobjob.mentorship.R

class DetailsFragment : Fragment(R.layout.fragment_home) {

    companion object {
        fun newInstance(): DetailsFragment {
            return DetailsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToHomeFragment()
    }

    private fun goToHomeFragment() {
        view?.findViewById<Button>(R.id.goto_home_fragment_button)?.setOnClickListener {
            (activity as NewActivity).showHomeFragment()
        }
    }
}
