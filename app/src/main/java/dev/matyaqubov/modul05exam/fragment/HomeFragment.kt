package dev.matyaqubov.modul05exam.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.modul05exam.R
import dev.matyaqubov.modul05exam.adapter.CategotyAdapter
import dev.matyaqubov.modul05exam.adapter.FeedAdapter
import dev.matyaqubov.modul05exam.model.Category
import dev.matyaqubov.modul05exam.model.Feed
import dev.matyaqubov.modul05exam.model.Restaurant


class HomeFragment : Fragment() {
    private lateinit var recycler_View: RecyclerView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        return initViews(view)
    }

    private fun initViews(view: View): View {

        recycler_View=view.findViewById(R.id.recycler_view)
        recyclerView=view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recycler_View.layoutManager=GridLayoutManager(context,2)
        refreshAdapter(getAllFeeds())
        return view
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter= FeedAdapter(requireContext(),feeds)
        recycler_View.adapter=adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val stories=ArrayList<Category>()
        stories.add(Category(R.drawable.category,"Restaurant"))
        stories.add(Category(R.drawable.category,"CoffeShop"))
        stories.add(Category(R.drawable.category,"Shopping"))
        stories.add(Category(R.drawable.category,"Restaurant"))

        recyclerView.adapter=CategotyAdapter(requireContext(),stories)


        val feeds=ArrayList<Feed>()
        feeds.add(Feed(Restaurant(R.drawable.category,"Gami","CHorsu",5.0f)))
        feeds.add(Feed(Restaurant(R.drawable.category,"Gami","CHorsu",4.5f)))
        feeds.add(Feed(Restaurant(R.drawable.category,"Gami","CHorsu",3.5f)))
        feeds.add(Feed(Restaurant(R.drawable.category,"Gami","CHorsu",4.5f)))

        return feeds
    }

}