package com.app.threadvolley.ADAPTER;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.threadvolley.UI.MainActivity;
import com.app.threadvolley.Model.Worldpopulation;
import com.app.threadvolley.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResoponceAdapter extends RecyclerView.Adapter<ResoponceAdapter.MyviewHolder>
{
    MainActivity mainActivity;
    List<Worldpopulation> models ;

    public ResoponceAdapter(MainActivity mainActivity, List<Worldpopulation> models) {
        this.mainActivity = mainActivity;
        this.models = models;
    }

    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.population,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position)
    {
        holder.Rank.setText(String.valueOf(models.get(position).getRank()));
        holder.Population.setText(models.get(position).getPopulation());
        holder.Country.setText(models.get(position).getCountry());
        Picasso.with(mainActivity).load(models.get(position).getFlag()).into(holder.Flag);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public  class MyviewHolder extends RecyclerView.ViewHolder
    {
        TextView Rank,Country,Population;
        ImageView Flag;
        public MyviewHolder(View itemView)
        {
            super(itemView);
            Rank=(TextView)itemView.findViewById(R.id.rank);
            Population=(TextView)itemView.findViewById(R.id.population);
            Country=(TextView)itemView.findViewById(R.id.country);
            Flag=(ImageView)itemView.findViewById(R.id.flag);
        }
    }
}
