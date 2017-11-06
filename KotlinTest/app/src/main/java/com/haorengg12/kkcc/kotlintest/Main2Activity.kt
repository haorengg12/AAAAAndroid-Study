package com.haorengg12.kkcc.kotlintest

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.find

class Main2Activity : AppCompatActivity() {
    private val item = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
        val kk: RecyclerView = find(R.id.kkcc)
        kk.layoutManager = LinearLayoutManager(this)
        kk.adapter = ForecastListAdapter(item)
        val i = "kkkkk"
        val j = i[2]
        val s = "kkkkk"
        for (j in i) {
            print("dsadhjshdjhasdj" + j)
        }
    }

    fun init() {
        for(i in 11 until 66 )
        item.add("dasgdghjasgdhja")
    }

    fun Context.toast(cc: CharSequence, kk: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, cc, kk).show()//LONG3.5秒 SHORT2秒
    }
}
