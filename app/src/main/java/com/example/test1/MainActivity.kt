package com.example.test1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

val apiKey:String = "24163948dd9155adff1bbec6f4ecac4b";

    private  lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private  lateinit var adaptor: PageAdaptor

    interface MyInterface {
        fun foo() {
            print("prop")
        }    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var tab1 = findViewById<TabLayout.TabView>(R.id.tabItem1)
        var tab2 = findViewById<TabLayout.TabView>(R.id.tabItem2)

        var valueT = "no"
//
//        tab1.setOnClickListener(){
////            valueT = "*1*"
//        }
//        tab2.setOnClickListener(){
//            valueT = "*2*"
//        }



        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

       var fr1 = Fragment1();
        var fr2 = Fragment2();


        tabLayout =findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viewPager2id)
        adaptor = PageAdaptor(supportFragmentManager, lifecycle, fr1, fr2)
        viewPager2.adapter = adaptor

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                val bundle0 = fr2.arguments;
                val cityNames = bundle0?.getString("cityNames")
                val cityInfo = bundle0?.getString("cityInfo")


                Toast.makeText(applicationContext, cityInfo + cityNames, Toast.LENGTH_SHORT).show()
                ////////////////////////////////////////

//                val bundle = Bundle()
//                bundle.putString("d1", res)
//
//                fr1.arguments = bundle
                //////////////////////////////////////////
    if (tab?.position==1){
        if (cityNames != null && cityInfo != null) {
                fr1.printer(cityNames,cityInfo)
        }

}




            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = valueT
                    }
                    1 -> {
                        tab.text = valueT
                    }

                }
            }.attach()


        }


}

