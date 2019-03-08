package com.example.firestorepoc.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.firestorepoc.model.ProductList
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore


class DataViewModel : ViewModel() {

    private var catalogDataLiveData: MutableLiveData<List<ProductList.Product>> = MutableLiveData()

    init {
        getCatalogData()
        accessFirebaseDatabase()
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

    fun accessFirebaseDatabase() {
        val app = FirebaseApp.getInstance("secondary")
        val secondaryDatabase = FirebaseDatabase.getInstance(app)
        val myRef = secondaryDatabase.getReference("message")
        myRef.setValue("Hello, World!")
    }

    fun getCatalogDataLiveData(): LiveData<List<ProductList.Product>> {
        return catalogDataLiveData
    }

}