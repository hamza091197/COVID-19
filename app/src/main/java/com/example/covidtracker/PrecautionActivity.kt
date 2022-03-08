package com.example.covidtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidtracker.databinding.ActivityPrecautionBinding

class PrecautionActivity : AppCompatActivity() {
    lateinit var binding: ActivityPrecautionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_precaution)

        getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.clean,"Clean Object & Surface","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))
        precautionsList.add(Model(R.drawable.cover,"Avoid Touching","Lorem Ipsum is simply dummy text of the printing and typesetting industry."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        binding.recyclerView.adapter = precautionsAdapter
    }
}