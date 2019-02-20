package com.example.diturrizaga.myfirstapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.diturrizaga.myfirstapp.model.Dish;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class JavaCode extends AppCompatActivity {

    private Dish dish;
    public void doSomething(){
        ImageView logo = (ImageView) findViewById(R.id.imageDishRowIv);
        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(dish.getImage()).getContent());
            logo.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
