package com.example.mvvm_project_guardian.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.mvvm_project_guardian.data.model.Result
import com.example.mvvm_project_guardian.databinding.ItemNewBinding


class NewsPagedAdapter: PagingDataAdapter<Result, NewsPagedAdapter.MyViewHolder>(DiffUtilCallback()) {

    inner class MyViewHolder(val binding: ItemNewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvNew.text = "${currentItem?.webTitle}"
            val imageLink = currentItem?.fields?.thumbnail

            imgNew.load(imageLink) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemNewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}