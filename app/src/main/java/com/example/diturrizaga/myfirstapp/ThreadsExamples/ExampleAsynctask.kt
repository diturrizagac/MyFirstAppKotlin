package com.example.diturrizaga.myfirstapp.ThreadsExamples

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diturrizaga.myfirstapp.R

class ExampleAsynctask: AppCompatActivity(){
    private var progressBar : ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_background_thread)
        progressBar = findViewById(R.id.progress_bar)
    }

    fun startAsyncTask1(view : View){
        val task = ExampleAsyncTask2()
        task.execute(10)

    }



    internal inner class ExampleAsyncTask2 : AsyncTask<Int, Int, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar!!.visibility = View.VISIBLE  // UI Thread or Main Thread
        }
        override fun doInBackground(vararg params: Int?): String {
            for (i in 0 until params[0]!!){
                publishProgress((i*100)/params[0]!!)
                Thread.sleep(1000)
            }
            return "Finished!"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            progressBar!!.progress = values[0]!!
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val makeText = Toast.makeText(this@ExampleAsynctask, result , Toast.LENGTH_SHORT).show()
            progressBar!!.progress = 0
            progressBar!!.visibility = View.VISIBLE
        }


    }

}