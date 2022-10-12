package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService :FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("MyFirebaseMSGService","From: ${message.from}")
        Log.d("MyFirebaseMSGService","Message data payload:  ${message.data}")
        sendNotification(message.data.toString())
    }

    private fun sendNotification(message: String) {
        ContextCompat.getSystemService(
            applicationContext, NotificationManager::class.java
        )?.sendNotification(message, applicationContext)
    }

    /*
     Called if InstanceID token is updated. This may occur if the security of
    * the previous token had been compromised. Note that this is called when the InstanceID token
    * is initially generated so this is where you would retrieve the token.
    */
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("MyFirebaseMSGService","Refreshed token: ${token}")
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
       // sendRegistrationToServer(token)
    }
}