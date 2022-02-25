package dev.matyaqubov.modul05exam.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import dev.matyaqubov.modul05exam.R
import dev.matyaqubov.modul05exam.adapter.IntroPagerAdapter
import dev.matyaqubov.modul05exam.fragment.AddNewListingFragment
import dev.matyaqubov.modul05exam.fragment.ChatFragment
import dev.matyaqubov.modul05exam.fragment.GetNotificationFragment
import dev.matyaqubov.modul05exam.fragment.SavedListingsFragment
import dev.matyaqubov.modul05exam.managers.SharedPref

class IntroActivity : AppCompatActivity() ,ViewPager.OnPageChangeListener {
    private lateinit var viewPager: ViewPager
    private lateinit var tv_skip:TextView
    private lateinit var tv_next:TextView
    private lateinit var adapter: IntroPagerAdapter
    private lateinit var dots:DotsIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        check()
        initViews()
    }

    private fun check() {
        if (SharedPref(this).isSaved){
            Intent(this,MainActivity::class.java).also {
                finish()
                startActivity(it)
            }
        }
    }

    private fun initViews() {
        tv_skip=findViewById(R.id.tv_skip)
        tv_next=findViewById(R.id.tv_next)
        viewPager=findViewById(R.id.view_pager)
        dots=findViewById(R.id.dots)
        addFragment()
        viewPager.setOnPageChangeListener(this)
    }

    private fun addFragment() {
        adapter= IntroPagerAdapter(supportFragmentManager)
        adapter.add(SavedListingsFragment())
        adapter.add(AddNewListingFragment())
        adapter.add(ChatFragment())
        adapter.add(GetNotificationFragment())
        viewPager.adapter=adapter
        dots.setViewPager(viewPager)

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }



    override fun onPageSelected(position: Int) {

       when(position){
           0->{
               tv_next.setOnClickListener {
                   viewPager.currentItem = position+1
               }
               tv_skip.setOnClickListener {
                   viewPager.setCurrentItem(3,true)
               }
           }
           1->{
               tv_next.setOnClickListener {
                   viewPager.currentItem = position+1
               }
               tv_skip.setOnClickListener {
                   viewPager.setCurrentItem(3,true)
               }
           }
           2->{
               tv_next.setOnClickListener {
                   viewPager.currentItem = position+1
               }
               tv_skip.setOnClickListener {
                   viewPager.setCurrentItem(3,true)
               }
           }
           3->{
               tv_next.text="Done"
               tv_next.setOnClickListener {
                   SharedPref(this).isSaved=true
                   Intent(this, MainActivity::class.java).also {
                       startActivity(it)
                   }
               }
           }
       }

    }

    override fun onPageScrollStateChanged(state: Int) {

    }
}