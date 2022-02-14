package com.example.poego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomnavigation : BottomNavigationView
    private lateinit var navListener : BottomNavigationView.OnNavigationItemSelectedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}