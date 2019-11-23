package com.cdev.service.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient

class ConfigService {

    private var client: Firestore;

    init {
        val options = FirebaseOptions.Builder().setCredentials(GoogleCredentials.getApplicationDefault())
            .setDatabaseUrl("https://trakkit-49c91.firebaseio.com/")
            .build()

        FirebaseApp.initializeApp(options)
        client = FirestoreClient.getFirestore()
    }

    suspend fun getConfig(): ArrayList<FrontPageConfig> {
        val querySnapshot = client.collection("config").get().await()
        val components = ArrayList<FrontPageConfig>()
        for (document in querySnapshot.documents) {
            val component = FrontPageConfig(
                document.data["id"] as Long,
                document.data["name"] as String,
                document.data["type"] as String
            )

            components.add(component)
        }

        return components
    }
}