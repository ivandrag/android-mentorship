package io.mobjob.mentorship.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseFragment<T>(
    private val title : String = "",
    private val withToolBar : Boolean = false,
    private val backButton : Boolean = false) : Fragment() {
    private val viewModel : MainActivityViewModel by activityViewModels()
    var _binding: T? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.changeMainActivityTitle(this.title)
        viewModel.hideMainActivityBackButton(this.backButton)
        viewModel.setToolBarVisible(this.withToolBar)
        return bindingInit(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToFragment(Navigation.findNavController(view))
    }

    abstract fun  bindingInit(inflate : LayoutInflater, container : ViewGroup?, attachToParent : Boolean) : ConstraintLayout?
    abstract fun goToFragment(navController : NavController)
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
