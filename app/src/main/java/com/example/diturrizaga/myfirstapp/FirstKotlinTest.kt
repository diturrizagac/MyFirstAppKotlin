package com.example.diturrizaga.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Course(val nombre: String, val url:String)

class FirstKotlinTest : AppCompatActivity() {



    val java = Course("Java","java.com")
    val kotlin = Course("Kotlin","kotlin.com")
    var currentCourse = java.copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_kotlin_test)

        val showMeBtn = findViewById<Button>(R.id.showMeBtn)

        showMeBtn.setOnClickListener{
            //showOnScreen("Oh señor, me has dado click")
            switchCurso(currentCourse)
        }
        //txt.setText("It works")
        //showOnScreen("Curso de ${java.nombre} en platzi.com/${java.url}")

     }

    fun switchCurso(course:Course){
        currentCourse = course.copy()
        when(currentCourse.url){
            "java.com" -> currentCourse = kotlin.copy()
            "kotlin.com" -> currentCourse = java.copy()
            else -> println("This isnt gonna happen")
        }
        showOnScreen("Curso de ${currentCourse.nombre} en platzi.com/${currentCourse.url}")

    }

    fun showOnScreen(message : String) {
        val showMeTviAux = findViewById<TextView>(R.id.showMeTvi)
        showMeTviAux.setText(message)
    }
}
