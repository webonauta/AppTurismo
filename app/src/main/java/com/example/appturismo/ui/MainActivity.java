package com.example.appturismo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import com.example.appturismo.adapters.IntroViewPagerAdapter;
import com.example.appturismo.R;
import com.example.appturismo.adapters.ScreenItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnSig;
    int position = 0;
    Button btnIniciar;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button) findViewById(R.id.btnIniciar);

        if(restoreDataPref()){
            Intent placesActivity = new Intent(MainActivity.this,PlacesActivity.class);
            startActivity(placesActivity);
            finish();
        }

        //Iniciando vistas
        btnSig = findViewById(R.id.btnSig);
        btnIniciar = findViewById(R.id.btnIniciar);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        //Listando vistas
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Lugares Turisticos", "Encuentra lugares turisticos populares cercanos a tu ubicacion", R.drawable.cdmx));
        mList.add(new ScreenItem("Lugares especiales", "¿Buscar un lugar en especifico? Encuentra todo en la aplicacion movil", R.drawable.angel));
        mList.add(new ScreenItem("Navegacion intuitiva", "Miles de usuarios usan nuestra aplicacion, es muy facil", R.drawable.app));

        //Configurando viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //Declarando layout de las tablas y viewpager
        tabIndicator.setupWithViewPager(screenPager);

        //Configurando boton siguiente
        btnSig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if(position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if(position == mList.size()-1){
                    loadLastScreen();
                }
            }
        });
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()== mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //ClickListener del Boton Iniciar
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent placeActivity = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(placeActivity);

                saveDataPref();
                finish();
            }
        });
    }

    private boolean restoreDataPref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend", false);

        return isIntroActivityOpnendBefore;
    }

    private void saveDataPref() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend", true);
        editor.commit();
    }

    private void loadLastScreen(){
        btnSig.setVisibility(View.INVISIBLE);
        btnIniciar.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        //Configuracion del boton animado
        btnIniciar.setAnimation(btnAnim);


    }
}
