package com.gaurneev.gdsccolorgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gaurneev.gdsccolorgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        supportActionBar?.hide()

        mainBinding.startButton.setOnClickListener {
            val intent = Intent(this,showActivity::class.java)
            intent.putExtra("NAME",mainBinding.etName.text.toString())
            startActivity(intent)
            finish()
        }
    }
}