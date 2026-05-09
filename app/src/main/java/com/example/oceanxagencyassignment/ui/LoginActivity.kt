package com.example.oceanxagencyassignment.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.oceanxagencyassignment.R
import com.example.oceanxagencyassignment.databinding.ActivityLoginBinding

//class LoginActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_login)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val phone = binding.etPhone.text.toString()
            val otp = binding.etOtp.text.toString()

            if (phone.length != 10) {

                Toast.makeText(
                    this,
                    "Enter valid phone number",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (otp != "1234") {

                Toast.makeText(
                    this,
                    "Invalid OTP",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                startActivity(
                    Intent(
                        this,
                        HomeActivity::class.java
                    )
                )

                finish()
            }
        }
    }
}