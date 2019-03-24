package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.model.Hero;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
    private  final OnItemClickListener listener;
    private Context context;
    private List<Hero> listValues;

    public interface OnItemClickListener{
        void onItemClick(Hero item);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader =  v.findViewById(R.id.firstLine);
            txtFooter =  v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Hero> listValues, Context context, OnItemClickListener listener) {
        this.listValues = listValues;
        this.context=context;
        this.listener=listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Hero currentHero = listValues.get(position);

        final String name = currentHero.getName();
        final String classe=Classe_reel(currentHero.getClasse());

        holder.txtHeader.setText(name);
        holder.txtFooter.setText("Classe: " + classe);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentHero);
            }
        });
        Picasso.with(context).load(currentHero.getImg_min()).resize(104,201).into(holder.image);
    }
    public String Classe_reel(int classe){

        if (classe==0 || classe==4){
            return "Guerrier";

        }
        else if (classe==1){
            return "Support";
        }

        else if (classe==2){
            return "Assassin";
        }

        else if (classe==3){
            return "Spécialiste";
        }
        return "";


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }

}