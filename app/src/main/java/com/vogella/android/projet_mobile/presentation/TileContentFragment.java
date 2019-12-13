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
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext(), dataFromApi, getHeroListener());
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
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        //private static final int LENGTH = 18;
        Context context;
        List<Hero> dataFromApi;
        private  final ContentAdapter.OnItemClickListener listener;


        public interface OnItemClickListener {
            void onItemClick(Hero item);
        }

        /* private final String[] mPlaces;
         private final Drawable[] mPlacePictures;*/
        public ContentAdapter(Context context, List<Hero> input, OnItemClickListener heroListener) {
            this.dataFromApi = input;
            Resources resources = context.getResources();
            this.listener = heroListener;
            /*
            mPlaces = resources.getStringArray(R.array.places);
            TypedArray a = resources.obtainTypedArray(R.array.places_picture);
            mPlacePictures = new Drawable[a.length()];
            for (int i = 0; i < mPlacePictures.length; i++) {
                mPlacePictures[i] = a.getDrawable(i);
            }
            a.recycle();*/
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Hero current_Hero = dataFromApi.get(position);
            Picasso.with(holder.context).load(current_Hero.getImg_min()).into(holder.picture);
            holder.name.setText(current_Hero.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(current_Hero);
                }
            });
           /* holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
            holder.name.setText(mPlaces[position % mPlaces.length]); */
        }

        @Override
        public int getItemCount() {
            return dataFromApi.size();
        }
    }

    private ContentAdapter.OnItemClickListener getHeroListener() {
        return new ContentAdapter.OnItemClickListener() {
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