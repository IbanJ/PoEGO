package com.example.poego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.ref.Reference

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var etUser : EditText
    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etUser = findViewById(R.id.username)

        auth = FirebaseAuth.getInstance()

    }


    fun register(view: View) {
        createNewAccount()
    }

    private fun createNewAccount() {
        val email:String = etEmail.text.toString()
        val password:String = etEmail.text.toString()
        val user:String = etUser.text.toString()
        var database = Firebase.firestore

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(user))
        {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){

                    if(it.isComplete){
                        database.collection("users").add(
                            hashMapOf("username" to user,
                            "email" to email)
                        )
                        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()

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

    fun login(view: View) {
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
        startActivity(Intent(this, MainActivity::class.java))
    }
}