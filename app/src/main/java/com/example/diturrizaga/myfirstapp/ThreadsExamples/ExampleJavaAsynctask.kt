package com.example.diturrizaga.myfirstapp.ThreadsExamples

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.diturrizaga.myfirstapp.R
import java.lang.ref.WeakReference
import androidx.appcompat.app.AppCompatActivity

class ExampleJavaAsynctask : AppCompatActivity() {
    private var startButton: Button? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.row_progress_bar)
        progressBar = findViewById(R.id.progress_bar)
        startButton = findViewById(R.id.start_button)
        displayProgressBar()

    }

    private fun displayProgressBar() {
        startButton!!.setOnClickListener{
            val task = Example2AsyncTask(this)
            task.execute(10)
        }
    }

    private class Example2AsyncTask internal constructor(example: ExampleJavaAsynctask) : AsyncTask<Int, Int, String>() {

        private val exampleJavaAsyncTaskWeakReference: WeakReference<ExampleJavaAsynctask> = WeakReference(example)

        override fun onPreExecute() {
            super.onPreExecute()
            val example = exampleJavaAsyncTaskWeakReference.get()
            if (example == null || example.isFinishing) {
                return
            }
            example.progressBar!!.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg integers: Int?): String {
            for (i in 0 until integers[0]!!) {
                publishProgress(i * 100 / integers[0]!!)
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
            return "Finished!"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val example = exampleJavaAsyncTaskWeakReference.get()
            if (example == null || example.isFinishing) {
                return
            }
            example.progressBar!!.progress = values[0]!!
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            val example = exampleJavaAsyncTaskWeakReference.get()
            if (example == null || example.isFinishing) {
                return
            }
            Toast.makeText(example, s, Toast.LENGTH_SHORT).show()
            example.progressBar!!.progress = 0
            example.progressBar!!.visibility = View.INVISIBLE
        }
    }
}
