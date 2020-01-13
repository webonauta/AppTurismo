package com.example.appturismo.adapters;

import android.widget.ImageView;

import com.example.appturismo.models.Place;

public interface PlaceItemClickListener {

    //Crea animacion entre dos actividades
    void onplaceClick(Place place, ImageView placeImageView);
}
