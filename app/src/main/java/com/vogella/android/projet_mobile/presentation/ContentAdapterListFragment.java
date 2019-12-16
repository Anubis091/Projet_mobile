package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.model.Hero;

import java.util.List;

public  class ContentAdapterListFragment extends RecyclerView.Adapter<ListContentFragment.ViewHolder> {
    private final OnItemClickListener listener;

    List<Hero> dataFromApi;


    public interface OnItemClickListener{
        void onItemClick(Hero item);
    }
    public ContentAdapterListFragment(Context context, List<Hero> input, OnItemClickListener heroListener) {
        this.dataFromApi = input;
        Resources resources = context.getResources();
        this.listener=heroListener;

    }

    @Override
    public ListContentFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListContentFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }



    @Override
    public void onBindViewHolder(ListContentFragment.ViewHolder holder, int position) {
        final Hero current_Hero =dataFromApi.get(position);
        final String classe=Classe_reel(current_Hero.getClasse());

        Picasso.with(holder.context).load(current_Hero.getImg_min()).into(holder.avator);
        holder.name.setText(current_Hero.getName());
        holder.description.setText("classe: "+ classe);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.onItemClick(current_Hero);
            }
        });
    }

    public String Classe_reel(int classe){

        if (classe==0){
            return "Guerrier defensif";

        }
        else if (classe==1){
            return "Guerrier offensif";
        }

        else if (classe==2){
            return "Soutien";
        }

        else if (classe==3){
            return "Soigneur";
        }
        else if (classe==4){
            return "Assassin mélée";
        }
        else if (classe==5){
            return "Assassin distance";
        }
        return "";


    }
    @Override
    public int getItemCount() {
        return dataFromApi.size();
    }
}

