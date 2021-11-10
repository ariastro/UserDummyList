package io.astronout.usersdummyapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.astronout.usersdummyapp.databinding.ActivityMainBinding
import io.astronout.usersdummyapp.ui.detail.DetailActivity
import io.astronout.usersdummyapp.utils.showToast
import io.astronout.usersdummyapp.vo.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        setupUI()
        viewModel.getUsers()
        observer()

    }

    private fun setupUI() {
        binding.rvUser.adapter = adapter
    }

    private fun setupAdapter() {
        adapter = UserAdapter {
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_USER, it)
            })
        }
    }

    private fun observer() {
        viewModel.users.observe(this) {
            when(it.status) {
                Status.SUCCESS -> {
                    val users = it.data?.data
                    Log.d("USERS", "observer: ${it.data?.data}")
                    adapter.submitList(users)
                }
                Status.ERROR -> {
                    showToast(it.message.toString())
                }
                Status.LOADING -> {

                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}