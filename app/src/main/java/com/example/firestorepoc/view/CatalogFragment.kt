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
import com.example.firestorepoc.model.CatalogList
import com.example.firestorepoc.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.fragment_catalog.*


class CatalogFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataViewModel.getCatalogDataLiveData().observe(this, Observer {
            loadData(it)
        })
    }

    private fun loadData(it: List<CatalogList.Product>?) {
        if (it == null) return

        catalog_recycler_view?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = CatalogListAdapter(it)
        }
    }
}