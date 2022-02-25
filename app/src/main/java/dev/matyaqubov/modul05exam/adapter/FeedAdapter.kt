package dev.matyaqubov.modul05exam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul05exam.R
import dev.matyaqubov.modul05exam.model.Category
import dev.matyaqubov.modul05exam.model.Feed

class FeedAdapter(var context: Context , var items:ArrayList<Feed>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val TYPE_ITEM_STORY = 0
        private val TYPE_ITEM_RESTAURANT = 1

    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].category.size > 0) {
            return TYPE_ITEM_STORY
        } else {
            return TYPE_ITEM_RESTAURANT
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_category, parent, false)
            return CallectionViewHolder(context, view)
        }
        return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_restaurants_view,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]
        if (holder is CallectionViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(feed.category, recyclerView)
        }
        if (holder is RestaurantViewHolder) {
            holder.apply {
                image.setImageResource(feed.restaurant!!.image)
                describtion.text=feed.restaurant!!.desc
                name.text=feed.restaurant!!.name
                stars.rating=feed.restaurant!!.rating
            }
        }


    }

    override fun getItemCount(): Int {
        return  items.size
    }


    private fun refreshAdapter(stories: ArrayList<Category>, recyclerView: RecyclerView) {
        val adapter = CategotyAdapter(context, stories)
        recyclerView.adapter = adapter
    }


    class CallectionViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        init {
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class RestaurantViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image=view.findViewById<ImageView>(R.id.img_food)
        val name=view.findViewById<TextView>(R.id.tv_foodname)
        val stars=view.findViewById<RatingBar>(R.id.rating)
        val describtion=view.findViewById<TextView>(R.id.tv_describtion)
    }
}