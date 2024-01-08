package com.example.myapplication.tuan312

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.myapplication.R

class Tuan312MainActivity : AppCompatActivity() {
    var adap: Tuan312Adapter? = null
    var ls: ArrayList<Tuan312contact> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan312_main)
        var lv=findViewById<ListView>(R.id.tuan312listview)
        ls.add(Tuan312contact("Nguyen Minh Hai","20",R.drawable.android))
        ls.add(Tuan312contact("Nguyen Minh Hieu","22",R.drawable.apple))
        ls.add(Tuan312contact("Nguyen Huong Tra","15",R.drawable.blogger))
        ls.add(Tuan312contact("Nguyen Hai Minh","35",R.drawable.chrome))
        ls.add(Tuan312contact("Nguyen Quang Tu","22",R.drawable.facebook))
        ls.add(Tuan312contact("Nguyen Huy Toan","26",R.drawable.dell))
        adap= Tuan312Adapter(this,ls)
        lv.adapter=adap
    }
}