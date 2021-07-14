package io.mobjob.mentorship.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewActivityViewModel : ViewModel() {
    private val mutableFragmentStatus = MutableLiveData<Boolean>()
    val fragmentStatus: LiveData<Boolean> get() = mutableFragmentStatus

    fun toggleFragment() {
        mutableFragmentStatus.value = mutableFragmentStatus.value == false
    }
}
