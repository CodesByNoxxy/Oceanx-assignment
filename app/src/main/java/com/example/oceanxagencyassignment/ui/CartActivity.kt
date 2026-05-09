package com.example.oceanxagencyassignment.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oceanxagencyassignment.R
import com.example.oceanxagencyassignment.adapter.CartAdapter
import com.example.oceanxagencyassignment.databinding.ActivityCartBinding

//class CartActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_cart)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityCartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter =
            CartAdapter(HomeActivity.cartList)

        binding.recyclerCart.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerCart.adapter =
            adapter

        val total =
            HomeActivity.cartList.sumOf {

                it.price * it.quantity
            }

        binding.tvTotal.text =
            "Total: ₹$total"

        binding.btnCheckout.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CheckoutActivity::class.java
                )
            )
        }
    }
}