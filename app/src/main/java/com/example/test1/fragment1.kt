package com.example.test1

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.tabs.TabItem
import java.util.*
import kotlin.math.roundToInt


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
public var axxx = "XXXX"

class Fragment1 : Fragment() {


    fun getDataFromFragmentOne(item: String?) {
        // Do the mannipulation
    }
    // TODO: Rename and change types of parameters
    public var cityNameParam: String? = "C name"
    public var cityInfoParam: String? = "C info"

//    private var param2: String? = null

    fun printer(cityName: String, cityInfo: String){
        
        cityNameParam = cityName
        cityInfoParam = cityInfo
        view?.findViewById<TextView>(R.id.textViewLocation)?.text = cityNameParam.toString()
//        Toast.makeText(requireContext(), a + "-----" + this.arguments.toString(), Toast.LENGTH_SHORT).show()

        Toast.makeText(requireContext(), cityInfo + cityNameParam, Toast.LENGTH_SHORT).show()

//        ((MainActivity) getActivity()).getSomeDataFromActivity()

this.onResume()
//       Fr.beginTransaction()?.detach(this)?.attach(this)?.commit();

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onCreateView(


            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        println("-----------------");
        Toast.makeText(requireContext(), "Started", Toast.LENGTH_SHORT).show()
        val activity: MainActivity? = activity as MainActivity?

        val view:View = inflater.inflate(R.layout.fragment_1, container, false)
        //////////**********************************************----------------------------------------------------------


        Toast.makeText(requireContext(), this.tag.toString(), Toast.LENGTH_SHORT).show()
        val locationTXT = view.findViewById<TextView>(R.id.textViewLocation);
        val SubtextView2 = view.findViewById<TextView>(R.id.SubtextView2);


        val bundle0 = this.arguments;
        val mm = bundle0?.getString("d1")
//

        locationTXT.text =mm.toString();

        val myDataFromActivity: String? = activity?.getMyData();

//        locationTXT.text =cityNameParam
        locationTXT.text = myDataFromActivity

////
//        val bundle = this.arguments
//       val z = bundle?.getString("data1")
//        if (bundle != null) {
//            locationTXT.text = z.toString()
//        }


        val day1C =view.findViewById<ConstraintLayout>(R.id.Day1Constraint)
        val day2C = view.findViewById<ConstraintLayout>(R.id.Day2Constraint)
        val day3C = view.findViewById<ConstraintLayout>(R.id.Day3Constraint)
        val day4C = view.findViewById<ConstraintLayout>(R.id.Day4Constraint)



        val text = view.findViewById<TextView>(R.id.MainTemperatureTXT);

        val textTempD1 = view.findViewById<TextView>(R.id.D1smallTempTXT);
        val textTempD2 = view.findViewById<TextView>(R.id.D2smallTempTXT);
        val textTempD3 = view.findViewById<TextView>(R.id.D3smallTempTXT);
        val textTempD4 = view.findViewById<TextView>(R.id.D4smallTempTXT);

        val d1textViewDate = view.findViewById<TextView>(R.id.D1textViewDate);
        val d2textViewDate = view.findViewById<TextView>(R.id.D2textViewDate);
        val d3textViewDate = view.findViewById<TextView>(R.id.D3textViewDate);
        val d4textViewDate = view.findViewById<TextView>(R.id.D4textViewDate);

        val mainDayTXT = view.findViewById<TextView>(R.id.MainDayTXT);
        val maxTXT = view.findViewById<TextView>(R.id.MaxTXT);
        val minTXT =view. findViewById<TextView>(R.id.MinTXT);
        val mainStatusIMG = view.findViewById<ImageView>(R.id.StatusIMG);

        val d1StatusIMG = view.findViewById<ImageView>(R.id.D1imageView);
        val d2StatusIMG = view.findViewById<ImageView>(R.id.D2imageView);
        val d3StatusIMG = view.findViewById<ImageView>(R.id.D3imageView);
        val d4StatusIMG = view.findViewById<ImageView>(R.id.D4imageView);

        val tabItem1 = view.findViewById<TabItem>(R.id.tabItem1);
        val tabItem2 = view.findViewById<TabItem>(R.id.tabItem2);






        var selected =1;

//        val  myFragmentAdaptor1= PageAdaptor(supportFragmentManager);
//        findViewById<ViewPager>(R.id.viewPager).adapter = myFragmentAdaptor1;
//        myViewPager.adapter = myFragmentAdaptor1;
//        val tabView = findViewById<TabLayout>(R.id.tabLayout)
//
//        tabView.setupWithViewPager(myViewPager)

        var temps   = mutableListOf<Int>()
        var minTemps   =  mutableListOf<Int>()
        var maxTemps   = mutableListOf<Int>()
        var statusTemps   =mutableListOf<String>()
        var descriptionTemps   = mutableListOf<String>()
//        var datesTemps   = arrayOfNulls<String>(4);
        val datesTemps = mutableListOf<String>()


        fun dateConverter(rawData: String): String{
            val convertedTime = Date(rawData.toInt() * 1000L)
            val res = convertedTime.toString().slice(0..3)
            return (res);
        }
        fun iconSelector(index: Int, element: ImageView){
            when(statusTemps[index]){
                "Clear" -> element.setImageResource(R.drawable.ic_clear);
                "Clouds" -> element.setImageResource(R.drawable.ic_clouds);
                "Snow" -> element.setImageResource(R.drawable.ic_snow);
                "Rain" -> element.setImageResource(R.drawable.ic_rain);
                "Drizzle" -> element.setImageResource(R.drawable.ic_drizzle);
                "Thunderstorm" -> element.setImageResource(R.drawable.ic_thunderstorm);

            }
        }
        fun colorChange(index: Int){
            text.text = temps[index].toString() + "??";
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
            iconSelector(index, mainStatusIMG);
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
        //****************************************
//        val bundle = this.arguments
//        val myInt = bundle?.getString("str");
//        Toast.makeText(requireContext(), myInt, Toast.LENGTH_SHORT).show()
//        LocationTXT.text = myInt.toString();


        fun a(){
//     val url = "http://api.openweathermap.org/data/2.5/forecast?q=Los%20Angeles&appid=24163948dd9155adff1bbec6f4ecac4b&cnt=5&units=metric";
            val url =   "http://api.openweathermap.org/data/2.5/onecall?lat=${cityInfo.split(",")[0]}&lon=${cityInfo.split(",")[1]}&exclude=minutely,hourly&appid=24163948dd9155adff1bbec6f4ecac4b&cnt=5&units=metric"
            val que = Volley.newRequestQueue(this.context);

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

                            datesTemps.add(response.getJSONArray("daily").getJSONObject(i)["dt"].toString());

                        }

//                 Toast.makeText(this,dateConverter(datesTemps[1].toString())  , Toast.LENGTH_SHORT).show()

//                 text.text = temps[0].toString() + "??";

                        textTempD1.text = temps[0].toString() + "??";
                        textTempD2.text = temps[1].toString() + "??";
                        textTempD3.text = temps[2].toString() + "??";
                        textTempD4.text = temps[3].toString() + "??";

                        d1textViewDate.text = dateConverter(datesTemps[0]);
                        d2textViewDate.text = dateConverter(datesTemps[1]);
                        d3textViewDate.text = dateConverter(datesTemps[2]);
                        d4textViewDate.text = dateConverter(datesTemps[3]);


                        iconSelector(0, d1StatusIMG);
                        iconSelector(1, d2StatusIMG);
                        iconSelector(2, d3StatusIMG);
                        iconSelector(3, d4StatusIMG);


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
        tabItem1?.setOnClickListener(){

        }


//////////////////---------------------------------------------------------------------------------
        return view
    }


}


