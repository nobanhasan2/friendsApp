package com.example.friendsapp.core.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.friendsapp.R
import com.example.friendsapp.core.auth.Authenticator
import com.example.friendsapp.features.home.model.Results
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class  Navigator  @Inject constructor() {

    lateinit var navController : NavController

    fun init(navHostFragment:NavHostFragment){
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        navController = navHostFragment.navController
        navController.graph = graph

    }


    fun userToDetails(result: Results){
        val bundle = bundleOf("user" to result)
        navController.navigate(R.id.detailsFragment,bundle)
    }
}