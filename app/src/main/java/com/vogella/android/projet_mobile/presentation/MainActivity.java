package com.vogella.android.projet_mobile.presentation;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.controller.MainController;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.Map;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Hero> dataFromApi;
    private MainController controller;
    List<Map> dataMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(mAdapter);

        //Adding toolbar to main screen
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        controller = new MainController(this);
        controller.onStart();



    }

    private void setupViewPager(ViewPager viewPager, List<Hero> input, List<Map> dataMap) {
        Bundle data = new Bundle();
        Bundle dataM =new Bundle();

        data.putString("KeyMap", new Gson().toJson(dataMap));
        data.putString("Key1", new Gson().toJson(input));

        CardContentFragment fragCard = new CardContentFragment();
        ListContentFragment fragList = new ListContentFragment();
        TileContentFragment fragTile = new TileContentFragment();

        fragCard.setArguments(data);
        fragCard.setArguments(data);
        fragList.setArguments(data);
        fragTile.setArguments(data);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(fragList, "Liste des Heros");

        adapter.addFragment(fragTile, "Heros");
        adapter.addFragment(fragCard, "Maps");

        viewPager.setAdapter(adapter);
    }

    private void affichage(){
        // Setting ViewPager for each Tabs
        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager, dataFromApi, dataMap);
        // Set Tabs inside Toolbar
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void showMap(List<Map> input){
        dataMap=input;
    }

    public void showList(List<Hero> input){

        dataFromApi = input;
        affichage();

    }

}


