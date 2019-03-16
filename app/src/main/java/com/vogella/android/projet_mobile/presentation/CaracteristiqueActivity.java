package com.vogella.android.projet_mobile.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.CaracteristiqueController;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;

public class CaracteristiqueActivity extends AppCompatActivity {
    private CaracteristiqueController controller;
    private TextView txt;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristique);

        String HeroJson=getIntent().getStringExtra("CLE");
        Gson gson=new Gson();

        Hero hero = gson.fromJson(HeroJson, Hero.class);
         txt = findViewById(R.id.caracteristique);
        controller = new CaracteristiqueController(this);
        controller.onStart(hero);

    }

    public void showDetail(RestCaracteristiqueResponse input) {
        String a= input.getA().getDescription();
        txt.setText(input.getNom()+"\n"+input.getId()+"\n"+input.getCaracteristiques().getDps()+"\n"+input.getA().getImage()
        +"\n"+ Html.fromHtml(a));




    }
}
