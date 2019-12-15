package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vogella.android.projet_mobile.R;
import com.vogella.android.projet_mobile.model.Hero;
import com.vogella.android.projet_mobile.model.Talent;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter.CelluleJava> {

   // private  final OnItemClickListener listener;
    private Context context;
    private List<Talent> listValues;

   /* public interface OnItemClickListener{
        void onItemClick(Talent item);
    }*/

    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
           // txtHeader = (TextView) v.findViewById(R.id.firstLine);
            //txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }
    public MyAdapter2(List<Talent> listValues, Context context){
        this.listValues=listValues;
        this.context=context;
      //  this.listener=listener;
    }
    @Override
    public MyAdapter.CelluleJava onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.caracteristique_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyAdapter.CelluleJava vh = new MyAdapter.CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyAdapter.CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Talent currentTalent = listValues.get(position);

        final String name = currentTalent.getNom();
        final String description=currentTalent.getDescription();
        //final String image=currentTalent.getImage();

        //holder.txtHeader.setText(name);
       // holder.txtFooter.setText(""+ Html.fromHtml(description));
      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentTalent);
            }
        });*/
      holder.image.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              AlertDialog.Builder builder = new AlertDialog.Builder(context);
              builder.setTitle(name)
                      .setMessage("" + Html.fromHtml(description))
                      .show();
          }
          });



        Picasso.with(context).load(currentTalent.getImage()).resize(189,189).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }

}
