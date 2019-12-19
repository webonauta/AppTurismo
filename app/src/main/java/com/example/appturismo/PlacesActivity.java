package com.example.appturismo;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);


        sliderpager = findViewById(R.id.slider_page);
        indicator = findViewById(R.id.indicator);


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
