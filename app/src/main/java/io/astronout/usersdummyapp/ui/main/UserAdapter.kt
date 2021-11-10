package io.astronout.usersdummyapp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.astronout.usersdummyapp.data.source.remote.response.GetUsersResponse
import io.astronout.usersdummyapp.databinding.ItemUserBinding

class UserAdapter(
    private val onItemClicked: (GetUsersResponse.Data) -> Unit
) : ListAdapter<GetUsersResponse.Data, UserAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: GetUsersResponse.Data) {
            with(itemBinding) {

                Glide.with(root.context)
                    .load(data.avatar)
                    .into(imgAvatar)
                tvId.text = "Id: ${data.id}"
                tvEmail.text = "Email: ${data.email}"
                tvFirstName.text = "First name: ${data.firstName}"
                tvLastName.text = "Last name: ${data.lastName}"

                root.setOnClickListener {
                    onItemClicked(data)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GetUsersResponse.Data>() {
            override fun areItemsTheSame(oldItem: GetUsersResponse.Data, newItem: GetUsersResponse.Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GetUsersResponse.Data, newItem: GetUsersResponse.Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}