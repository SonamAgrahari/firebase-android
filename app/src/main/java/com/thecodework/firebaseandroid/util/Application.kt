package com.thecodework.firebaseandroid.util

import android.app.Application
import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Firebase.messaging.subscribeToTopic("weather")
            .addOnCompleteListener { task ->
                var msg = "Done"
                if (!task.isSuccessful) {
                    msg = "Failed"
                }
                Log.d(ContentValues.TAG, msg)
            }
    }
}