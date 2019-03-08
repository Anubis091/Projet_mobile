package com.vogella.android.projet_mobile.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.MainController;
import com.vogella.android.projet_mobile.model.Hero;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new MainController(this);
        controller.onStart();
    }

    public void showList(List<Hero> input){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input, this,getHeroListener());
        recyclerView.setAdapter(mAdapter);
    }

    private MyAdapter.OnItemClickListener getHeroListener(){
        return new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Hero item){
                Intent intent =new Intent(getApplicationContext(),CaracteristiqueActivity.class);
                Gson gson=new Gson();
                intent.putExtra("CLE",gson.toJson(item));
                startActivity(intent);
            }
        };
    }
}
