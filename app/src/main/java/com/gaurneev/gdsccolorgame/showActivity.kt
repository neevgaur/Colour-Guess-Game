package com.gaurneev.gdsccolorgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaurneev.gdsccolorgame.databinding.ActivityShowBinding
import kotlinx.android.synthetic.main.activity_show.*
import kotlinx.android.synthetic.main.activity_show.view.*

class showActivity : AppCompatActivity() {
    lateinit var showBinding: ActivityShowBinding

    private lateinit var hd:Handler
    private val next = Intent(this,finalActivity::class.java)
    private var ci=0
    private var cl = arrayOf(
        Color.WHITE,Color.CYAN,Color.RED,Color.GREEN,Color.GRAY,Color.YELLOW,Color.BLUE
    )
    private val clList:ArrayList<String> = arrayListOf("white","blue","red","green","gray","yellow")
    private  val demo:ArrayList<String> = ArrayList()
    private var count =1


    override fun onCreate(savedInstanceState: Bundle?) {
        showBinding = ActivityShowBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(showBinding.root)

        val name = intent.getStringExtra("Name")


        showBinding.checkBtn.setOnClickListener {
            demo.add(showBinding.ansLayout.etColour.text.toString().toLowerCase().trim())
            count++
            if (count==6){
                showBinding.ansLayout.etColour.hint = "Colour $count"
                showBinding.ansLayout.etColour.setText("")
                showBinding.ansLayout.clView.text = demo.toString()
                showBinding.checkBtn.text="Check"
            }
            else if(count==7){
//                if (demo == clList){
                    var ct=0
                    for (i in 0..5){
                        if(demo.get(i).compareTo(clList.get(i))!=0) break
                        ct++
                    }
                    if(ct==6){
                        val new=Intent(this,resultActivity::class.java)
                        intent.putExtra("Naam",name)
                        startActivity(new)
                        finish()
                    }
                    else{
                        showBinding.ansLayout.etColour.hint="Wrong Sequence "
                        showBinding.ansLayout.etColour.setText("")
                        showBinding.ansLayout.clView.text = demo.toString()
                        showBinding.checkBtn.text="Reset"
                        Log.d("neev","lost")
                    }
            }
            else if (count==8){
                count=1
                demo.clear()
                showBinding.ansLayout.etColour.hint = "Colour $count"
                showBinding.ansLayout.etColour.setText("")
                showBinding.ansLayout.clView.text = demo.toString()
                showBinding.checkBtn.text="Add"
            }
            else {
                showBinding.ansLayout.etColour.hint = "Colour $count"
                showBinding.ansLayout.etColour.setText("")
                showBinding.ansLayout.clView.text = demo.toString()
            }
            Log.d("neev",demo.toString())
            Log.d("neev",clList.toString())
        }




// Color flashing
        hd = Handler(Looper.getMainLooper())
        hd.postDelayed(cc,1000)
    }

    private val cc = object : Runnable{
        override fun run() {
            showBinding.cardShow.setCardBackgroundColor(cl[ci])
            ci = (ci + 1)
            if(ci==7){
                showBinding.cardShow.visibility = View.GONE
                showBinding.ansLayout.visibility=View.VISIBLE
            }
            else {
                hd.postDelayed(this, 1000)
            }
        }
    }
}