package com.example.friendsapp.features.home.grid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.friendsapp.R
import com.example.friendsapp.BR
import com.example.friendsapp.core.navigation.Navigator
import com.example.friendsapp.features.home.model.Results
import kotlinx.android.synthetic.main.item_users.view.*
import javax.inject.Inject

class UsersRecyclerViewAdapter(val callback: ItemClickListener) : RecyclerView.Adapter<BindableViewHolder>() {

    var users: List<Results> = emptyList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_users,
            parent,
            false)
        return BindableViewHolder(binding)
    }


    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(users[position],callback)
    }

    fun updateItems(items: List<Results>?) {
        users = items ?: emptyList()
        notifyDataSetChanged()
    }
}

class BindableViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: Results,callback: ItemClickListener) {
        binding.setVariable(BR.user, user)
        binding.root.card.setOnClickListener {
            callback.onItemClicked(user)
        }
    }
}

interface ItemClickListener {
    fun onItemClicked(user: Results)
}