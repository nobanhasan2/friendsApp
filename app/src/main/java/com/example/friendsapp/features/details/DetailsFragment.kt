package com.example.friendsapp.features.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.example.friendsapp.BR
import com.example.friendsapp.core.platform.BaseVMFragment
import com.example.friendsapp.databinding.FragmentDetailsBinding
import com.example.friendsapp.features.home.model.Results


class DetailsFragment : BaseVMFragment<DetailsViewModel, FragmentDetailsBinding>(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val res = arguments?.get("user") as Results
        mBinding.setVariable(BR.user,res)
        mBinding.llEmail.setOnClickListener {
            onEmailClick(res.email)
        }


    }
    fun onEmailClick(email :String){
        val intent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email, null
            )
        )
        intent.putExtra(Intent.EXTRA_SUBJECT, "FriendsApp")
        intent.putExtra(Intent.EXTRA_TEXT, "Test")
        startActivity(Intent.createChooser(intent, "Choose an Email client :"))
    }
    override fun getViewBinding() = FragmentDetailsBinding.inflate(layoutInflater)
}