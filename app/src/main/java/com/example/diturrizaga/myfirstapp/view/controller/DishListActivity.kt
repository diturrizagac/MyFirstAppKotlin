package com.example.diturrizaga.myfirstapp.view.controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.example.diturrizaga.myfirstapp.R
import com.example.diturrizaga.myfirstapp.view.adapter.DishAdapter
import com.example.diturrizaga.myfirstapp.model.data.DishData
import com.example.diturrizaga.myfirstapp.model.Dish


open class DishListActivity : AppCompatActivity() {
    var dishListView : ListView? = null
    private var dishes : List<Dish>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)
        dishListView = findViewById(R.id.dishListLv)
        displayDishes()
    }

    private fun displayDishes(){
        dishes = DishData.dishList
        val dishAdapter = DishAdapter(dishes!!, this)
        dishListView!!.adapter = dishAdapter

        dishListView!!.setOnItemClickListener{ _, _, position, _ ->
            val selectedDish = dishes!![position]
            val bundle = Bundle()
            bundle.putSerializable("DISH", selectedDish)

            val detailIntent = Intent(this, DishDetailsActivity::class.java)
            detailIntent.putExtras(bundle)
            startActivity(detailIntent)
        }
    }
}