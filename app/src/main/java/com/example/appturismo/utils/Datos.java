package com.example.appturismo.utils;

import com.example.appturismo.R;
import com.example.appturismo.modelo.Galeria;
import com.example.appturismo.modelo.Place;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    public static List<Place>getLugaresPopulares(){
        List<Place> lstPlaces = new ArrayList<>();
        lstPlaces.add(new Place("Museo de antropologia", R.drawable.place01, R.drawable.place01));
        lstPlaces.add(new Place("Castillo de Chapultepec", R.drawable.place02, R.drawable.place02));
        lstPlaces.add(new Place("Barrio Chino", R.drawable.place03, R.drawable.place03));
        lstPlaces.add(new Place("Monumento a la Revolucion", R.drawable.place04, R.drawable.place04));
        lstPlaces.add(new Place("Museo Frida Khalo", R.drawable.place05, R.drawable.place05));

        return lstPlaces;
    }

    public static List<Place>getSugerencias(){
        List<Place> lstPlaces = new ArrayList<>();
        lstPlaces.add(new Place("Alameda Central", R.drawable.sugerencia01, R.drawable.sugerencia01));
        lstPlaces.add(new Place("Parque Hundido", R.drawable.sugerencia02, R.drawable.sugerencia02));
        lstPlaces.add(new Place("Parque Mexico", R.drawable.sugerencia03, R.drawable.sugerencia03));
        lstPlaces.add(new Place("Templo Mayor", R.drawable.sugerencia04, R.drawable.sugerencia04));
        lstPlaces.add(new Place("Xochimilco", R.drawable.sugerencia05, R.drawable.sugerencia05));

        return lstPlaces;
    }
}
