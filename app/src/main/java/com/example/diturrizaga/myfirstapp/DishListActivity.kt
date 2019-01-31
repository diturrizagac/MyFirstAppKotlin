package com.example.diturrizaga.myfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.example.diturrizaga.myfirstapp.adapter.DishAdapter
import com.example.diturrizaga.myfirstapp.data.DishData
import com.example.diturrizaga.myfirstapp.model.Dish


class DishListActivity : AppCompatActivity(), PlaceSelectedListener{

    var dishListView : ListView? = null
    var dishes : List<Dish>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)

        dishListView = findViewById(R.id.dishListLv)
        retrieveDish()

    }

    fun retrieveDish(){
        dishes = DishData.getAllDishes()
        val dishAdapter = DishAdapter(dishes!!, this, this)
        dishListView!!.adapter = dishAdapter
    }


    override fun goToView(dish: Dish) {
        val bundle = Bundle()
        bundle.putSerializable("DISH", dish)
    }
}