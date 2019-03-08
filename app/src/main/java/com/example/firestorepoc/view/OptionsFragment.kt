package com.example.firestorepoc.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.firestorepoc.R
import com.example.firestorepoc.viewmodel.CurrentFragmentViewModel

class OptionsFragment : Fragment() {

    private val TAG = "PIYU"
    private lateinit var currentFragmentViewModel: CurrentFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            currentFragmentViewModel =
                ViewModelProviders.of(activity as FragmentActivity).get(CurrentFragmentViewModel::class.java)
        }

        view.findViewById<Button>(R.id.button_catalog).setOnClickListener {
            showItemCatalog()
        }

        view.findViewById<Button>(R.id.button_pdp).setOnClickListener {
            showPdP()
        }
    }

    private fun showPdP() {
        Log.d(TAG, " ====> Show PDP ")
        currentFragmentViewModel.setCurrentFragmentLiveData(CurrentFragmentViewModel.CurrentFragment.FRAGMENT_PDP)
    }

    private fun showItemCatalog() {
        Log.d(TAG, " ====> Show Catalog ")
        currentFragmentViewModel.setCurrentFragmentLiveData(CurrentFragmentViewModel.CurrentFragment.FRAGMENT_CATALOG)
    }

}