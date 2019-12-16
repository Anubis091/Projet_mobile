package com.vogella.android.projet_mobile.presentation;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.MapController;
import com.vogella.android.projet_mobile.model.Map;
import com.vogella.android.projet_mobile.model.RestCaracteristiqueMapResponse;

public class MapActivity  extends AppCompatActivity {

    private TextView title;
    private TextView Descri;
    private MapController controller;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        String MapJson=getIntent().getStringExtra("CleMAP");
        Gson gson=new Gson();
        Map map=gson.fromJson(MapJson, Map.class);





        controller = new MapController(this);

        controller.onStart(map);
    }

    public void showDetailMap(final RestCaracteristiqueMapResponse input ){


        title = findViewById(R.id.title_description);
        title.setText(Html.fromHtml("<strong>Description</strong>"));

        Descri = findViewById(R.id.Description);
        Descri.setText(Html.fromHtml(input.getDescription()));

        ImageView imageView = findViewById(R.id.image);
        Picasso.with(getBaseContext()).load(input.getImage()).resize(320,240).into(imageView);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setTitle(input.getNom());

    }
}
