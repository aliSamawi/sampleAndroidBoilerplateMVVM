package com.sama.useradmin.presentation.admin_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sama.useradmin.R
import com.sama.useradmin.data.model.User

class UserAdapter(var userList:MutableList<User>,
                  private var mUserRvAdapterCallback: UserRvAdapterCallback? = null) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    fun updateItems(
        newUserList: List<User>
    ) {
        val diffCallback = userListRvAdapterDiffCallback(userList, newUserList)
        val diffResult = DiffUtil.calculateDiff(diffCallback, false)
        userList.clear()
        userList.addAll(newUserList)
        diffResult.dispatchUpdatesTo(this@UserAdapter)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)))
    }

    override fun getItemCount(): Int =
        userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName:TextView = itemView.findViewById(R.id.tvName)
        val ivUser: ImageView = itemView.findViewById(R.id.ivUser)
        val ibRemove: ImageButton = itemView.findViewById(R.id.ibDelete)

        init {
            ibRemove.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    mUserRvAdapterCallback?.onRemoveClicked(userList[adapterPosition])
                }
            }
        }
        fun bind(user: User){
            tvName.text = user.email
            if (user.image.isNotEmpty()) {
                with(user.image){
                    val requestOptions = RequestOptions()
                    requestOptions.placeholder(R.drawable.profile)
                    requestOptions.error(R.drawable.profile)

                    Glide.with(itemView.context)
                        .load(this)
                        .apply(requestOptions)
                        .into(ivUser)
                }
            } else {
                Glide.with(itemView.context)
                    .load(R.drawable.profile)
                    .apply(RequestOptions())
                    .into(ivUser)
            }
        }
    }

    inner class userListRvAdapterDiffCallback(
        private val oldList: List<User>,
        private val newList: List<User>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            newList[newItemPosition] == oldList[oldItemPosition]

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            newList[newItemPosition].email == oldList[oldItemPosition].email
    }

    interface UserRvAdapterCallback {
        fun onRemoveClicked(data: User)
    }

}