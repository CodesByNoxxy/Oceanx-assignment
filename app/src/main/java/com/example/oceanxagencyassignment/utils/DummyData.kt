package com.example.oceanxagencyassignment.utils

import com.example.oceanxagencyassignment.R
import com.example.oceanxagencyassignment.model.Product

object DummyData {

    fun getProducts(): MutableList<Product> {

        return mutableListOf(

            Product(
                1,
                "Apple",
                120,
                R.drawable.apple
            ),

            Product(
                2,
                "Banana",
                60,
                R.drawable.banana
            ),

            Product(
                3,
                "Milk",
                50,
                R.drawable.milk
            ),

            Product(
                4,
                "Bread",
                40,
                R.drawable.bread
            ),

            Product(
                5,
                "Chips",
                20,
                R.drawable.chips
            )

        )
    }
}