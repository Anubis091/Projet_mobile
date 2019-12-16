package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.Map;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Provides UI for the view with Cards.
 */
public class CardContentFragment extends Fragment {
    List<Map> dataMap;
    List<Hero> dataFromApi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Type collectionType = new TypeToken<List<Map>>(){}.getType();
        Bundle dataBundle = getArguments();
        dataMap= new Gson().fromJson(dataBundle.getString("KeyMap"),collectionType);


        Type collectionType2 = new TypeToken<List<Hero>>() {
        }.getType();

        Bundle dataBundle2 = getArguments();


        dataFromApi = new Gson().fromJson(dataBundle2.getString("Key1"), collectionType2);

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapterCardFragment adapter = new ContentAdapterCardFragment(recyclerView.getContext(), dataMap, dataFromApi, getMapListener());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public Context context;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            picture = itemView.findViewById(R.id.card_image);
            name = itemView.findViewById(R.id.card_title);
        }
    }
    /**
     * Adapter to display recycler view.
     */

    private ContentAdapterCardFragment.OnItemClickListener getMapListener(){
        return new ContentAdapterCardFragment.OnItemClickListener(){
            @Override
            public void onItemClick (Map item,List<Hero> dataFromApi){
                Intent intent = new Intent((getContext()), MapActivity.class);
                Gson gson= new Gson();
                intent.putExtra("CleMAP",gson.toJson(item));
                intent.putExtra("CleLIST",gson.toJson(dataFromApi));
                startActivity(intent);
            }
        };
    }
}
