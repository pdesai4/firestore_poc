package com.example.firestorepoc.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.firestorepoc.R
import com.example.firestorepoc.model.PDPList
import com.example.firestorepoc.viewmodel.CurrentFragmentViewModel
import kotlinx.android.synthetic.main.fragment_product_desc.*

class ProductDescriptionFragment : Fragment() {
    private val URL_PREFIX = "https:"
    private lateinit var currentFragmentViewModel: CurrentFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentFragmentViewModel = ViewModelProviders.of(activity as FragmentActivity).get(CurrentFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_desc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData(currentFragmentViewModel.getCurrentProductLiveData().value)
    }

    private fun loadData(product: PDPList.Product?) {
        if (product == null) return

        product_name.text = product.productName
        Glide.with(product_image.context)
            .load(URL_PREFIX + product.listImage)
            .into(product_image)
        product_price.text = "$ ${product.price}"

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            product_description.text = Html.fromHtml(product.shortDescription, Html.FROM_HTML_MODE_COMPACT)
        } else {
            product_description.text = Html.fromHtml(product.shortDescription)
        }
    }

}