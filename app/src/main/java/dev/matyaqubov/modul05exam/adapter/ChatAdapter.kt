package com.example.m5exam.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5exam.Home.Home
import com.google.android.material.imageview.ShapeableImageView
import dev.matyaqubov.modul05exam.R

class ChatAdapter(var context: Context, var items:ArrayList<Home>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val home = items[position]

        if (holder is ViewHolder){

            val iv_photo = holder.iv_photo
            val tv_text = holder.tv_text

            iv_photo.setImageResource(home.photo)
            tv_text.text = home.text


        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {

        val iv_photo: ShapeableImageView
        var tv_text: TextView

        init {
            iv_photo = view.findViewById(R.id.iv_photo)
            tv_text = view.findViewById(R.id.tv_text)
        }
    }

}