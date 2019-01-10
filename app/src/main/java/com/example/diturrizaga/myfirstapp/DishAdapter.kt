package com.example.diturrizaga.myfirstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View?
//      view= LayoutInflater.from(context).inflate(R.layout.row_plate,parent,false);
        view = LayoutInflater.from(context).inflate(R.layout.row_dish_description,parent,false)

        val dishToShow : Dish = listDishes!!.get(position)
        val titleDishTv : TextView = view.findViewById(R.id.titleDishRowTv)
        val descDishTv : TextView = view.findViewById(R.id.descDishRowTv)
        val imageDishIv : ImageView = view.findViewById(R.id.imageDishRowIv)

        titleDishTv.setText(dishToShow.title)
        descDishTv.setText(dishToShow.description)

        return view
    }
}