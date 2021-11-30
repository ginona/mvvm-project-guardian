package com.example.mvvm_project_guardian.ui.view

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvm_project_guardian.data.model.Result

class DiffUtilCallback: DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }
}