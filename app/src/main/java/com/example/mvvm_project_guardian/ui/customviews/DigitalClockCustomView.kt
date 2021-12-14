package com.example.mvvm_project_guardian.ui.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.mvvm_project_guardian.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class DigitalClockCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    var dateFormat: String = "hh:mm"
    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.DigitalClockCustomView)
        dateFormat = a.getString(R.styleable.DigitalClockCustomView_dateFormat).toString()
        a.recycle()
        MainScope().launch {
            reloadTime()
        }
    }

    @SuppressLint("SimpleDateFormat")
    private suspend fun reloadTime() {
        val time = SimpleDateFormat(dateFormat)
        time.timeZone = TimeZone.getTimeZone("GMT-3")
        text = time.format(Date())
        delay(30000)
        text = time.format(Date())
        reloadTime()
    }
}