package io.mobjob.mentorship.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.mobjob.mentorship.databinding.ActivityMainBinding
import io.mobjob.mentorship.ui.MainActivityViewModel.OnEvent.HideToolbar
import io.mobjob.mentorship.ui.MainActivityViewModel.OnEvent.HideToolbarBackButton
import io.mobjob.mentorship.ui.MainActivityViewModel.OnEvent.SetToolbarTitle
import io.mobjob.mentorship.ui.MainActivityViewModel.OnEvent.ShowToolbar
import io.mobjob.mentorship.ui.MainActivityViewModel.OnEvent.ShowToolbarBackButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    private val observer = Observer<MainActivityViewModel.OnEvent> {
        when (it) {
            HideToolbar -> binding.toolbar.visibility = View.GONE
            HideToolbarBackButton -> binding.backButton.visibility = View.GONE
            ShowToolbarBackButton -> binding.backButton.visibility = View.VISIBLE
            is SetToolbarTitle -> binding.mainActivityTitleText.text = it.title
            ShowToolbar -> binding.toolbar.visibility = View.VISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
        viewModel.onEvent.observe(this, observer)
    }
}
