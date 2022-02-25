package dev.matyaqubov.modul05exam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul05exam.R
import dev.matyaqubov.modul05exam.model.Category

class CategotyAdapter(var context: Context, var items:ArrayList<Category>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val  view= LayoutInflater.from(parent.context).inflate(R.layout.item_category_view,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var story=items[position]

        if (holder is CategoryViewHolder){
            holder.apply {
                iv_category.setImageResource(story.image)
                tv_name.text=story.desc
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view){
        var iv_category=view.findViewById<ImageView>(R.id.iv_categoty)
        var tv_name=view.findViewById<TextView>(R.id.tv_describtion)
    }
}