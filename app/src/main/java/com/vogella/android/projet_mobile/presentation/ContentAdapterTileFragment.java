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

public class ContentAdapterTileFragment extends RecyclerView.Adapter<TileContentFragment.ViewHolder> {
    List<Hero> dataFromApi;
    private  final OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Hero item);
    }


    public ContentAdapterTileFragment(Context context, List<Hero> input, OnItemClickListener heroListener) {
        this.dataFromApi = input;
        Resources resources = context.getResources();
        this.listener = heroListener;

    }

    @Override
    public TileContentFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TileContentFragment.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(TileContentFragment.ViewHolder holder, int position) {
        final Hero current_Hero = dataFromApi.get(position);
        Picasso.with(holder.context).load(current_Hero.getImg_min()).into(holder.picture);
        holder.name.setText(current_Hero.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(current_Hero);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataFromApi.size();
    }
}

