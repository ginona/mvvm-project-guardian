package com.example.mvvm_project_guardian.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.data.model.Result
import com.example.mvvm_project_guardian.databinding.ActivityMainBinding
import com.example.mvvm_project_guardian.databinding.ItemNewBinding


class NewsPagedAdapter: PagingDataAdapter<Result, NewsPagedAdapter.MyViewHolder>(DiffUtilCallback()) {

    /*inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.tvNew) as TextView
        val image = view.findViewById<ImageView>(R.id.imgNew)
        fun bind(result: Result){
            title.text = result.webTitle
            image.load(result.fields?.thumbnail)
        }
    }*/

    //Direct bind to the exact xml
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
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(ItemNewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}