package com.google.android.snaphelper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image.*

/**
 * Created by GR on 2017/11/9.
 */
class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        val resName = intent.getStringExtra("res_name")
        val identifier = resources.getIdentifier(resName, "drawable", "com.google.android.snaphelper")
        Glide.with(this)
                .load(identifier)
                .into(imageView)
    }
}