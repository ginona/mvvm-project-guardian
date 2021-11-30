package com.example.mvvm_project_guardian.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.databinding.ActivityMainBinding
import com.example.mvvm_project_guardian.ui.viewmodel.NewsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //private lateinit var recyclerNews: RecyclerView
    //private lateinit var mAdapter : NewsAdapter
    private lateinit var nAdapter : NewsPagedAdapter
    private lateinit var binding : ActivityMainBinding
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        //recyclerNews = findViewById(R.id.recyclerNews)

        initRecyclerView()
        loadingData()

        //no paging
        /*newsViewModel.onCreate(1)

        recyclerNews.layoutManager = LinearLayoutManager(applicationContext);
        mAdapter = NewsAdapter(applicationContext, newsViewModel.newsModel.value?.response?.results)
        recyclerNews.adapter = mAdapter

        newsViewModel.newsModel.observe(this, Observer { currentNew ->
            mAdapter = NewsAdapter(applicationContext, currentNew.response.results)
            recyclerNews.adapter = mAdapter
        })*/
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