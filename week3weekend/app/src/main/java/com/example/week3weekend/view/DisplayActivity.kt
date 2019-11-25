package com.example.week3weekend.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3weekend.R
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var note: String? = MainActivity.sharedPreferences.getString("Note", "")
        var color: String? = MainActivity.sharedPreferences.getString("Color", "")

        notedisplay_textview.text = note
        if(color == "Red"){
            notedisplay_textview.setTextColor(Color.RED)
        }else if (color == "Blue")
        {
            notedisplay_textview.setTextColor(Color.BLUE)
        }else if (color == "Yellow")
        {
            notedisplay_textview.setTextColor(Color.YELLOW)
        }else if (color == "Green")
        {
            notedisplay_textview.setTextColor(Color.GREEN)
        }else if (color == "Orange")
        {
            notedisplay_textview.setTextColor(Color.parseColor("#FFA500"))
        }else if (color == "Purple")
        {
            notedisplay_textview.setTextColor(Color.parseColor("#5E00F8"))
        }else if (color == "Brown")
        {
            notedisplay_textview.setTextColor(Color.parseColor("#854B04"))
        }else if (color == "Black")
        {
            notedisplay_textview.setTextColor(Color.BLACK)
        }
    }
}
