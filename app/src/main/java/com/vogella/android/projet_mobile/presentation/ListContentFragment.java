package com.vogella.android.projet_mobile.presentation;

import android.content.Context;
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
        //
        Bundle dataBundle = getArguments();
        dataFromApi = new Gson().fromJson(dataBundle.getString("Key1"), collectionType);

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext(), dataFromApi);
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
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            name = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);
            context = itemView.getContext();
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
        /*private final String[] mPlaces;
        private final String[] mPlaceDesc;
        private final Drawable[] mPlaceAvators;*/
        public ContentAdapter(Context context, List<Hero> input) {
            this.dataFromApi = input;
            Resources resources = context.getResources();
            /*mPlaces = resources.getStringArray(R.;
            mPlaceDesc = resources.getStringArray(R.array.place_desc);
            TypedArray a = resources.obtainTypedArray(R.array.place_avator);
            mPlaceAvators = new Drawable[a.length()];
            for (int i = 0; i < mPlaceAvators.length; i++) {
                mPlaceAvators[i] = a.getDrawable(i);
            }
            a.recycle();*/
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Hero current_Hero =dataFromApi.get(position);
            final String classe=Classe_reel(current_Hero.getClasse());

            Picasso.with(holder.context).load(current_Hero.getImg_min()).into(holder.avator);
            holder.name.setText(current_Hero.getName());
            holder.description.setText("classe: "+ classe);
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

        @Override
        public int getItemCount() {
            return dataFromApi.size();
        }
    }

}