package io.mobjob.mentorship.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val mutableMainActivityTitle = MutableLiveData<String>()
    private val mutableMainActivityBackbutton = MutableLiveData<Boolean>()
    private val mutableMainActivityToolBar= MutableLiveData<Boolean>()
    val mainActivityTitle : LiveData<String> get() = mutableMainActivityTitle
    val mainActivityToolBar : LiveData<Boolean> get() = mutableMainActivityBackbutton
    val mainActivityIn : LiveData<Boolean> get() = mutableMainActivityToolBar

    fun changeMainActivityTitle(title : String) {
        mutableMainActivityTitle.value = title
    }

    fun hideMainActivityBackButton(value : Boolean) {
        mutableMainActivityBackbutton.value = value
    }

    fun setToolBarVisible(value : Boolean) {
        mutableMainActivityToolBar.value = value
    }
}
