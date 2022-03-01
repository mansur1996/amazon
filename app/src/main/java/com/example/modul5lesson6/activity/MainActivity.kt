package com.example.modul5lesson6.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson6.R
import com.example.modul5lesson6.adapter.EssentialAdapter
import com.example.modul5lesson6.model.Essential

class MainActivity : AppCompatActivity() {

    lateinit var rv_essential : RecyclerView
    lateinit var ll_fashion : LinearLayout
    lateinit var ll_popular : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_fashion2)
        rv_essential = findViewById(R.id.rv_essential)

        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_essential.layoutManager = manager

        refreshAdapter(getEssentials())

        setLinearHeight(ll_fashion)
        setLinearHeight(ll_popular)
    }

    private fun setLinearHeight(layout : LinearLayout){
        // Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val heightPixels = displayMetrics.heightPixels

        //Change pixel to dp
        val heightInDp : Int = heightPixels/resources.displayMetrics.density.toInt()

        //Set layout width programmatically
        val params : ViewGroup.LayoutParams = layout.layoutParams
        params.height = heightInDp
        layout.layoutParams = params
    }

    private fun refreshAdapter(items : ArrayList<Essential>){
        val adapter = EssentialAdapter(this, items)
        rv_essential.adapter = adapter
    }

    private fun getEssentials() : ArrayList<Essential>{
        val items : ArrayList<Essential> = ArrayList()
        items.add(Essential("Oculus", R.drawable.img_watch_1))
        items.add(Essential("Oculus", R.drawable.img_watch_2))
        items.add(Essential("Oculus", R.drawable.img_watch_3))
        items.add(Essential("Oculus", R.drawable.img_watch_4))
        items.add(Essential("Oculus", R.drawable.img_watch_5))
        items.add(Essential("Oculus", R.drawable.img_watch_6))
        items.add(Essential("Oculus", R.drawable.img_watch_7))

        return items
    }
}