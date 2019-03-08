package com.example.firestorepoc.view

import com.example.firestorepoc.model.PDPList

interface ProductClickListener {
    fun onProductClicked(position: Int, products: List<PDPList.Product>)
}