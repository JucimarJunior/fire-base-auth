package com.example.firebasekotlin

import com.google.firebase.auth.FirebaseAuth

class FirebaseConfig {
    private var firebaseAuth: FirebaseAuth? = null

    fun getFirebaseAuth(): FirebaseAuth {
        if(firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance()
        }
        return firebaseAuth as FirebaseAuth
    }
}

