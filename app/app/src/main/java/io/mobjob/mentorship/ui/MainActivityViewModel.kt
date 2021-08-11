package io.mobjob.mentorship.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _onEvent = MutableLiveData<OnEvent>()

    val onEvent: LiveData<OnEvent> get() = _onEvent

    fun changeMainActivityTitle(title: String) {
        _onEvent.value = OnEvent.SetToolbarTitle(title)
    }

    fun hideMainActivityBackButton(isVisible: Boolean) {
        if (isVisible) {
            _onEvent.value = OnEvent.ShowToolbarBackButton
            return
        }
        _onEvent.value = OnEvent.HideToolbarBackButton
    }

    fun setToolBarVisible(isVisible: Boolean) {
        if (isVisible) {
            _onEvent.value = OnEvent.ShowToolbar
            return
        }
        _onEvent.value = OnEvent.HideToolbar
    }

    sealed class OnEvent {
        data class SetToolbarTitle(val title: String) : OnEvent()
        object ShowToolbar : OnEvent()
        object HideToolbar : OnEvent()
        object HideToolbarBackButton : OnEvent()
        object ShowToolbarBackButton : OnEvent()
    }
}
