package com.vogella.android.projet_mobile.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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

public class CaracteristiqueActivity extends AppCompatActivity {
    private CaracteristiqueController controller;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView title;
    private TextView caracteristique;
    private TextView SpellA;
    private TextView SpellZ;
    private TextView SpellE;
    private TextView SpellD;
    private TextView titleTalent;
    private TextView titleSort;
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








    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristique);
        recyclerView1 = findViewById(R.id.Talents1);
        recyclerView4 = findViewById(R.id.Talents4);
        recyclerView7 = findViewById(R.id.Talents7);
        recyclerView10 = findViewById(R.id.Talents10);
        recyclerView13 = findViewById(R.id.Talents13);
        recyclerView16 = findViewById(R.id.Talents16);
        recyclerView20 = findViewById(R.id.Talents20);







        String HeroJson=getIntent().getStringExtra("CLE");
        Gson gson=new Gson();

        Hero hero = gson.fromJson(HeroJson, Hero.class);
         title = findViewById(R.id.caracteristiquetitle);
         caracteristique=findViewById(R.id.caracteristique);
         SpellA=findViewById(R.id.SpellA);
        SpellZ=findViewById(R.id.SpellZ);
        SpellE=findViewById(R.id.SpellE);
        SpellD=findViewById(R.id.SpellD);
        titleTalent=findViewById(R.id.titleTalent);
        titleSort=findViewById(R.id.titleSort);
        titleTalent1=findViewById(R.id.titleTalent1);
        titleTalent4=findViewById(R.id.titleTalent4);
        titleTalent7=findViewById(R.id.titleTalent7);
        titleTalent10=findViewById(R.id.titleTalent10);
        titleTalent13=findViewById(R.id.titleTalent13);
        titleTalent16=findViewById(R.id.titleTalent16);
        titleTalent20=findViewById(R.id.titleTalent20);








        controller = new CaracteristiqueController(this);
        controller.onStart(hero);

    }
    public void showTalent(List<Talent> input,RecyclerView recyclerView){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter2(input, this);
        recyclerView.setAdapter(mAdapter);
    }

    public void showDetail(RestCaracteristiqueResponse input) {

        ImageView imageView = findViewById(R.id.imageheros);
        ImageView imageSpellA=findViewById((R.id.imageSpellA));
        ImageView imageSpellZ=findViewById(R.id.imageSpellZ);
        ImageView imageSpellE=findViewById(R.id.imageSpellE);
        ImageView imageSpellD=findViewById(R.id.imageSpellD);
        title.setText(Html.fromHtml("<strong>"+input.getNom()+"</strong>"));
        Picasso.with(getBaseContext()).load(input.getImg()).resize(320,240).into(imageView);
        Picasso.with(getBaseContext()).load(input.getA().getImage()).resize(120,120).into(imageSpellA);
        Picasso.with(getBaseContext()).load(input.getZ().getImage()).resize(120,120).into(imageSpellZ);
        Picasso.with(getBaseContext()).load(input.getE().getImage()).resize(120,120).into(imageSpellE);
        Picasso.with(getBaseContext()).load(input.getD().getImage()).resize(120,120).into(imageSpellD);

        caracteristique.setText(
                "ATTAQUE                                       DEFENSE\n"+
                "Dégats de l'attaque : "+input.getCaracteristiques().getDps()+"         Points de vie : "+input.getCaracteristiques().getLp()+"\n"+
                "Attaques par seconde : "+input.getCaracteristiques().getAps()+"        Régen/sec : "+input.getCaracteristiques().getRlp()+"\n"+
                "Portée de l'attaque : "+input.getCaracteristiques().getRange()+"              Armure anti-sort : "+input.getCaracteristiques().getAas()+"\n"+
                "                                                          Armure physique : "+input.getCaracteristiques().getAp()+"\n\n"+
                "CAPACITES                                    UTILITAIRES\n"+
                "Mana : "+input.getCaracteristiques().getMana()+"                                 Vitesse déplacement : "+input.getCaracteristiques().getSpeed()+"\n"
                +"Regen/sec : "+input.getCaracteristiques().getRmana()+"\n\n\n");

        titleSort.setText(Html.fromHtml("<strong>Sorts</strong>"));


        SpellA.setText("A : "+input.getA().getNom()+"   \nMana : "+input.getA().getMana()+"          Temps de recharge : "+input.getA().getCd()+" sec"+"\n"+
               Html.fromHtml(input.getA().getDescription()));

        SpellZ.setText(("Z : "+input.getZ().getNom()+"   \nMana : "+input.getZ().getMana()+"          Temps de recharge : "+input.getZ().getCd()+" sec"+"\n"+
                Html.fromHtml(input.getZ().getDescription())));

        SpellE.setText(("E : "+input.getE().getNom()+"   \nMana : "+input.getE().getMana()+"          Temps de recharge : "+input.getE().getCd()+" sec"+"\n"+
                Html.fromHtml(input.getE().getDescription())));

        SpellD.setText(("D : " + input.getD().getNom() + "\n" + "Temps de recharge : " + input.getD().getCd()+" sec" + "\n" +
                    Html.fromHtml(input.getD().getDescription())));
        titleTalent.setText(Html.fromHtml("<strong> Talents</strong"));

        titleTalent1.setText("\n"+Html.fromHtml("<strong>Talents 1</strong>"));
        showTalent(input.getTalents1(),recyclerView1);

        titleTalent4.setText("\n"+Html.fromHtml("<strong>Talents 4</strong>"));
        showTalent(input.getTalents4(),recyclerView4);

        titleTalent7.setText("\n"+Html.fromHtml("<strong>Talents 7</strong>"));
        showTalent(input.getTalents7(),recyclerView7);

        titleTalent10.setText("\n"+Html.fromHtml("<strong>Talents 10</strong>"));
        showTalent(input.getTalents10(),recyclerView10);

        titleTalent13.setText("\n"+Html.fromHtml("<strong>Talents 13</strong>"));
        showTalent(input.getTalents13(),recyclerView13);

        titleTalent16.setText("\n"+Html.fromHtml("<strong>Talents 16</strong>"));
        showTalent(input.getTalents16(),recyclerView16);

        titleTalent20.setText("\n"+Html.fromHtml("<strong>Talents 20</strong>"));
        showTalent(input.getTalents20(),recyclerView20);
            }













}

