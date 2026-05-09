package com.example.oceanxagencyassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oceanxagencyassignment.databinding.ItemCartBinding
import com.example.oceanxagencyassignment.model.Product

class CartAdapter(
    private val cartList: List<Product>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(
        val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {

        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {

        val product = cartList[position]

        holder.binding.tvCartName.text =
            product.name

        holder.binding.tvCartPrice.text =
            "₹${product.price}"

        holder.binding.tvQuantity.text =
            "Qty: ${product.quantity}"

        holder.binding.ivCartProduct.setImageResource(
            product.image
        )
    }

    override fun getItemCount(): Int {

        return cartList.size
    }
}