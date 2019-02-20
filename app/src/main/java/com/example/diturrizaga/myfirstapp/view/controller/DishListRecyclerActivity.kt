package com.example.diturrizaga.myfirstapp.view.controller

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.diturrizaga.myfirstapp.R
import com.example.diturrizaga.myfirstapp.model.Dish
import java.io.IOException
import java.io.InputStream
import java.net.URL

class DishListRecyclerActivity: AppCompatActivity(){
    private val dish: Dish? = null
    fun doSomething() {
        val logo = findViewById<View>(R.id.imageDishRowIv) as ImageView
        try {
            val bitmap = BitmapFactory.decodeStream(URL(dish!!.image).content as InputStream)
            logo.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}