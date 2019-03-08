package com.example.firestorepoc.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firestorepoc.R
import com.example.firestorepoc.model.ProductList
import com.example.firestorepoc.viewmodel.CurrentFragmentViewModel
import com.example.firestorepoc.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.fragment_catalog.*

class PDPFragment : Fragment(), ProductClickListener {

    private lateinit var dataViewModel: DataViewModel
    private lateinit var currentFragmentViewModel: CurrentFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        currentFragmentViewModel = ViewModelProviders.of(this).get(CurrentFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataViewModel.getPDPDataLiveData().observe(this, Observer {
            loadData(it)
        })
    }

    private fun loadData(it: List<ProductList.Product>?) {
        if (it == null) return

        catalog_recycler_view?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = PDPListAdapter(it, this@PDPFragment)
        }
    }

    override fun onProductClicked(position: Int, product: List<ProductList.Product>) {
        currentFragmentViewModel.setCurrentFragmentLiveData(CurrentFragmentViewModel.CurrentFragment.FRAGMENT_DESC)
    }

}