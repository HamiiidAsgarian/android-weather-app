package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.util.*
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

        val d1textViewDate = findViewById<TextView>(R.id.D1textViewDate);
        val d2textViewDate = findViewById<TextView>(R.id.D2textViewDate);
        val d3textViewDate = findViewById<TextView>(R.id.D3textViewDate);
        val d4textViewDate = findViewById<TextView>(R.id.D4textViewDate);

        val mainDayTXT = findViewById<TextView>(R.id.MainDayTXT);
        val maxTXT = findViewById<TextView>(R.id.MaxTXT);
        val minTXT = findViewById<TextView>(R.id.MinTXT);
        val mainStatusIMG = findViewById<ImageView>(R.id.StatusIMG);



        var selected =1;

        var temps   = mutableListOf<Int>()
        var minTemps   =  mutableListOf<Int>()
        var maxTemps   = mutableListOf<Int>()
        var statusTemps   =mutableListOf<String>()
        var descriptionTemps   = mutableListOf<String>()
//        var datesTemps   = arrayOfNulls<String>(4);
        val datesTemps = mutableListOf<String>()


        fun dateConverter( rawData:String): String{
            val convertedTime = Date(rawData.toInt() * 1000L)
            val res = convertedTime.toString().slice(0..3)
            return (res);
        }
        fun iconSelector(index:Int,element:ImageView){
            when(statusTemps[index]){
                "Clear" -> element.setImageResource(R.drawable.ic_clear);
                "Clouds" ->element.setImageResource(R.drawable.ic_clouds);
                "Snow" ->element.setImageResource(R.drawable.ic_snow);
                "Rain" ->element.setImageResource(R.drawable.ic_rain);
                "Drizzle" ->element.setImageResource(R.drawable.ic_drizzle);
                "Thunderstorm" ->element.setImageResource(R.drawable.ic_thunderstorm);

            }
        }
fun colorChange(index:Int){
     text.text = temps[index].toString() + "°";
     mainDayTXT.text = dateConverter(datesTemps[index]);
     maxTXT.text =maxTemps[index].toString();
     minTXT.text = minTemps[index].toString();
//    Toast.makeText(this, minTemps[1], Toast.LENGTH_SHORT).show()
//    println(temps[index]);
//    Toast.makeText(this, temps[index], Toast.LENGTH_SHORT).show()

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
    iconSelector(index,mainStatusIMG);
//    when(statusTemps[index]){
//        "Clear" -> mainStatusIMG.setImageResource(R.drawable.ic_clear);
//        "Clouds" ->mainStatusIMG.setImageResource(R.drawable.ic_clouds);
//        "Snow" ->mainStatusIMG.setImageResource(R.drawable.ic_snow);
//        "Rain" ->mainStatusIMG.setImageResource(R.drawable.ic_rain);
//        "Drizzle" ->mainStatusIMG.setImageResource(R.drawable.ic_drizzle);
//        "Thunderstorm" ->mainStatusIMG.setImageResource(R.drawable.ic_thunderstorm);
//
//    }
}


        fun a(){
//     val url = "http://api.openweathermap.org/data/2.5/forecast?q=Los%20Angeles&appid=24163948dd9155adff1bbec6f4ecac4b&cnt=5&units=metric";
            val url =   "http://api.openweathermap.org/data/2.5/onecall?lat=33.44&lon=-94.04&exclude=minutely,hourly&appid=24163948dd9155adff1bbec6f4ecac4b&cnt=5&units=metric"
     val que = Volley.newRequestQueue(this@MainActivity);

     val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
             { response ->
                 for (i in 0..3) {

                     temps.add(
                              response.getJSONArray("daily").getJSONObject(i).getJSONObject("temp")["day"].toString().toDouble().roundToInt()
                     );
                     maxTemps.add(
                              response.getJSONArray("daily").getJSONObject(i).getJSONObject("temp")["max"].toString().toDouble().roundToInt()
                     )
                     minTemps.add(
                             response.getJSONArray("daily").getJSONObject(i).getJSONObject("temp")["min"].toString().toDouble().roundToInt()
                     );
                     statusTemps.add(
                              response.getJSONArray("daily").getJSONObject(i).getJSONArray("weather").getJSONObject(0)["main"].toString()
                     );
                     descriptionTemps.add(
                              response.getJSONArray("daily").getJSONObject(i).getJSONArray("weather").getJSONObject(0)["description"].toString()
                     );

                     datesTemps.add( response.getJSONArray("daily").getJSONObject(i)["dt"].toString());

                 }

//                 Toast.makeText(this,dateConverter(datesTemps[1].toString())  , Toast.LENGTH_SHORT).show()

//                 text.text = temps[0].toString() + "°";
                 textTempD1.text = temps[0].toString() + "°";
                 textTempD2.text = temps[1].toString() + "°";
                 textTempD3.text = temps[2].toString() + "°";
                 textTempD4.text = temps[3].toString() + "°";

                 d1textViewDate.text = dateConverter(datesTemps[0]);
                 d2textViewDate.text = dateConverter(datesTemps[1]);
                 d3textViewDate.text = dateConverter(datesTemps[2]);
                 d4textViewDate.text = dateConverter(datesTemps[3]);



                 colorChange(0);


             },
             { error ->
                 println("err333333333333333333333333or");
                 println(error)
//             text.text = "Response: %s".format(error.toString())
             }
     )
     que.add(jsonObjectRequest);
 }//end function

        a();
//        colorChange(1);


        day1C?.setOnClickListener(){
            selected=1;
            colorChange(0);
        }
        day2C?.setOnClickListener(){
            selected=2;
            colorChange(1);
        }
        day3C?.setOnClickListener(){
            selected=3;
            colorChange(2);
        }
        day4C?.setOnClickListener(){
            selected=4;
            colorChange(3);
        }



    }


}

