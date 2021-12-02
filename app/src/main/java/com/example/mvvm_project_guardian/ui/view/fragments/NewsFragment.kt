package com.example.mvvm_project_guardian.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.data.model.Result
import com.example.mvvm_project_guardian.ui.view.adapters.NewsPagedAdapter
import com.example.mvvm_project_guardian.ui.viewmodel.NewsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {
    private lateinit var recyclerNews: RecyclerView
    private var listener : (Result) -> Unit = {}
    private lateinit var nAdapter : NewsPagedAdapter
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerNews = view.findViewById(R.id.recyclerNews)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        loadingData()
    }

    fun setListener(l: (Result) ->Unit){
        listener = l
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener {
            view.findNavController().navigate(R.id.action_itemFragment_to_detailFragment, bundleOf("result" to it))
        }
    }

    private fun loadingData() {
        lifecycleScope.launch {
            newsViewModel.listData.collect { pagingData ->
                nAdapter.submitData(pagingData)
            }
        }
    }

    private fun initRecyclerView() {
        nAdapter = NewsPagedAdapter(listener)
        recyclerNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            adapter = nAdapter
        }
    }
}