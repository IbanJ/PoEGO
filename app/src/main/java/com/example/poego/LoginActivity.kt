package com.example.poego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.ref.Reference

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()



    }
}