package com.example.appturismo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import static com.example.appturismo.R.id.detail_place_img;

public class PlaceDetailActivity extends AppCompatActivity {

    private ImageView PlaceThumnailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        //Obteniendo informacion
        String placeTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        PlaceThumnailImg = findViewById(R.id.detail_place_img);
        PlaceThumnailImg.setImageResource(imageResourceId);

    }
}
