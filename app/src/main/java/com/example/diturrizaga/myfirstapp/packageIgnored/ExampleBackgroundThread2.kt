package com.example.diturrizaga.myfirstapp.packageIgnored

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.diturrizaga.myfirstapp.R

class ExampleBackgroundThread2: AppCompatActivity() {
    private var buttonStartThread2 : Button? = null
    private val mainHandler = Handler()
    @Volatile
    private var stopThread2 = false

    companion object {
        private val TAG = "ExmpleBackgroundThread2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_background_thread)
        buttonStartThread2 = findViewById(R.id.button_start_thread)
    }

    fun startThread(view: View){
        stopThread2 = false
        val runnable = ExampleRunnable(10)
        Thread(runnable).start()
    }

    fun stopThread(view: View){
        stopThread2 = true
    }

    internal inner class ExampleThread(var seconds: Int) : Thread() {

        override fun run() {
            for(i in 0 until seconds){
                Log.d(TAG, "startThread: $i")
                try {
                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
        }
    }

    internal inner class ExampleRunnable(var seconds : Int) : Runnable{
        override fun run() {
            for (i in 0 until seconds) {
                if(stopThread2)
                    return
                if(i==5){
                    runOnUiThread { buttonStartThread2!!.text = "50%" }
                }
                Log.d(TAG, "startThread: $i")
                try {
                    Thread.sleep(1000)
                }catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
        }
    }

}