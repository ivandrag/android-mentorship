package io.mobjob.mentorship.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.mobjob.mentorship.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.login_button).setOnClickListener {

            val userName : TextView = findViewById<TextView>(R.id.username_edit_text)
            val password : TextView = findViewById<TextView>(R.id.password_edit_text)

            if(userName.text.toString().isNullOrEmpty() && password.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.no_username_or_password_toast), Toast.LENGTH_SHORT).show()
            } else {
                val i = Intent(this@MainActivity, HomeActivity::class.java)
                i.putExtra("username", userName.text.toString())
                i.putExtra("password", password.text.toString())
                startActivity(i);
            }
        }
    }
}
