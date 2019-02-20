package com.example.diturrizaga.myfirstapp.model.data

import com.example.diturrizaga.myfirstapp.model.Dish

class DishData {
    companion object {
        val dishList = listOf<Dish>(
                Dish("Ají de gallina", "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..", "dish_images/ajidegallina.png"),
                Dish("Ceviche", "Lorem ipsum dolor sit ametadipiscing etiam eu et nisl.", "dish_images/ceviche.png"),
                Dish("Carapulcra", "La carapulcra es un delicioso ejemplar proveniente de de chincha; pero en Perú..", "dish_images/carapulcra.png"),
                Dish("Aguadito", "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre..", "dish_images/aguadito.png"),
                Dish("Arroz con Pato", "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..", "dish_images/arrozconpato.png"),
                Dish("Lomo Saltado", "El lomo saltado estilo de preparación proveniente del sur en Perú", "dish_images/lomo.png"),
                Dish("Causa Limena", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, ", "dish_images/causalimena.png"),
                Dish("Menestron", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, tristique pede, ac nibh. Vel rutrum nostc", "dish_images/menestron.png"),
                Dish("Ceviche", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, tristique pede, ac nibh. Vel rutrum no", "dish_images/ceviche.png")
        )

        val dishListUrl = listOf<Dish>(
                Dish("Ají de gallina", "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..", "https://i.imgur.com/tKYhMCW.png"),
                Dish("Ceviche", "Lorem ipsum dolor sit ametadipiscing etiam eu et nisl.", "https://i.imgur.com/dDzudMa.png"),
                Dish("Carapulcra", "La carapulcra es un delicioso ejemplar proveniente de de chincha; pero en Perú..", "https://i.imgur.com/QRkw7RU.png"),
                Dish("Aguadito", "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre..", "https://i.imgur.com/OG7cDHZ.png"),
                Dish("Arroz con Pato", "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..", "https://i.imgur.com/mrAODIJ.png"),
                Dish("Lomo Saltado", "El lomo saltado estilo de preparación proveniente del sur en Perú", "https://i.imgur.com/tPwNTnh.png"),
                Dish("Causa Limena", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, ", "https://i.imgur.com/9FNJjoV.png"),
                Dish("Menestron", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, tristique pede, ac nibh. Vel rutrum nostc", "https://i.imgur.com/EoJR4aU.png"),
                Dish("Ceviche", "Lorem ipsum dolor sit amet, aliquam sodales at morbi vehicula, tristique pede, ac nibh. Vel rutrum no", "https://i.imgur.com/dDzudMa.png")
        )
    }
}