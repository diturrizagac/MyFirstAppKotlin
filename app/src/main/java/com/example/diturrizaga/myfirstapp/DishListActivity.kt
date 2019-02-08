package com.example.diturrizaga.myfirstapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.example.diturrizaga.myfirstapp.adapter.DishAdapter
import com.example.diturrizaga.myfirstapp.data.DishData
import com.example.diturrizaga.myfirstapp.model.Dish


open class DishListActivity : AppCompatActivity(), PlaceSelectedListener{


    var dishListView : ListView? = null
    private var dishes : List<Dish>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)
        dishListView = findViewById(R.id.dishListLv)
        //enabledBack()
        retrieveDish()
    }

    override fun onResume() {  // After a pause OR at startup
        super.onResume()

    }


    private fun retrieveDish(){
        dishes = DishData.dishList
        val dishAdapter = DishAdapter(dishes!!, this, this)
        dishListView!!.adapter = dishAdapter
    }


    override fun goToView(dish: Dish) {
        val bundle = Bundle()
        bundle.putSerializable("DISH", dish)

        val intent = Intent(this, DishDetailsActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


//    private fun enabledBack() {
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//    }
}