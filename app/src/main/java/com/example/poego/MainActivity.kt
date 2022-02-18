package com.example.poego

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    private lateinit var bottomnavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = Bundle()
        bundle.putString("message", "Integracion de firebase completa")
        val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        analytics.logEvent("InitScreen", bundle)

        bottomnavigation = findViewById(R.id.bottom_navigation)
        bottomnavigation.setOnNavigationItemSelectedListener(
            fun(item: MenuItem): Boolean {

                lateinit var selectedFragment : Fragment
                when (item.itemId) {
                    R.id.nav_beguinners -> {
                        selectedFragment = BeginnerGuide()
                    }
                    R.id.vendors_recipe -> {
                        selectedFragment = VendorRecipes()
                    }
                    R.id.nav_user_settings -> {
                        selectedFragment = SettingFragment()
                    }
                }
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
                return true
            })
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BeginnerGuide()).commit()

    }


    fun logout () {
        FirebaseAuth.getInstance().signOut()
        Intent(this, LoginActivity::class.java)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BeginnerGuide()).commit()
    }


}