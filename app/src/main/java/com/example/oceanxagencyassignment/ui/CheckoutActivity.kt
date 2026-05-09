package com.example.oceanxagencyassignment.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.oceanxagencyassignment.R
import com.example.oceanxagencyassignment.databinding.ActivityCheckoutBinding

//class CheckoutActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_checkout)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
class CheckoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityCheckoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnPlaceOrder.setOnClickListener {

            val address =
                binding.etAddress.text.toString()

            if (address.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter Address",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                startActivity(
                    Intent(
                        this,
                        OrderSuccessActivity::class.java
                    )
                )

                finish()
            }
        }
    }
}