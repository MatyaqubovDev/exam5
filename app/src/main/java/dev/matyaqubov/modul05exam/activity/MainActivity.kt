package dev.matyaqubov.modul05exam.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.matyaqubov.modul05exam.R
import dev.matyaqubov.modul05exam.fragment.CollectionsFragment
import dev.matyaqubov.modul05exam.fragment.HomeFragment
import dev.matyaqubov.modul05exam.fragment.MessageFragment
import dev.matyaqubov.modul05exam.fragment.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val homeFragment=HomeFragment()
        val collectionFragemnt=CollectionsFragment()
        val messageFragement=MessageFragment()
        val searchFragment=SearchFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->setCurrentFragment(homeFragment)
                R.id.collectionsFragment->setCurrentFragment(collectionFragemnt)
                R.id.messageFragment->setCurrentFragment(messageFragement)
                R.id.searchFragment->setCurrentFragment(searchFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}