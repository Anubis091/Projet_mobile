package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.model.Hero;

import java.lang.reflect.Type;
import java.util.List;

public class ListContentFragment extends Fragment {

    List<Hero> dataFromApi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Recuperer les arguments passer lors de la création du fragment
        Type collectionType = new TypeToken<List<Hero>>(){}.getType();

        Bundle dataBundle = getArguments();
        dataFromApi = new Gson().fromJson(dataBundle.getString("Key1"), collectionType);

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapterListFragment adapter = new ContentAdapterListFragment(recyclerView.getContext(), dataFromApi, getHeroListener());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public TextView name;
        public TextView description;
        public Context context;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            avator = itemView.findViewById(R.id.list_avatar);
            name = itemView.findViewById(R.id.list_title);
            description = itemView.findViewById(R.id.list_desc);
            context = itemView.getContext();
        }
    }



    private ContentAdapterListFragment.OnItemClickListener getHeroListener(){
        return new ContentAdapterListFragment.OnItemClickListener(){
            @Override
            public void onItemClick(Hero item){
                Intent intent = new Intent(getContext(),CaracteristiqueActivity.class);
                Gson gson = new Gson();
                intent.putExtra("CLE",gson.toJson(item));
                startActivity(intent);
            }
        };
    }

}