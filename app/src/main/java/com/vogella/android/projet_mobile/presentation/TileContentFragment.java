package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.model.Hero;

import java.lang.reflect.Type;
import java.util.List;

public class TileContentFragment extends Fragment {
    List<Hero> dataFromApi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Type collectionType = new TypeToken<List<Hero>>() {
        }.getType();
        //
        Bundle dataBundle = getArguments();
        dataFromApi = new Gson().fromJson(dataBundle.getString("Key1"), collectionType);

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapterTileFragment adapter = new ContentAdapterTileFragment(recyclerView.getContext(), dataFromApi, getHeroListener());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public Context context;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            picture = itemView.findViewById(R.id.tile_picture);
            name = itemView.findViewById(R.id.tile_title);
        }
    }

    /**
     * Adapter to display recycler view.
     */

    private ContentAdapterTileFragment.OnItemClickListener getHeroListener() {
        return new ContentAdapterTileFragment.OnItemClickListener() {
            @Override
            public void onItemClick(Hero item) {
                Intent intent = new Intent(getContext(), CaracteristiqueActivity.class);
                Gson gson = new Gson();
                intent.putExtra("CLE", gson.toJson(item));
                startActivity(intent);
            }
        };
    }
}