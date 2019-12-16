package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.Map;

import java.util.List;

public class ContentAdapterCardFragment extends RecyclerView.Adapter<CardContentFragment.ViewHolder> {
    private final OnItemClickListener listener;
    // Set numbers of List in RecyclerView.
    List<Map> dataMap;
    List<Hero> DataFromApi;

    public interface OnItemClickListener{
        void onItemClick(Map item, List<Hero> dataFromApi);
    }

    public ContentAdapterCardFragment(Context context, List<Map> input,List<Hero> dataFromApi,OnItemClickListener mapListener) {
        this.dataMap=input;
        this.DataFromApi=dataFromApi;
        Resources resources = context.getResources();
        this.listener=mapListener;

    }

    @Override
    public CardContentFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardContentFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(CardContentFragment.ViewHolder holder, int position) {
        final Map current_Map= dataMap.get(position);
        final List<Hero> dataFromApi = DataFromApi;
        Picasso.with(holder.context).load(current_Map.getImage()).into(holder.picture);

        holder.name.setText(current_Map.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(current_Map, dataFromApi);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 14;
    }
}

