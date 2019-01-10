package com.example.diturrizaga.myfirstapp

class Dish(val title:String, val description:String, val image:String){
    companion object {
        val dishList = listOf<Dish>(
                Dish("Ají de gallina", "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..","path"),
                Dish("Ceviche", "Lorem ipsum dolor sit ametadipiscing etiam eu et nisl.","path"),
                Dish("Adobo de chancho", "El adobo es un estilo de preparación proveniente de Europa; pero en Perú..","path"),
                Dish("Aguadito","Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre..","path"),
                Dish("Ajiaco de papas", "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..","path"),
                Dish("Adobo de chancho", "El adobo es un estilo de preparación proveniente de Europa; pero en Perú","path"),
                Dish("Ceviche", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, ","path"),
                Dish("Ceviche", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, tristique pede, ac nibh. Vel rutrum nostc","path"),
                Dish("Ceviche", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, tristique pede, ac nibh. Vel rutrum no","path")
        )
        fun getAllDishes(): List<Dish>{
            return dishList
        }
    }
}


