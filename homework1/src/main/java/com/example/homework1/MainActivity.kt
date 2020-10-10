package com.example.homework1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.homework1.ElementsFactory.Companion.createButton
import com.example.homework1.ElementsFactory.Companion.createTextView


class MainActivity : AppCompatActivity() {

    var listLayout : LinearLayout? = null
    val TAG = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainLayout = LinearLayout(this)
        mainLayout.orientation = LinearLayout.VERTICAL
        mainLayout.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )

        val toolbar = Toolbar(this)
        toolbar.title = "Homework"
        toolbar.setBackgroundColor(Color.BLUE)
        mainLayout.addView(toolbar)
        setSupportActionBar(toolbar)

        val scroll = ScrollView(this)
        scroll.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        mainLayout.addView(scroll)

        listLayout = LinearLayout(this)
        listLayout!!.orientation = LinearLayout.VERTICAL
        listLayout!!.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        scroll.addView(listLayout, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

        setContentView(mainLayout)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.createButton -> {
                val button = createButton(this, listLayout)
                listLayout?.addView(button)
                Log.d(TAG, "Button added")
            }
            R.id.createText -> {
                val textView = createTextView(this)
                listLayout?.addView(textView)
                Log.d(TAG, "Textview added")
            }
            R.id.clear -> {
                listLayout?.removeAllViews()
                Log.d(TAG, "View cleaned")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}