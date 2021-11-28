package com.example.mvvm_project_guardian.ui.view
import com.example.mvvm_project_guardian.data.model.Result
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_project_guardian.R

class NewsAdapter(
    private val context: Context,
    private val results: List<Result>?
    ): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results?.get(position)
        if (result != null) {
            holder.bind(result, context)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_new, parent, false))
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.tvNew) as TextView
        fun bind(result: Result, context: Context){
            title.text = result.webTitle
        }
    }

    override fun getItemCount(): Int {
        if (results != null) {
            return results.size
        }
        return 1
    }
}