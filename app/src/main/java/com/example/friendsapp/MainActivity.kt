package com.example.friendsapp

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.friendsapp.core.platform.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) { setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        val navigationHost =  supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navigation.init(navigationHost)
        setSupportActionBar(toolbar)
//        navigationHost.navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.loginFragment) {
//                supportActionBar?.hide()
//            } else {
//                supportActionBar?.show()
//            }
//        }

    }
}