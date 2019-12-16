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

public class MyAdapterMap extends RecyclerView.Adapter<MyAdapterMap.CelluleJava> {
    private Context context;
    private List<Hero> listValues;


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
    public MyAdapterMap(List<Hero> listValues, Context context) {
        this.listValues = listValues;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapterMap.CelluleJava onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyAdapterMap.CelluleJava vh = new MyAdapterMap.CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyAdapterMap.CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Hero currentHero = listValues.get(position);

        final String name = currentHero.getName();
        final String classe=Classe_reel(currentHero.getClasse());

        holder.txtHeader.setText(name);
        holder.txtFooter.setText("Classe: " + classe);

        Picasso.with(context).load(currentHero.getImg_min()).resize(104,201).into(holder.image);
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
            return "Assassin en mélée";
        }
        else if (classe==5){
            return "Assassin distance";
        }
        return "";


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }

}