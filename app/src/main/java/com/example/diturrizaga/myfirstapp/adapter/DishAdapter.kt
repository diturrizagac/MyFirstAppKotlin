package com.example.diturrizaga.myfirstapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.diturrizaga.myfirstapp.PlaceSelectedListener
import com.example.diturrizaga.myfirstapp.R
import com.example.diturrizaga.myfirstapp.model.Dish

class DishAdapter : BaseAdapter{

    var context : Context? = null
    var listDishes : List<Dish>? = null
    var listener : PlaceSelectedListener? = null

    constructor(mDishes : List<Dish>, mContext : Context, mListener: PlaceSelectedListener){
        listDishes = mDishes
        context = mContext
        listener = mListener

    }

    override fun getCount(): Int {
        return listDishes!!.size
    }

    override fun getItem(position: Int): Any {
        return listDishes!![position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.row_dish_description,parent,false)
        }else {
            view = convertView
        }

//      view= LayoutInflater.from(context).inflate(R.layout.row_plate,parent,false);

        val dishToShow : Dish = listDishes!!.get(position)
        val titleDishTv : TextView = view.findViewById(R.id.titleDishRowTv)
        val descDishTv : TextView = view.findViewById(R.id.descDishRowTv)
        val imageDishIv : ImageView = view.findViewById(R.id.imageDishRowIv)

        titleDishTv.text = dishToShow.title
        descDishTv.text = dishToShow.description


        return view
    }
}