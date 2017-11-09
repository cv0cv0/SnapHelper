package com.google.android.snaphelper

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = Items(20)
        (1..20).mapTo(items) { "bing0${if (it < 10) "0" else ""}$it" }

        val binder = ItemBinder()
        binder.setItemClickListener { view, position ->
            val intent=Intent(this,ImageActivity::class.java)
            val options=ActivityOptionsCompat.makeSceneTransitionAnimation(this,view,"image").toBundle()
            intent.putExtra("res_name",items[position] as String)
            startActivity(intent,options)
        }

        val adapter = MultiTypeAdapter(items)
        adapter.register(String::class.java, binder)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }
}
