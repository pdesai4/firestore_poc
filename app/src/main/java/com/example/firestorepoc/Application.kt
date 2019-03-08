package com.example.firestorepoc

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions


class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize the default instance
        //FirebaseApp.initializeApp(this)

        val options = FirebaseOptions.Builder()
            .setApplicationId("1:35893953286:android:40b697a145942a08") // Required for Analytics.
            .setApiKey("AIzaSyBGGhKzuvBjv9wqCwr-vOXN2UMXWykX-xA") // Required for Auth.
            .setDatabaseUrl("https://firestonepoc.firebaseio.com") // Required for RTDB.
            .build()

        FirebaseApp.initializeApp(this, options, "secondary")
    }
}