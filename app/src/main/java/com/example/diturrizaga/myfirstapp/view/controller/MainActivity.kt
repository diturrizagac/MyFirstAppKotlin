package com.example.diturrizaga.myfirstapp.view.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diturrizaga.myfirstapp.R

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


