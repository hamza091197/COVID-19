package com.example.covidtracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.covidtracker.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.fever,"Fever","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        binding.recyclerView.adapter = symptomsAdapter


        binding.recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,
            RecyclerView.HORIZONTAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        binding.recyclerViewPrecautions.adapter = precautionsAdapter

        binding.txtViewSymptoms.setOnClickListener {
            var intent = Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }

        binding.btnKnowMore.setOnClickListener {
            var intent = Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        binding.txtViewPrecautions.setOnClickListener {
            var intent = Intent(this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }


        getGlobalData()


    }



    fun getGlobalData(){
        val url:String ="https://corona.lmao.ninja/v2/all/"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                //now set values in textview
                binding.txtInfected.text = jsonObject.getString("cases")
                binding.txtRecoverd.text = jsonObject.getString("recovered")
                binding.txtDeceased.text = jsonObject.getString("deaths")

            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,it.toString(), Toast.LENGTH_LONG).show()
                binding.txtInfected.text = "-"
                binding.txtRecoverd.text = "-"
                binding.txtDeceased.text = "-"

            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }

}