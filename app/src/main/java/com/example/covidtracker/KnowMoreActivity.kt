package com.example.covidtracker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.covidtracker.databinding.ActivityKnowMoreBinding

class KnowMoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityKnowMoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_know_more)

        binding.btnLearnMore.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019"))
            startActivity(intent)
        }
    }
}