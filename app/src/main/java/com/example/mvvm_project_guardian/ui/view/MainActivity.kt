package com.example.mvvm_project_guardian.ui.view

import com.example.mvvm_project_guardian.data.model.Result
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.ui.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerNews: RecyclerView
    private lateinit var mAdapter : NewsAdapter

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerNews = findViewById(R.id.recyclerNews)

        newsViewModel.onCreate()

        recyclerNews.layoutManager = LinearLayoutManager(applicationContext);
        mAdapter = NewsAdapter(applicationContext, newsViewModel.newsModel.value?.response?.results)
        recyclerNews.adapter = mAdapter

        newsViewModel.newsModel.observe(this, Observer { currentNew ->
            mAdapter = NewsAdapter(applicationContext, currentNew.response.results)
            recyclerNews.adapter = mAdapter
        })
    }
}