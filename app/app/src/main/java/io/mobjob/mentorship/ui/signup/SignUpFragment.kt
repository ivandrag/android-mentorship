package io.mobjob.mentorship.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import io.mobjob.mentorship.R
import io.mobjob.mentorship.databinding.FragmentSignUpBinding
import io.mobjob.mentorship.ui.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {
    private val viewModel: SignUpViewModel by viewModels()

    override fun bindingInit(
        inflate: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): ConstraintLayout? {
        this._binding =  FragmentSignUpBinding.inflate(inflate, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val errorMessages = resources.getStringArray(R.array.signup_error_messages)
        binding.signupSubmitButton.setOnClickListener {

            val toastMsg = viewModel.checkTextEditValue(
                binding.fullName.text.toString(),
                binding.emailAddress.text.toString(),
                binding.userName.text.toString(),
                binding.password.text.toString());

            if (toastMsg != null) {
                Toast.makeText(context , errorMessages[toastMsg], Toast.LENGTH_SHORT).show()
            } else {
                Navigation.findNavController(view).navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeFragment(
                    binding.fullName.text.toString(),
                    binding.emailAddress.text.toString(),
                    binding.fullAddress.text.toString(),
                    binding.userName.text.toString()
                ))
            }
        }
    }
    override fun goToFragment(navController: NavController) {}
}
