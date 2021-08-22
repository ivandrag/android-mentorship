package io.mobjob.mentorship.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import io.mobjob.mentorship.databinding.FragmentDetailsBinding
import io.mobjob.mentorship.ui.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding>("Details", true, true) {

    override fun goToFragment(navController : NavController) {
        binding.gotoHomeFragmentButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun bindingInit(
        inflate: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): ConstraintLayout? {
        this._binding =  FragmentDetailsBinding.inflate(inflate, container, false)
        return binding.root
    }
}
