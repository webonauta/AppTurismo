package com.example.appturismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PlacesActivity extends AppCompatActivity {

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
        lstPlaces.add(new Place("Museo de antropologia", R.drawable.antropologia));
        lstPlaces.add(new Place("Castillo de Chapultepec", R.drawable.castillo));
        lstPlaces.add(new Place("Barrio Chino", R.drawable.barrio_chino));
        lstPlaces.add(new Place("Monumento a la Revolucion", R.drawable.monumento));
        lstPlaces.add(new Place("Museo Frida Khalo", R.drawable.museo_frida));

        PlaceAdapter placeAdapter = new PlaceAdapter(this, lstPlaces);
        PlacesRV.setAdapter(placeAdapter);
        PlacesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


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
