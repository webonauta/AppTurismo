package com.example.appturismo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appturismo.R;

import static com.example.appturismo.R.id.detail_place_img;

public class PlaceDetailActivity extends AppCompatActivity {

    private ImageView PlaceThumnailImg, PlaceCoverImg;
    private TextView place_tittle, place_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        //iniciando vistas
        iniViews();

    }

    void iniViews(){
        //Obteniendo informacion
        String placeTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        PlaceThumnailImg = findViewById(R.id.detail_place_img);
        Glide.with(this).load(imageResourceId).into(PlaceThumnailImg);
        PlaceThumnailImg.setImageResource(imageResourceId);
        PlaceCoverImg = findViewById(R.id.detail_place_cover);
        Glide.with(this).load(imagecover).into(PlaceCoverImg);
        place_tittle = findViewById(R.id.detail_place_title);
        place_tittle.setText(placeTitle);
        place_description = findViewById(R.id.detail_place_description);

    }
}
