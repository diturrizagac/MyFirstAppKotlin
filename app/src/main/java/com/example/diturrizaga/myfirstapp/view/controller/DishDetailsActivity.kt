package com.example.diturrizaga.myfirstapp.view.controller

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.diturrizaga.myfirstapp.model.Dish
import java.io.IOException
import java.io.InputStream
import com.example.diturrizaga.myfirstapp.R


class DishDetailsActivity : AppCompatActivity(){

    private var currentDish : Dish? = null
    var titleTvi : TextView? = null
    var descriptionTvi : TextView? = null
    var imageIvi : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_details)
        extras()
        ui()
        populate()

    }

    private fun extras(){
        if (intent != null && intent.extras != null) {
            currentDish = intent.extras!!.getSerializable("DISH") as Dish
        }
    }

    private fun ui(){

        titleTvi = findViewById(R.id.dishTitleDetailTv)
        descriptionTvi = findViewById(R.id.dishDescDetailTv)
        imageIvi = findViewById(R.id.dishImageDetailIv)

    }

    private fun populate(){
        if (currentDish != null) {
            imageIvi!!.setImageBitmap(getBitmapFromAssets(currentDish!!.image!!))
            titleTvi!!.text = currentDish!!.title
            descriptionTvi!!.text = currentDish!!.description
        }
    }

    fun getBitmapFromAssets(fileName: String): Bitmap {
        val assetManager = assets

        var istr: InputStream? = null
        try {
            istr = assetManager.open(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return BitmapFactory.decodeStream(istr)
    }


}

