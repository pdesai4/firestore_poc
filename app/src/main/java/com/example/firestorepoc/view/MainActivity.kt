package com.example.firestorepoc.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.database.MyDatabase
import com.example.firestorepoc.R
import com.example.firestorepoc.viewmodel.CurrentFragmentViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragmentViewModel = ViewModelProviders.of(this).get(CurrentFragmentViewModel::class.java)
        currentFragmentViewModel.getCurrentFragmentLiveData().observe(this, Observer {
            loadFragment(it)
        })

        MyDatabase().accessDB()
    }

    private fun loadFragment(it: CurrentFragmentViewModel.CurrentFragment?) {
        when (it) {
            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_OPTIONS -> showOptionsFragment()

            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_CATALOG -> showCatalogFragment()

            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_PDP -> showPDPFragment()

            CurrentFragmentViewModel.CurrentFragment.FRAGMENT_DESC -> showProductDescriptionFragment()
        }
    }

    private fun showPDPFragment() {
        val pdpFragment = PDPFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, pdpFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showProductDescriptionFragment() {
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
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}