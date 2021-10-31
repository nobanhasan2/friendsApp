package com.example.friendsapp.core.navigation

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.friendsapp.R
import com.example.friendsapp.core.auth.Authenticator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class  Navigator  @Inject constructor(private val authenticator: Authenticator) {

    lateinit var navController : NavController

    fun init(navHostFragment:NavHostFragment){
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        navController = navHostFragment.navController
        navController.graph = graph

    }


    fun showSignUp(){ navController.navigate(R.id.homeFragment) }
}