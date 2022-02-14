package com.example.poego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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

    fun register () {
        createNewAccount()
    }

    private fun createNewAccount() {
        val email:String = etEmail.text.toString()
        val password:String = etEmail.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
        {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){

                    if(it.isComplete){
                        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                        navigateToMain()

                    }
                    else{
                        Toast.makeText(this, "Error al crear usuario", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        else{
            Toast.makeText(this, "Rellene los dos campos de texto", Toast.LENGTH_SHORT).show()
        }

    }

    fun login () {
        loginAccount()
    }

    private fun loginAccount () {
        val email:String = etEmail.text.toString()
        val password:String = etEmail.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
        {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){

                    if(it.isComplete){
                        Toast.makeText(this, "Usuario identificado correctamente", Toast.LENGTH_SHORT).show()
                        navigateToMain()

                    }
                    else{
                        Toast.makeText(this, "Error al identificar usuario", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        else{
            Toast.makeText(this, "Rellene los dos campos de texto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToMain() {
        Intent(this, MainActivity::class.java)
    }
}