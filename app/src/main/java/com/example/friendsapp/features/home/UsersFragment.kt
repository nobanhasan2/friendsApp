package com.example.friendsapp.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.friendsapp.core.extension.failure
import com.example.friendsapp.core.extension.observe
import com.example.friendsapp.core.platform.BaseFragment
import com.example.friendsapp.core.platform.BaseVMFragment
import com.example.friendsapp.databinding.FragmentUserlistBinding
import com.example.friendsapp.features.home.grid.UsersRecyclerViewAdapter
import com.example.friendsapp.features.home.model.UserResults
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_userlist.*
import javax.inject.Inject


@AndroidEntryPoint
class UsersFragment: BaseVMFragment<UsersViewModel, FragmentUserlistBinding>() {



    @Inject
    lateinit var usersAdapter: UsersRecyclerViewAdapter

    private val usersViewModel by viewModels<UsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(usersViewModel){
            observe(userResult,::onSuccessUsers)
            failure(failure,::handleFailure)
        }
        with(usersViewModel){
            observe(loadingStatus,::showProgressLoader)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        usersViewModel.getUsersList()

    }


    private fun initializeView(){
        mBinding.rvUser.layoutManager = GridLayoutManager(activity, 2)
        mBinding.rvUser.adapter = usersAdapter

    }

    private fun onSuccessUsers(userResult: UserResults?) {
        usersAdapter.updateItems(userResult!!.results)

    }

    override fun getViewBinding() = FragmentUserlistBinding.inflate(layoutInflater)
}