package com.vogella.android.projet_mobile.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.CaracteristiqueController;

public class CaracteristiqueActivity extends AppCompatActivity {
    private CaracteristiqueController controller;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristique);
        
        String HeroJson=getIntent().getStringExtra("CLE");
        Gson gson
    }
}
