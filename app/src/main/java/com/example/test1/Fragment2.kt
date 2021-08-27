package com.example.test1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 *
 */

// list to populate list view
// initialize an array adapter
public  var cityName ="London";
public  var cityInfo = "51.36,00.05";

class Fragment2 : Fragment() {

    fun getDataFromFragmentTwo(item: String?) {
       println("salam from 2 vs $item");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        println("xxxxxxxxxxxxxxxxxxxxxxx");
        var view = inflater.inflate(R.layout.fragment_2, container, false);
        var ListView1 = view.findViewById<ListView>(R.id.ListView1)

        val numbersMap = TreeMap<String, String>()
        numbersMap["Tehran"] = "35.44,51.30"
        numbersMap["Ottawa"] = "45.27,51.30"
        numbersMap["Washington DC"] = "39.91,77.02"
        numbersMap["London"] = "51.36,00.05"
        numbersMap["Stockholm"] = "59.20,18.03"

        var name= mutableListOf<String>()
        var info= mutableListOf<String>();

        for (e in numbersMap){
            name.add(e.key);
            info.add(e.value);
        }

        val itemsAdapter: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, name)
//var btn = view.findViewById<Button>(R.id.btnn)

        // attach the array adapter with list view
        ListView1.adapter = itemsAdapter

        // list view item click listener
        ListView1.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            val selectedItem = parent.getItemAtPosition(position)
//            itemsAdapter.add(name[position])
//            Toast.makeText(requireContext(),this.tag, Toast.LENGTH_SHORT).show()

            val bundle = Bundle()
            val cityNames = name[id.toInt()]
            val cityInfo = info[id.toInt()]

            bundle.putString("cityNames", cityNames)
            bundle.putString("cityInfo", cityInfo)


            val fragInfo = this
            fragInfo.arguments = bundle


        }

//        btn.setOnClickListener(){
//
//            val bundle = Bundle()
//            val myMessage = "Stackoverflow is cool!"
//            bundle.putString("data1", myMessage)
//            val fragInfo = this
//            fragInfo.arguments = bundle
//
//        }

        return view
    }

}