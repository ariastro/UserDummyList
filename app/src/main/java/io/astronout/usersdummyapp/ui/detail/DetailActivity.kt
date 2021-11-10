package io.astronout.usersdummyapp.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import io.astronout.usersdummyapp.R
import io.astronout.usersdummyapp.data.source.remote.response.GetUsersResponse
import io.astronout.usersdummyapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var user: GetUsersResponse.Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUserDetail()

    }

    @SuppressLint("SetTextI18n")
    private fun setUserDetail() {
        user = intent.getParcelableExtra(EXTRA_USER) ?: GetUsersResponse.Data()
        Glide.with(this)
            .load(user.avatar)
            .into(binding.imgAvatar)
        binding.tvId.text = "Id: ${user.id}"
        binding.tvEmail.text = "Email: ${user.email}"
        binding.tvFirstName.text = "Id: ${user.firstName}"
        binding.tvLastName.text = "Id: ${user.lastName}"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }

}