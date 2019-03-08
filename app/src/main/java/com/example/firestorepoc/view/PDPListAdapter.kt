package com.example.firestorepoc.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.firestorepoc.R
import com.example.firestorepoc.model.ProductList

class PDPListAdapter(
    private val data: List<ProductList.Product>,
    private val productClickListener: ProductClickListener
) : RecyclerView.Adapter<PDPListAdapter.ViewHolder>() {

    companion object {
        private const val URL_PREFIX = "https:"
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PDPListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PDPListAdapter.ViewHolder, position: Int) {
        val product = data[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            productClickListener.onProductClicked(holder.adapterPosition, data)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage = itemView.findViewById<ImageView>(R.id.product_image)
        private val productName = itemView.findViewById<TextView>(R.id.product_name)
        private val productPrice = itemView.findViewById<TextView>(R.id.product_price)
        private val productInStock = itemView.findViewById<TextView>(R.id.product_in_stock)

        fun bind(product: ProductList.Product) {
            Glide.with(productImage.context)
                .load(URL_PREFIX + product.listImage)
                .into(productImage)

            productName.text = product.productName
            productPrice.text = "$ ${product.price}"
            if (product.inStock.equals("inStock")) {
                productInStock.text = "In Stock"
                productInStock.setTextColor(productInStock.resources.getColor(R.color.colorInStock))
            } else {
                productInStock.text = "Out of Stock"
                productInStock.setTextColor(productInStock.resources.getColor(R.color.colorOutOfStock))
            }
        }
    }


}