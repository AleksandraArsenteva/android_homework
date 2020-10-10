package com.example.homework1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout

class ElementsFactory {

    companion object {
        fun createTextView(context: Context): EditText {
            val lpView = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val tv = EditText(context)
            tv.layoutParams = lpView
            return tv
        }

        fun createButton(context: Context, parentLayout: LinearLayout?): View? {
            val inflater = LayoutInflater.from(context)
            val button = inflater.inflate(R.layout.custom_button, parentLayout, false)
            return button
        }
    }
}