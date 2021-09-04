package com.example.test1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

val apiKey:String = "24163948dd9155adff1bbec6f4ecac4b";

    private val fragmentRefreshListener = null


    private  lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private  lateinit var adaptor: PageAdaptor
private  var test =" NewYork";

   fun getMyData():String{
        println("aaa")
       return test
    }

    interface MyInterface {
        fun foo() {
            print("prop")
        }    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        var tab1 = findViewById<TabLayout.TabView>(R.id.tabItem1)
//        var tab2 = findViewById<TabLayout.TabView>(R.id.tabItem2)

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
            @SuppressLint("RestrictedApi")
            override fun onTabSelected(tab: TabLayout.Tab?) {

                val bundle0 = fr2.arguments;
                val cityNames = bundle0?.getString("cityNames")
                val cityInfo = bundle0?.getString("cityInfo")


//                Toast.makeText(applicationContext, tab?.position.toString(), Toast.LENGTH_SHORT).show()
                ////////////////////////////////////////

                //////////////////////////////////////////
//                fr1.onResume(){ println("a")}

                if (tab?.position == 0) {
                    val bundle = Bundle()
                    bundle.putString("d1", cityInfo)

                    fr1.arguments = bundle

                    if (cityNames != null && cityInfo != null) {
                        fr1.printer(cityNames, cityInfo)
//                        fr1 =Fragment1()
//                        adaptor.one = Fragment1();

//                        val fragment: Fragment1 = supportFragmentManager.fragments[0] as Fragment1
//                        supportFragmentManager.beginTransaction()
//                                .detach(fr1)
//                                .attach(fr1)
//                                .commit();

//                    var aaa =viewPager2.adapter
//                        aaa?.notifyDataSetChanged();//recreate()
                    }
//                    var frg: Fragment? = null
//                    frg = supportFragmentManager.findFragmentByTag("f0")
//                    val ft = supportFragmentManager.beginTransaction()
//                    ft.detach(frg!!)
//                    ft.attach(frg!!)
//                    ft.commit()
//                   adaptor.notifyDataSetChanged()
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
                        tab.text = "Status"
                    }
                    1 -> {
                        tab.text = "Cities"
                    }

                }
            }.attach()


        }


}



