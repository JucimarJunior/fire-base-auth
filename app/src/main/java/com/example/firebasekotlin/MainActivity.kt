package com.example.firebasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseConfig = FirebaseConfig()
        var auth: FirebaseAuth = firebaseConfig.getFirebaseAuth()

        var inserirEmail = findViewById<EditText>(R.id.inserirEmail)
        var inserirPassword = findViewById<EditText>(R.id.inserirPassword)

        var buttonSend = findViewById<Button>(R.id.sendButton)

        buttonSend?.setOnClickListener {
            var email = inserirEmail?.text.toString()
            var password = inserirPassword?.text.toString()

            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener { task ->
                    when {
                        task.isSuccessful -> {
                            Toast.makeText(
                                applicationContext,
                                "Usuário inserido com sucesso!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
        }
    }
}