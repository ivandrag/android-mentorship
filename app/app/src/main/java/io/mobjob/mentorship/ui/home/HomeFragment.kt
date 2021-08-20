package io.mobjob.mentorship.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import io.mobjob.mentorship.R
import io.mobjob.mentorship.databinding.FragmentHomeBinding
import io.mobjob.mentorship.ui.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>("Home", true, false) {
    override fun goToFragment(navController : NavController) {
        binding.gotoDetailsFragmentButton.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_detailsFragment)
        }
    }

    override fun bindingInit(
        inflate: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): ConstraintLayout? {
        this._binding =  FragmentHomeBinding.inflate(inflate, container, false)
        return binding.root
    }
}
