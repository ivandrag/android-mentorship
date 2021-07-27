package io.mobjob.mentorship.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.mobjob.mentorship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.mainActivityTitle.observe(this, Observer {title ->
            binding.mainActivityTitleText.text = title
        })

        viewModel.mainActivityToolBar.observe(this, Observer { value ->
            binding.backButton.visibility = if(value == true) View.VISIBLE else View.GONE
        })

        viewModel.mainActivityIn.observe(this, Observer { value ->
            binding.toolbar.visibility = if(value == true) View.VISIBLE else View.GONE
        })

        binding.backButton.setOnClickListener{
            //this.supportFragmentManager.popBackStack()
            onBackPressed()
        }
    }
}
