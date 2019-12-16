package com.vogella.android.projet_mobile.presentation;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.CaracteristiqueController;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueResponse;
import com.vogella.android.projet_mobile.model.Talent;

import java.util.List;

public class CaracteristiqueActivity extends AppCompatActivity{
    private CaracteristiqueController controller;
    private RecyclerView.Adapter mAdapter;
    private TextView title;
    private TextView caracteristique;
    private TextView titleTalent1;
    private RecyclerView recyclerView4;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView7;
    private RecyclerView recyclerView10;
    private RecyclerView recyclerView13;
    private RecyclerView recyclerView16;
    private RecyclerView recyclerView20;
    private TextView titleTalent4;
    private TextView titleTalent7;
    private TextView titleTalent10;
    private TextView titleTalent13;
    private TextView titleTalent16;
    private TextView titleTalent20;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristique);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));
        String HeroJson=getIntent().getStringExtra("CLE");
        Gson gson=new Gson();

        Hero hero = gson.fromJson(HeroJson, Hero.class);

        collapsingToolbar.setTitle(hero.getName());

        controller = new CaracteristiqueController(this);
        controller.onStart(hero);




    }
    public void showTalent(List<Talent> input,RecyclerView recyclerView){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter2(input, this);
        recyclerView.setAdapter(mAdapter);
    }

    public void showDetail(final RestCaracteristiqueResponse input) {

        ImageView imageSpellA=findViewById((R.id.imageSpellA));
        Picasso.with(getBaseContext()).load(input.getA().getImage()).resize(189,189).into(imageSpellA);
        imageSpellA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CaracteristiqueActivity.this);
                      builder.setTitle ("A : "+input.getA().getNom())
                      .setMessage("Mana : "+input.getA().getMana()+"          Temps de recharge : "+input.getA().getCd()+" sec"+"\n"+
                Html.fromHtml(input.getA().getDescription()))
                      .show();
            }
        });

        ImageView imageSpellZ=findViewById(R.id.imageSpellZ);
        Picasso.with(getBaseContext()).load(input.getZ().getImage()).resize(189,189).into(imageSpellZ);
        imageSpellZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CaracteristiqueActivity.this);
                builder.setTitle ("Z : "+input.getZ().getNom())
                        .setMessage("Mana : "+input.getZ().getMana()+"          Temps de recharge : "+input.getZ().getCd()+" sec"+"\n"+
                                Html.fromHtml(input.getZ().getDescription()))
                        .show();
            }
        });

        ImageView imageSpellE=findViewById(R.id.imageSpellE);
        Picasso.with(getBaseContext()).load(input.getE().getImage()).resize(189,189).into(imageSpellE);
        imageSpellE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CaracteristiqueActivity.this);
                builder.setTitle ("E : "+input.getE().getNom())
                        .setMessage("Mana : "+input.getE().getMana()+"          Temps de recharge : "+input.getE().getCd()+" sec"+"\n"+
                                Html.fromHtml(input.getE().getDescription()))
                        .show();
            }
        });

        ImageView imageSpellD=findViewById(R.id.imageSpellD);
        Picasso.with(getBaseContext()).load(input.getD().getImage()).resize(189,189).into(imageSpellD);
        imageSpellD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CaracteristiqueActivity.this);
                builder.setTitle ("D : "+input.getD().getNom())
                        .setMessage("Mana : "+input.getD().getMana()+"          Temps de recharge : "+input.getD().getCd()+" sec"+"\n"+
                                Html.fromHtml(input.getD().getDescription()))
                        .show();
            }
        });

        title = findViewById(R.id.caracteristiquetitle);
        title.setText(Html.fromHtml("<strong>Caractéristiques</strong>"));

        TextView Sort=findViewById(R.id.textView);
        Sort.setText(Html.fromHtml("<strong>Sort</strong>"));


        ImageView imageView = findViewById(R.id.image);
        Picasso.with(getBaseContext()).load(input.getImg()).resize(320,240).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(input.getGuide())));
            }
        });


        caracteristique=findViewById(R.id.caracteristique);

        caracteristique.setText(
                "\nATTAQUE                                       DEFENSE\n"+
                        "Dégats de l'attaque : "+input.getCaracteristiques().getDps()+"         Points de vie : "+input.getCaracteristiques().getLp()+"\n"+
                        "Attaques par seconde : "+input.getCaracteristiques().getAps()+"        Régen/sec : "+input.getCaracteristiques().getRlp()+"\n"+
                        "Portée de l'attaque : "+input.getCaracteristiques().getRange()+"              Armure anti-sort : "+input.getCaracteristiques().getAas()+"\n"+
                        "                                                          Armure physique : "+input.getCaracteristiques().getAp()+"\n\n"+
                        "CAPACITES                                    UTILITAIRES\n"+
                        "Mana : "+input.getCaracteristiques().getMana()+"                                 Vitesse déplacement : "+input.getCaracteristiques().getSpeed()+"\n"
                        +"Regen/sec : "+input.getCaracteristiques().getRmana()+"\n");


        titleTalent1=findViewById(R.id.titleTalents1);
        recyclerView1 = findViewById(R.id.Talents1);
        titleTalent1.setText(Html.fromHtml("<strong>Talents 1</strong>"));
        showTalent(input.getTalents1(),recyclerView1);



        titleTalent4=findViewById(R.id.titleTalents4);
        recyclerView4 = findViewById(R.id.Talents4);
        titleTalent4.setText(Html.fromHtml("<strong>Talents 4</strong>"));
        showTalent(input.getTalents4(),recyclerView4);


        titleTalent7=findViewById(R.id.titleTalents7);
        recyclerView7 = findViewById(R.id.Talents7);
        titleTalent7.setText(Html.fromHtml("<strong>Talents 7</strong>"));
        showTalent(input.getTalents7(),recyclerView7);


        titleTalent10=findViewById(R.id.titleTalents10);
        recyclerView10 = findViewById(R.id.Talents10);
        titleTalent10.setText(Html.fromHtml("<strong>Talents 10</strong>"));
        showTalent(input.getTalents10(),recyclerView10);


        titleTalent13=findViewById(R.id.titleTalents13);
        recyclerView13 = findViewById(R.id.Talents13);
        titleTalent13.setText(Html.fromHtml("<strong>Talents 13</strong>"));
        showTalent(input.getTalents13(),recyclerView13);


        titleTalent16=findViewById(R.id.titleTalents16);
        recyclerView16 = findViewById(R.id.Talents16);
        titleTalent16.setText(Html.fromHtml("<strong>Talents 16</strong>"));
        showTalent(input.getTalents16(),recyclerView16);


        titleTalent20=findViewById(R.id.titleTalents20);
        recyclerView20 = findViewById(R.id.Talents20);
        titleTalent20.setText(Html.fromHtml("<strong>Talents 20</strong>"));
        showTalent(input.getTalents20(),recyclerView20);

        }













}

