package io.mobjob.mentorship.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import io.mobjob.mentorship.R
import io.mobjob.mentorship.databinding.FragmentDetailsBinding
import io.mobjob.mentorship.ui.MainActivityViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel : MainActivityViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.changeMainActivityTitle("Details")
        viewModel.hideMainActivityBackButton(true)
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToHomeFragment(Navigation.findNavController(view))
    }

    private fun goToHomeFragment(navController : NavController) {
        binding.gotoHomeFragmentButton.setOnClickListener {
            navController.navigate(R.id.action_detailsFragment_to_homeFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
