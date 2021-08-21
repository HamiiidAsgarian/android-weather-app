package com.example.test1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

val apiKey:String = "24163948dd9155adff1bbec6f4ecac4b";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button0)
        val text = findViewById<TextView>(R.id.txt1);


        val url = "http://api.openweathermap.org/data/2.5/forecast?q=New%20York&appid=24163948dd9155adff1bbec6f4ecac4b&cnt=3"
        val arr = arrayListOf<String>()

        button?.setOnClickListener(){
            val que = Volley.newRequestQueue(this@MainActivity)

            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                    { response ->
                        val a  = response.getJSONArray("list").getJSONObject(1).getJSONObject("main")["temp"].toString().toFloat()/10;

                        text.text = "%.2f".format(a.toDouble())
                    },
                    { error ->
                        println(error);
                        text.text = "Response: %s".format(error.toString())
                    }
            )
            que.add(jsonObjectRequest);
        }


    }


}

