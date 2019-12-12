package com.example.appturismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PlacesActivity extends AppCompatActivity {

    private List<Slide> lstSlide;
    private ViewPager sliderpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);


        sliderpager = findViewById(R.id.slider_page);

        lstSlide = new ArrayList<>();
        lstSlide.add(new Slide(R.drawable.slide01, "Bellas Artes"));
        lstSlide.add(new Slide(R.drawable.slide02, "Zocalo"));
        lstSlide.add(new Slide(R.drawable.slide03, "Bosque de Chapultepec"));
        lstSlide.add(new Slide(R.drawable.slide04, "Castillo de Chapultepec"));
        lstSlide.add(new Slide(R.drawable.slide05, "Museo Frida Khalo"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlide);
        sliderpager.setAdapter(adapter);

    }
}
