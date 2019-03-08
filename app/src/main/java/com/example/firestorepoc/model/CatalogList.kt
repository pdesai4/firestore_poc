package com.example.firestorepoc.model

import com.google.firebase.firestore.QueryDocumentSnapshot


class CatalogList(snapshot: QueryDocumentSnapshot) {
    private var productMap = HashMap<String, Product>()

    init {
        productMap[snapshot.id] = Product(snapshot.data)
    }

    class Product() {
        var productId: String? = null
        var listImage: String? = null
        var price: String? = null
        var productName: String? = null
        var inStock: String? = null

        constructor(data: MutableMap<String, Any>) : this() {
            productId = data["productId"].toString()
            productName = data["productName"].toString()
            listImage = data["listImage"].toString()
            inStock = (data["onlineInventory"] as Map<*, *>)["status"].toString()
            price = ((data["onlinePricing"] as Map<*, *>)["finalPrice"] as Map<*, *>)["currencyAmount"].toString()
        }
    }
}
