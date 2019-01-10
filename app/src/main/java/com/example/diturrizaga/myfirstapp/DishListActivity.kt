package com.example.diturrizaga.myfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView


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

        dishes = Dish.getAllDishes()
    }

    override fun goToView(dish: Dish) {

    }
}