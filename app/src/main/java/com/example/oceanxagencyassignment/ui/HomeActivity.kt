package com.example.oceanxagencyassignment.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.oceanxagencyassignment.R
import com.example.oceanxagencyassignment.adapter.ProductAdapter
import com.example.oceanxagencyassignment.databinding.ActivityHomeBinding
import com.example.oceanxagencyassignment.model.Product
import com.example.oceanxagencyassignment.utils.DummyData

//class HomeActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_home)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    companion object {

        val cartList =
            mutableListOf<Product>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val productList =
            DummyData.getProducts()

        val adapter =
            ProductAdapter(productList) {

                addToCart(it)
            }

        binding.recyclerProducts.layoutManager =
            GridLayoutManager(this, 2)

        binding.recyclerProducts.adapter =
            adapter

        binding.btnCart.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CartActivity::class.java
                )
            )
        }
    }

    private fun addToCart(product: Product) {

        val existingItem =
            cartList.find {
                it.id == product.id
            }

        if (existingItem != null) {

            existingItem.quantity++

        } else {

            cartList.add(product.copy())
        }

        Toast.makeText(
            this,
            "Added To Cart",
            Toast.LENGTH_SHORT
        ).show()
    }
}