package com.example.oceanxagencyassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oceanxagencyassignment.databinding.ItemProductBinding
import com.example.oceanxagencyassignment.model.Product

class ProductAdapter(
    private val productList: List<Product>,
    private val onAddClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = productList[position]

        holder.binding.tvName.text = product.name

        holder.binding.tvPrice.text =
            "₹${product.price}"

        holder.binding.ivProduct.setImageResource(
            product.image
        )

        holder.binding.btnAdd.setOnClickListener {

            onAddClick(product)
        }
    }

    override fun getItemCount(): Int {

        return productList.size
    }
}