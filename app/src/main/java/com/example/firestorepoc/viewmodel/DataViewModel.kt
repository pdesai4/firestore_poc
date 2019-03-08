package com.example.firestorepoc.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.firestorepoc.model.CatalogList
import com.example.firestorepoc.model.PDPList
import com.google.firebase.firestore.FirebaseFirestore


class DataViewModel : ViewModel() {

    private var catalogDataLiveData: MutableLiveData<List<CatalogList.Product>> = MutableLiveData()
    private var pdpDataLiveData: MutableLiveData<List<PDPList.Product>> = MutableLiveData()

    init {
        getCatalogData()
        getPDPData()
    }

    private fun getPDPData() {
        val products = ArrayList<PDPList.Product>()
        FirebaseFirestore.getInstance().collection("pdp")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("PIYU", document.id + " => " + document.data)
                    products.add(PDPList.Product(document.data))
                }
                pdpDataLiveData.value = products
            }
            .addOnFailureListener { exception ->
                Log.d("PIYU", "Error getting documents.", exception)
            }
    }

    private fun getCatalogData() {
        val products = ArrayList<CatalogList.Product>()
        FirebaseFirestore.getInstance().collection("catalog")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("PIYU", document.id + " => " + document.data)
                    products.add(CatalogList.Product(document.data))
                }
                catalogDataLiveData.value = products
            }
            .addOnFailureListener { exception ->
                Log.d("PIYU", "Error getting documents.", exception)
            }
    }

    fun getCatalogDataLiveData(): LiveData<List<CatalogList.Product>> {
        return catalogDataLiveData
    }

    fun getPDPDataLiveData(): LiveData<List<PDPList.Product>> {
        return pdpDataLiveData
    }
}