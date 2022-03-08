package com.example.covidtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidtracker.databinding.ActivitySymptomsBinding

class SymptomsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySymptomsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_symptoms)


        getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.fever,"Fever","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        binding.recyclerView.adapter = symptomsAdapter
    }
}