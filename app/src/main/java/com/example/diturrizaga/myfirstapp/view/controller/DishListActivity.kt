package com.example.diturrizaga.myfirstapp.view.controller

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.example.diturrizaga.myfirstapp.R
import com.example.diturrizaga.myfirstapp.view.adapter.DishAdapter
import com.example.diturrizaga.myfirstapp.model.data.DishData
import com.example.diturrizaga.myfirstapp.model.Dish
import java.lang.ref.WeakReference


open class DishListActivity : AppCompatActivity() {
    private var dishListView : ListView? = null
    private var dishList : List<Dish>? = null
    private var dishListUrl: List<Dish>? = null
//    private val dishAdapter = DishAdapter(dishListUrl!!, this) //seteo de imágenes


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)
        dishListView = findViewById(R.id.dishListLv)

        //val displayDishesRunnable = MyRunnable() // cambiar nombre al mRunnable descriptivo
        //Thread(displayDishesRunnable).start() //

        //val loadImagesTask = LoadImagesAT(this) // aqui lo mismo con el nombre " task "
        //loadImagesTask.execute()

        val loadImagesFromUrl = LoadImagesFromURLTask(this)
        loadImagesFromUrl.execute()
    }

    internal inner class displayDishesRunnable:Runnable{
        override fun run() {
            getDishes()
            putExtras()
        }
    }

    private fun getDishes(){
        dishList = DishData.dishList //Extraigo la data hardcodeada

        val dishAdapter = DishAdapter(dishList!!, this)
        dishListView!!.adapter = dishAdapter
    }

    private fun getDishesFromDishData(){
        dishListUrl = DishData.dishListUrl //descargo imágenes

    }

    private fun downloadImagesFromUrl(){

    }

    private fun setDishesOnAdapter(){
        val dishAdapter = DishAdapter(dishListUrl!!, this)
        dishListView!!.adapter =dishAdapter
    }



    private fun putExtras(){
        dishListView!!.setOnItemClickListener{ _, _, position, _ ->
            val selectedDish = dishList!![position]
            val bundle = Bundle()
            bundle.putSerializable("DISH", selectedDish)

            val detailIntent = Intent(this, DishDetailsActivity::class.java)
            detailIntent.putExtras(bundle)
            startActivity(detailIntent)
        }
    }

    private class LoadImagesAT internal constructor(dishListActivity: DishListActivity) : AsyncTask<Int,Int, String>(){
        private val dishListActivityWeakReference : WeakReference<DishListActivity> = WeakReference(dishListActivity)

        override fun doInBackground(vararg params: Int?): String {
            val dishListActivity = dishListActivityWeakReference.get()
            dishListActivity!!.getDishes()
            dishListActivity.putExtras()
            return "Finished!"
        }

    }

    private class LoadImagesFromURLTask internal constructor(dishListActivity: DishListActivity) : AsyncTask<Void,Void, String>(){
        private val dishListActivityWeakReference : WeakReference<DishListActivity> = WeakReference(dishListActivity)


        override fun doInBackground(vararg params: Void?): String {
            val dishListActivity = dishListActivityWeakReference.get()
            dishListActivity!!.getDishesFromDishData()
            return "Finished!"
        }

        override fun onPreExecute() {

        }

        override fun onPostExecute(result: String?) {
            val dishListActivity = dishListActivityWeakReference.get()
            dishListActivity!!.setDishesOnAdapter()
            dishListActivity.putExtras()

        }
    }
}