package com.example.diturrizaga.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showDishesBtn = findViewById<Button>(R.id.showMeDishesBtn)

        showDishesBtn.setOnClickListener {
            val intent = Intent(this, DishListActivity::class.java)
            startActivity(intent)
        }
    }


}


