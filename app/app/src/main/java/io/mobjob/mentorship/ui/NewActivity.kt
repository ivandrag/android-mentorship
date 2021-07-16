package io.mobjob.mentorship.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.mobjob.mentorship.R

class NewActivity : AppCompatActivity(R.layout.activity_new) {
    private val viewModel: NewActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.new_activity_fragment_container_view, HomeFragment.newInstance())
                .commit()
        }

        // Our variable change observer to toggle our fragment
//        viewModel.fragmentStatus.observe(this, Observer { fragmentStatus ->
//            if (fragmentStatus == true) {
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.new_activity_fragment_container_view, HomeFragment.newInstance()).commit()
//            } else {
//
//            }
//        })
    }

    fun showHomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.new_activity_fragment_container_view, HomeFragment.newInstance())
            .commit()
    }

    fun showDetailsFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.new_activity_fragment_container_view, DetailsFragment.newInstance())
            .commit()
    }
}
