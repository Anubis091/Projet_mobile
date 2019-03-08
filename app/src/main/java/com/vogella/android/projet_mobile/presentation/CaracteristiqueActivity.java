package com.vogella.android.projet_mobile.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.CaracteristiqueController;
import com.vogella.android.projet_mobile.model.Hero;

public class CaracteristiqueActivity extends AppCompatActivity {
    private CaracteristiqueController controller;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristique);

        String HeroJson=getIntent().getStringExtra("CLE");
        Gson gson=new Gson();

        Hero hero = gson.fromJson(HeroJson, Hero.class);

        controller = new CaracteristiqueController(this);
        controller.onStart();
    }
}
