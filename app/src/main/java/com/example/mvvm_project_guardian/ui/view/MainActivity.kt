package com.example.mvvm_project_guardian.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvm_project_guardian.BuildConfig.DEBUG
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.ui.viewmodel.NewsViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var testing_title: TextView
    private lateinit var buttonTest: Button
    private lateinit var listView : ListView

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testing_title = findViewById(R.id.testing)
        buttonTest = findViewById(R.id.button)
        listView = findViewById(R.id.listView)

        newsViewModel.onCreate()

        newsViewModel.newsModel.observe(this, Observer { currentNew ->
            testing_title.text = currentNew.response.userTier
        })

        buttonTest.setOnClickListener {
            newsViewModel.getNews()
        }
    }
}