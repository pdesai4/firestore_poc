package com.example.firestorepoc.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.firestorepoc.R
import com.example.firestorepoc.viewmodel.CurrentFragmentViewModel
import com.example.firestorepoc.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragmentViewModel = ViewModelProviders.of(this).get(CurrentFragmentViewModel::class.java)
        currentFragmentViewModel.getCurrentFragmentLiveData().observe(this, Observer {
            loadFragment(it)
        })
    }

    private fun loadFragment(it: CurrentFragmentViewModel.CurrentFragment?) {
        when (it) {
            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_OPTIONS -> showOptionsFragment()

            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_CATALOG -> showCatalogFragment()

            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_PDP -> showPDPFragment()

            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_DESC -> showProducDescriptionFragment()
        }
    }

    private fun showPDPFragment() {

    }

    private fun showProducDescriptionFragment() {
        val productDescriptionFragment = ProductDescriptionFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, productDescriptionFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showCatalogFragment() {
        val catalogFragment = CatalogFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, catalogFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showOptionsFragment() {
        val optionsFragment = OptionsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, optionsFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}