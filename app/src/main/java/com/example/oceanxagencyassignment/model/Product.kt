package com.example.oceanxagencyassignment.model

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 1
)
