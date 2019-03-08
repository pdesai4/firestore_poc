package com.example.database

import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase


class MyDatabase {

    fun accessDB() {
        // Retrieve my other app.
        val app = FirebaseApp.getInstance("secondary")
        // Get the database for the other app.
        val secondaryDatabase = FirebaseDatabase.getInstance(app)
        val myRef = secondaryDatabase.getReference("message")
        myRef.setValue("Hello, World!")
    }
}