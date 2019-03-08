package com.example.firestorepoc.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.firestorepoc.model.ProductList
import com.google.firebase.firestore.FirebaseFirestore


class DataViewModel : ViewModel() {

    private var catalogDataLiveData: MutableLiveData<List<ProductList.Product>> = MutableLiveData()
    private var pdpDataLiveData: MutableLiveData<List<ProductList.Product>> = MutableLiveData()

    init {
        getCatalogData()
        getPDPData()
    }

    private fun getPDPData() {
        val products = ArrayList<ProductList.Product>()
        FirebaseFirestore.getInstance().collection("pdp")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("PIYU", document.id + " => " + document.data)
                    products.add(ProductList.Product(document.data))
                }
                pdpDataLiveData.value = products
            }
            .addOnFailureListener { exception ->
                Log.d("PIYU", "Error getting documents.", exception)
            }
    }

    private fun getCatalogData() {
        val products = ArrayList<ProductList.Product>()
        FirebaseFirestore.getInstance().collection("catalog")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("PIYU", document.id + " => " + document.data)
                    products.add(ProductList.Product(document.data))
                }
                catalogDataLiveData.value = products
            }
            .addOnFailureListener { exception ->
                Log.d("PIYU", "Error getting documents.", exception)
            }
    }

    fun getCatalogDataLiveData(): LiveData<List<ProductList.Product>> {
        return catalogDataLiveData
    }

    fun getPDPDataLiveData(): LiveData<List<ProductList.Product>> {
        return pdpDataLiveData
    }
}