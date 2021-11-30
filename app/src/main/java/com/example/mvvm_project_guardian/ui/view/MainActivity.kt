package com.example.mvvm_project_guardian.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_project_guardian.databinding.ActivityMainBinding
import com.example.mvvm_project_guardian.ui.viewmodel.NewsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var nAdapter : NewsPagedAdapter
    private lateinit var binding : ActivityMainBinding
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        loadingData()
    }

    private fun loadingData() {
        lifecycleScope.launch {
            newsViewModel.listData.collect { pagingData ->
                nAdapter.submitData(pagingData)
            }
        }
    }

    private fun initRecyclerView() {
        nAdapter = NewsPagedAdapter()
        binding.recyclerNews.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = nAdapter
        }
    }

}