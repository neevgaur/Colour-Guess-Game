package com.gaurneev.gdsccolorgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gaurneev.gdsccolorgame.databinding.ActivityResultBinding

class resultActivity : AppCompatActivity() {
    lateinit var resultBinding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        resultBinding=ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(resultBinding.root)

        val Naam = intent.getStringExtra("name")
        resultBinding.btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}