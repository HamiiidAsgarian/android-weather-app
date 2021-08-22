package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

val apiKey:String = "24163948dd9155adff1bbec6f4ecac4b";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val day1C = findViewById<ConstraintLayout>(R.id.Day1Constraint)
        val day2C = findViewById<ConstraintLayout>(R.id.Day2Constraint)
        val day3C = findViewById<ConstraintLayout>(R.id.Day3Constraint)
        val day4C = findViewById<ConstraintLayout>(R.id.Day4Constraint)


        val text = findViewById<TextView>(R.id.MainTemperatureTXT);

        val textTempD1 = findViewById<TextView>(R.id.D1smallTempTXT);
        val textTempD2 = findViewById<TextView>(R.id.D2smallTempTXT);
        val textTempD3 = findViewById<TextView>(R.id.D3smallTempTXT);
        val textTempD4 = findViewById<TextView>(R.id.D4smallTempTXT);

        val D1textViewDate = findViewById<TextView>(R.id.D1smallTempTXT);
        val D2textViewDate = findViewById<TextView>(R.id.D2smallTempTXT);
        val D3textViewDate = findViewById<TextView>(R.id.D3smallTempTXT);
        val D4textViewDate = findViewById<TextView>(R.id.D4smallTempTXT);


        var selected =1;

//        var widgets   = arrayOfNulls<TextView>(4);

//        val tvIds = intArrayOf(
//            R.id.D1smallTempTXT,
//            R.id.D2smallTempTXT,
//            R.id.D3smallTempTXT,
//            R.id.D4smallTempTXT
//        );

//        val textViews = ArrayList<TextView>(4)

        var temps   = arrayOfNulls<Int>(4)
        var minTemps   = arrayOfNulls<Int>(4)
        var maxTemps   = arrayOfNulls<Int>(4);
        var statusTemps   = arrayOfNulls<String>(4);
        var descriptionTemps   = arrayOfNulls<String>(4);
        var datesTemps   = arrayOfNulls<String>(4);



//        minTemps = [1,2,3]


fun colorChange(){
    day1C.setBackgroundColor(Color.parseColor("#B8FFF6"));
      day2C.setBackgroundColor(Color.parseColor("#B8FFF6"));
    day3C.setBackgroundColor(Color.parseColor("#B8FFF6"));
    day4C.setBackgroundColor(Color.parseColor("#B8FFF6"));
    when (selected) {
        1 -> day1C.setBackgroundColor(Color.parseColor("#FF42CDBC"));
        2 -> day2C.setBackgroundColor(Color.parseColor("#FF42CDBC"));
        3 -> day3C.setBackgroundColor(Color.parseColor("#FF42CDBC"));
        4 -> day4C.setBackgroundColor(Color.parseColor("#FF42CDBC"));
    }
}
        fun a(){
     val url = "http://api.openweathermap.org/data/2.5/forecast?q=New%20York&appid=24163948dd9155adff1bbec6f4ecac4b&cnt=5"
     val que = Volley.newRequestQueue(this@MainActivity)

     val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
         { response ->
             for (i in 1..4) {
                 temps.set(
                     i - 1, response.getJSONArray("list").getJSONObject(i)
                         .getJSONObject("main")["temp"].toString().toDouble().roundToInt() / 10
                 );
                 maxTemps.toMutableList().add(
                     i - 1, response.getJSONArray("list").getJSONObject(i)
                         .getJSONObject("main")["temp_max"].toString().toDouble().roundToInt() / 10
                 )
                 minTemps.toMutableList().add(
                     i - 1, response.getJSONArray("list").getJSONObject(i)
                         .getJSONObject("main")["temp_min"].toString().toDouble().roundToInt() / 10
                 );
                 statusTemps.toMutableList().add(
                     i - 1, response.getJSONArray("list").getJSONObject(i)
                         .getJSONArray("weather").getJSONObject(0)["main"].toString()
                 );
                 descriptionTemps.toMutableList().add(
                     i - 1, response.getJSONArray("list").getJSONObject(i)
                         .getJSONArray("weather").getJSONObject(0)["description"].toString()
                 );
                 datesTemps.toMutableList().add(
                     i - 1, response.getJSONArray("list").getJSONObject(i)["dt_txt"].toString());

             }
//             val temp = response.getJSONArray("list").getJSONObject(id)
//                 .getJSONObject("main")["temp"].toString().toDouble().roundToInt()/10 ;
//             text.text = temp.toString()+"°"

             text.text = temps[0].toString() + "°";////
             textTempD1.text = temps[0].toString();
             textTempD2.text = temps[1].toString();
             textTempD3.text = temps[2].toString();
             textTempD4.text = temps[3].toString();

             val strs = datesTemps[0]?.split("", ignoreCase = false, limit = 5)?.last();
             val strs2 = "datesTemps[1]?".split("", ignoreCase = true, limit = 2).last();
             val strs3 = datesTemps[2]?.slice(5..10); //here
             val strs4 = datesTemps[3]?.split("", ignoreCase = true, limit = 5)?.last();

             D1textViewDate.text = strs;
             D2textViewDate.text = strs2;
             D3textViewDate.text = strs3;
             D4textViewDate.text = strs4;




//             val temp1 = response.getJSONArray("list").getJSONObject(1)
//                 .getJSONObject("main")["temp"].toString().toDouble().roundToInt()/10 ;
//             textTempD1.text = temp1.toString()+"°"
//             val temp2 = response.getJSONArray("list").getJSONObject(2)
//                 .getJSONObject("main")["temp"].toString().toDouble().roundToInt()/10 ;
//             textTempD2.text = temp2.toString()+"°"
//             val temp3 = response.getJSONArray("list").getJSONObject(3)
//                 .getJSONObject("main")["temp"].toString().toDouble().roundToInt()/10 ;
//             textTempD3.text = temp3.toString()+"°"
//             val temp4 = response.getJSONArray("list").getJSONObject(4)
//                 .getJSONObject("main")["temp"].toString().toDouble().roundToInt()/10 ;
//             textTempD4.text = temp4.toString()+"°"


         },
         { error ->
             println(error);
//             text.text = "Response: %s".format(error.toString())
         }
     )
     que.add(jsonObjectRequest);
 }//end function

        a()
        colorChange();


        day1C?.setOnClickListener(){
            selected=1;
            colorChange();
        }
        day2C?.setOnClickListener(){
            selected=2;
            colorChange();
        }
        day3C?.setOnClickListener(){
            selected=3;
            colorChange();
        }
        day4C?.setOnClickListener(){
            selected=4;
            colorChange();
        }



    }


}

