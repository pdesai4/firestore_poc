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
            .setApplicationId("1:536440039778:android:6b90121ef79d0181") // Required for Analytics.
            .setApiKey("AIzaSyDJ-vC4JyQdMbHLKkvuiyDjc27tFtrdrdU") // Required for Auth.
            .setDatabaseUrl("https://fir-database-af8c5.firebaseio.com") // Required for RTDB.
            .build()

        FirebaseApp.initializeApp(this, options, "secondary")
    }
}