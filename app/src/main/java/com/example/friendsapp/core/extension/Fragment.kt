package com.example.friendsapp.core.extension

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.friendsapp.core.platform.BaseActivity
import com.example.friendsapp.core.platform.BaseFragment
import kotlinx.android.synthetic.main.activity_layout.*

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

fun BaseFragment.close() = fragmentManager?.popBackStack()

val BaseFragment.viewContainer: View get() = (activity as BaseActivity).fragmentContainer

val BaseFragment.appContext: Context get() = activity?.applicationContext!!
