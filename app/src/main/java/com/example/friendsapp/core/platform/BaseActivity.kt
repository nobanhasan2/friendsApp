package com.example.friendsapp.core.platform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.friendsapp.R
import com.example.friendsapp.core.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Base Activity class with helper methods for handling fragment transactions and back button
 * events.
 *
 * @see AppCompatActivity
 */
@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var navigation: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
    }
    override fun onBackPressed() {
        /**
         Navigation back stack handle from fragment stack
         */
        if (!navigation.navController.popBackStack()) { finish()

        }else{ navigation.navController.popBackStack() }
    }
}
