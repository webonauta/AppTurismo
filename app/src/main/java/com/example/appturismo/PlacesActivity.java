package com.example.appturismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PlacesActivity extends AppCompatActivity implements  PlaceItemClickListener{

    private List<Slide> lstSlide;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView PlacesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        sliderpager = findViewById(R.id.slider_page);
        indicator = findViewById(R.id.indicator);
        PlacesRV = findViewById(R.id.Rv_Place);


        lstSlide = new ArrayList<>();
        lstSlide.add(new Slide(R.drawable.slide01, "Bellas Artes"));
        lstSlide.add(new Slide(R.drawable.slide02, "Zocalo"));
        lstSlide.add(new Slide(R.drawable.slide03, "Bosque de Chapultepec"));
        lstSlide.add(new Slide(R.drawable.slide04, "Castillo de Chapultepec"));
        lstSlide.add(new Slide(R.drawable.slide05, "Museo Frida Khalo"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlide);
        sliderpager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new PlacesActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(sliderpager, true);

        //RecyclerView de lugares turisticos individuales

        //Iniciando datos
        List<Place> lstPlaces = new ArrayList<>();
        lstPlaces.add(new Place("Museo de antropologia", R.drawable.place01));
        lstPlaces.add(new Place("Castillo de Chapultepec", R.drawable.place02));
        lstPlaces.add(new Place("Barrio Chino", R.drawable.place03));
        lstPlaces.add(new Place("Monumento a la Revolucion", R.drawable.place04));
        lstPlaces.add(new Place("Museo Frida Khalo", R.drawable.place05));

        PlaceAdapter placeAdapter = new PlaceAdapter(this, lstPlaces, this);
        PlacesRV.setAdapter(placeAdapter);
        PlacesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    //Envia informacion de un lugar turistico a Detail Activity y se crea la animacion entre las dos actividades
    @Override
    public void onplaceClick(Place place, ImageView placeimageView) {
        Intent intent = new Intent(this, PlaceDetailActivity.class);
        intent.putExtra("title", place.getTitle());
        intent.putExtra("imgURL", place.getThumnail());
        //Creando animacion
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(PlacesActivity.this, placeimageView, "sharedName");

        startActivity(intent, options.toBundle());

        Toast.makeText(this, "item clicked: " + place.getTitle(), Toast.LENGTH_SHORT).show();
    }

    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            PlacesActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderpager.getCurrentItem()<lstSlide.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }else {
                        sliderpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
