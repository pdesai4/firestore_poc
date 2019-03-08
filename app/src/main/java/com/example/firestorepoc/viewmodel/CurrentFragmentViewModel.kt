package com.example.firestorepoc.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.firestorepoc.model.PDPList

class CurrentFragmentViewModel : ViewModel() {

    private var currentFragmentLiveData: MutableLiveData<CurrentFragment> = MutableLiveData()
    private var currentProductLiveData: MutableLiveData<PDPList.Product> = MutableLiveData()

    init {
        currentFragmentLiveData.value = CurrentFragment.FRAGMENT_OPTIONS
        currentProductLiveData.value = null
    }

    fun getCurrentFragmentLiveData(): LiveData<CurrentFragment> {
        return currentFragmentLiveData
    }

    fun setCurrentFragmentLiveData(value: CurrentFragment) {
        currentFragmentLiveData.value = value
    }

    fun getCurrentProductLiveData(): LiveData<PDPList.Product> {
        return currentProductLiveData
    }

    fun setCurrentProductLiveData(value: PDPList.Product) {
        currentProductLiveData.value = value
    }

    enum class CurrentFragment {
        FRAGMENT_OPTIONS,
        FRAGMENT_CATALOG,
        FRAGMENT_PDP,
        FRAGMENT_DESC
    }
}