package com.example.diturrizaga.myfirstapp.view.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.diturrizaga.myfirstapp.view.controller.PlaceSelectedListener
import com.example.diturrizaga.myfirstapp.R
import com.example.diturrizaga.myfirstapp.model.Dish
import java.io.IOException
import java.io.InputStream

class DishAdapter : BaseAdapter {

    var context: Context? = null
    var listDishes: List<Dish>? = null
    var listener: PlaceSelectedListener? = null

    constructor(mDishes: List<Dish>, mContext: Context) {
        listDishes = mDishes
        context = mContext

    }

    override fun getCount(): Int {
        return listDishes!!.size
    }

    override fun getItem(position: Int): Any {
        return listDishes!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.row_dish_description, parent, false)

        val dishToShow = listDishes!![position]
        val titleDishTv: TextView = view.findViewById(R.id.titleDishRowTv)
        val descDishTv: TextView = view.findViewById(R.id.descDishRowTv)
        val imageDishIv: ImageView = view.findViewById(R.id.imageDishRowIv)

        titleDishTv.text = dishToShow.title
        descDishTv.text = dishToShow.description
        imageDishIv.setImageBitmap(getBitmapFromAssets(dishToShow.image!!))
        return view
    }



    fun getBitmapFromAssets(fileName: String): Bitmap {
        val assetManager = context!!.assets

        var istr: InputStream? = null
        try {
            istr = assetManager.open(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return BitmapFactory.decodeStream(istr)
    }
}