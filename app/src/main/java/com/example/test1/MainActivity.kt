package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

val apiKey:String = "24163948dd9155adff1bbec6f4ecac4b";

    private  lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private  lateinit var adaptor: PageAdaptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        tabLayout =findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2id)
        adaptor = PageAdaptor(supportFragmentManager,lifecycle)
        viewPager2.adapter = adaptor
        TabLayoutMediator(tabLayout, viewPager2){ tab, position-> when(position){
            0->{tab.text = "0"}
            1->{tab.text = "1"}

        }
        }.attach()


    }


}

