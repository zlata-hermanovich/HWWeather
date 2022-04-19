package com.example.myweather.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myweather.R
import com.example.myweather.databinding.CustomViewBinding

class CustomView(context: Context?, attrs: AttributeSet?) : ConstraintLayout(context!!, attrs) {

    var binding: CustomViewBinding = CustomViewBinding.inflate(
        LayoutInflater.from(context), this
    )

    var onClickCustomView: (() -> Unit)? = null

    init {
        attrs?.let { setAttributes(it) }
        binding.buttonHour.setOnClickListener {
            onClickCustomView?.invoke()
        }
        binding.buttonDay.setOnClickListener {
            onClickCustomView?.invoke()
        }
    }

    private fun setAttributes(attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0)
        try {
            binding.buttonHour.text = ta.getString(R.styleable.CustomView_buttonHour)
            binding.buttonDay.text = ta.getString(R.styleable.CustomView_buttonDay)
        } finally {
            ta.recycle()
        }
    }
}