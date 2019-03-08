package com.example.firestorepoc.view

import com.example.firestorepoc.model.ProductList

interface ProductClickListener {
    fun onProductClicked(position: Int, product: List<ProductList.Product>)
}