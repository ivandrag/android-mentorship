package io.mobjob.mentorship.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import io.mobjob.mentorship.R
import io.mobjob.mentorship.databinding.FragmentHomeBinding
import io.mobjob.mentorship.ui.MainActivityViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainActivityViewModel by activityViewModels()
    private val args : HomeFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("[SPCL_TAG] : " + "onCreateView")
        viewModel.changeMainActivityTitle("Home")
        viewModel.hideMainActivityBackButton(false)
        viewModel.setToolBarVisible(true);
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToFragmentDetails(Navigation.findNavController(view))
        println("[SPCL_TAG] : " + "onViewCreated")

        Log.i("[SPCL_TAG] : ", "onViewCreated: Sent arguments : ")
        Log.i("------------", "------------------------------------")
        Log.i("[SPCL_TAG] : ", "fullName : " + args.fullName)
        Log.i("[SPCL_TAG] : ", "email : " + args.email)
        Log.i("[SPCL_TAG] : ", "email : " + args.fullAddress)
        Log.i("[SPCL_TAG] : ", "email : " + args.userName)
        Log.i("____________", "____________________________________")
    }
    private fun goToFragmentDetails(navController : NavController) {
        binding.gotoDetailsFragmentButton.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_detailsFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("[SPCL_TAG] : " + "onCreate")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        println("[SPCL_TAG] : " + "onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        println("[SPCL_TAG] : " + "onStart")
    }

    override fun onResume() {
        super.onResume()
        println("[SPCL_TAG] : " + "onResume")
    }

    override fun onPause() {
        super.onPause()
        println("[SPCL_TAG] : " + "onPause")
    }

    override fun onStop() {
        super.onStop()
        println("[SPCL_TAG] : " + "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("[SPCL_TAG] : " + "onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("[SPCL_TAG] : " + "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        println("[SPCL_TAG] : " + "onDestroy")
    }
}
