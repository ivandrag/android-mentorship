package io.mobjob.mentorship.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import io.mobjob.mentorship.R
import io.mobjob.mentorship.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_home) {

    companion object {
        fun newInstance(): DetailsFragment {
            return DetailsFragment()
        }
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController : NavController = Navigation.findNavController(view)
        goToHomeFragment(navController)
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
