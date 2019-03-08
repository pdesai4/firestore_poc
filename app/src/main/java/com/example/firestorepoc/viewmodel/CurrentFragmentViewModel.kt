package com.example.firestorepoc.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class CurrentFragmentViewModel : ViewModel() {

    private var currentFragmentLiveData: MutableLiveData<CurrentFragment> = MutableLiveData()

    fun getCurrentFragmentLiveData(): LiveData<CurrentFragment> {
        return currentFragmentLiveData
    }

    fun setCurrentFragmentLiveData(value: CurrentFragment) {
        currentFragmentLiveData.value = value
    }

    init {
        currentFragmentLiveData.value = CurrentFragment.FRAGMENT_OPTIONS
    }

    enum class CurrentFragment {
        FRAGMENT_OPTIONS,
        FRAGMENT_CATALOG,
        FRAGMENT_PDP,
        FRAGMENT_DESC
    }
}