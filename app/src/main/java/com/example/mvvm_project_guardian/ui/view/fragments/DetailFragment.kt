package com.example.mvvm_project_guardian.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import com.example.mvvm_project_guardian.R
import com.example.mvvm_project_guardian.data.model.Result

class DetailFragment : Fragment() {
    private lateinit var tvNewTitle: TextView
    private lateinit var imgNew: ImageView
    private lateinit var tvDescription: TextView
    private  lateinit var result: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            result = bundle.getParcelable("result")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        tvNewTitle = view.findViewById(R.id.tvNewTitle)
        imgNew = view.findViewById(R.id.imgNew)
        tvDescription = view.findViewById(R.id.tvDescription)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNewTitle.text = result.webTitle
        imgNew.load(result.fields?.thumbnail)
        tvDescription.text = result.fields?.bodyText
    }
}