package dev.matyaqubov.modul05exam.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5exam.Home.Home
import dev.matyaqubov.modul05exam.R
import dev.matyaqubov.modul05exam.adapter.CollectionsAdapter

class CollectionsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return initViews(inflater.inflate(R.layout.fragment_collections, container, false))
    }

    fun initViews(view: View): View {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(requireContext(), 1))

        refreshAdapter(getAll())

       return view
    }

    fun refreshAdapter(chats: ArrayList<Home>) {
        val adapter = CollectionsAdapter(requireContext(), chats)
        recyclerView.adapter = adapter
    }

    fun getAll(): ArrayList<Home> {
        val items: ArrayList<Home> = ArrayList()
        items.add(Home(R.drawable.category, "Hotel"))
        items.add(Home(R.drawable.category, "Hotel"))
        items.add(Home(R.drawable.category, "Hotel"))
        items.add(Home(R.drawable.category, "Hotel"))
        items.add(Home(R.drawable.category, "Hotel"))
        items.add(Home(R.drawable.category, "Hotel"))

        return items
    }

}