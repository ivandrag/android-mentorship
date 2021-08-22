package io.mobjob.mentorship.ui.signup

import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    fun checkTextEditValue(fullName : String, emailAddress : String, userName : String, password : String) : Int? {
        return if(fullName.isEmpty()) {0}
        else if(emailAddress.isEmpty()) {1}
        else if(userName.isEmpty()) {2}
        else if(password.isEmpty() || password.length < 7) {3}
        else {null}
    }
}
