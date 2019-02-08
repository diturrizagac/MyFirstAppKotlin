package com.example.diturrizaga.myfirstapp.model

import java.io.FileDescriptor
import java.io.Serializable

class Dish :Serializable {
    var title: String? =""
    var description:String? =""
    var image:String? =""

    constructor(title: String, description: String, image:String){
        this.title = title
        this.description = description
        this.image = image
    }


}







