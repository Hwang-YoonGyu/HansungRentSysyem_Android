package com.example.hansungrentsystem_android


import com.google.android.datatransport.runtime.logging.Logging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) { // Get updated InstanceID token.
        Logging.d(TAG, "Refreshed token: $token")
// TODO: Implement this method to send any registration to your app's servers.
// sendRegistrationToServer(token)
    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Logging.d(TAG, "From: ${remoteMessage.from}")
        Logging.d(TAG, "Message data payload: ${remoteMessage.data}")
        val msgBody = remoteMessage.notification?.body
        Logging.d(TAG, "Message Notification Body: $msgBody")
    }
    companion object {
        const val TAG = "MyFirebaseMessaging"
    }
}
