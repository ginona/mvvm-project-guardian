package com.example.mvvm_project_guardian.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.mvvm_project_guardian.data.model.Result
import com.example.mvvm_project_guardian.databinding.ItemNewBinding
import com.example.mvvm_project_guardian.ui.view.DiffUtilCallback


class NewsPagedAdapter(private val clickListener: (Result) -> Unit): PagingDataAdapter<Result, NewsPagedAdapter.MyViewHolder>(DiffUtilCallback()) {

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

        holder.itemView.setOnClickListener {
            if (currentItem != null) {
                clickListener(currentItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemNewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}