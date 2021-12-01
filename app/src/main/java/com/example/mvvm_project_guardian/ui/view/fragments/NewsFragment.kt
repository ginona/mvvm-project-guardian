package com.example.mvvm_project_guardian.ui.view.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.data.model.Result
import com.example.mvvm_project_guardian.databinding.FragmentNewsBinding
import com.example.mvvm_project_guardian.ui.view.adapters.NewsPagedAdapter
import com.example.mvvm_project_guardian.ui.viewmodel.NewsViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {
    private lateinit var recyclerNews: RecyclerView
    private var listener : (Result) -> Unit = {}
    private lateinit var nAdapter : NewsPagedAdapter
    private val newsViewModel: NewsViewModel by viewModels()
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerNews = view.findViewById(R.id.recyclerNews)
        return view
        /*_binding = FragmentNewsBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root*/
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //recyclerNews = _binding?.recyclerNews as RecyclerView
        initRecyclerView()
        loadingData()
    }

    fun setListener(l: (Result) ->Unit){
        listener = l
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity: Activity = requireActivity()
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
            adapter = nAdapter
        }
    }

}