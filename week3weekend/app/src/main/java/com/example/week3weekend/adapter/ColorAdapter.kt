package com.example.week3weekend.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week3weekend.R
import com.example.week3weekend.model.Hue
import com.example.week3weekend.view.MainActivity
import com.example.week3weekend.view.NoteActivity
import android.content.Intent
import android.util.Log


class ColorAdapter (private val colorList: List<Hue>):
    RecyclerView.Adapter<ColorAdapter.MyCustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.color_layout, parent, false)

        return MyCustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        holder.apply {
            colorNameTextView.text = colorList[position].name
            if (colorNameTextView.text == "Red") {
                colorNameTextView.setBackgroundColor(Color.RED)
            } else if (colorNameTextView.text == "Blue") {
                colorNameTextView.setBackgroundColor(Color.BLUE)
            } else if (colorNameTextView.text == "Yellow") {
                colorNameTextView.setBackgroundColor(Color.YELLOW)
            } else if (colorNameTextView.text == "Green") {
                colorNameTextView.setBackgroundColor(Color.GREEN)
            } else if (colorNameTextView.text == "Orange") {
                colorNameTextView.setBackgroundColor(Color.parseColor("#FFA500"))
            } else if (colorNameTextView.text == "Purple") {
                colorNameTextView.setBackgroundColor(Color.parseColor("#5E00F8"))
            } else if (colorNameTextView.text == "Brown") {
                colorNameTextView.setBackgroundColor(Color.parseColor("#854B04"))
            } else if (colorNameTextView.text == "Black") {
                colorNameTextView.setBackgroundColor(Color.parseColor("#000000"))
                colorNameTextView.setTextColor(Color.parseColor("#FFFFFF"))
            }



            holder.itemView.setOnClickListener {

                var intent = Intent(it.context, NoteActivity::class.java)
                Log.d("Color", colorNameTextView.text.toString())
                MainActivity.editor.putString("Color", colorNameTextView.text.toString())
                MainActivity.editor.commit()
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    inner class MyCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorNameTextView = itemView.findViewById<TextView>(R.id.color_textview)
    }
}
