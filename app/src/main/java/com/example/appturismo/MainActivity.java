package com.example.appturismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.TableLayout;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciando vistas

        tabIndicator = findViewById(R.id.tab_indicator);

        //Listando vistas
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Lugares Turisticos", "Encuentra lugares turisticos populares cercanos a tu ubicacion", R.drawable.cdmx));
        mList.add(new ScreenItem("Lugares especiales", "¿Buscar un lugar en especifico? Encuentra todo en la aplicacion movil", R.drawable.angel));
        mList.add(new ScreenItem("Navegacion intuitiva", "Miles de usuarios usan nuestra aplicacion, es muy facil", R.drawable.app));

        //Configurando viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //Declarando layout de las tablas y viewpager
        tabIndicator.setupWithViewPager(screenPager);


    }


}
