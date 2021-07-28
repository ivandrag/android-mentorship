package io.mobjob.mentorship.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import io.mobjob.mentorship.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupSubmitButton.setOnClickListener {
            if(binding.fullName.text.toString().isEmpty()) {
                Toast.makeText(context , "Full name field is empty", Toast.LENGTH_SHORT).show()
            }
            else if(binding.emailAddress.text.toString().isEmpty()) {
                Toast.makeText(context , "Email Address field is empty", Toast.LENGTH_SHORT).show()
            }
            else if(binding.userName.text.toString().isEmpty()) {
                Toast.makeText(context , "User Name field is empty", Toast.LENGTH_SHORT).show()
            }
            else if(binding.password.text.toString().isEmpty() || binding.password.text.toString().length < 7) {
                Toast.makeText(context , "Password field is incorrect", Toast.LENGTH_SHORT).show()
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
}
