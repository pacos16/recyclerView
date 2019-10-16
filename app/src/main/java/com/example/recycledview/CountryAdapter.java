package com.example.recycledview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




public class CountryAdapter extends RecyclerView.Adapter {

private Country[] countries;


    public CountryAdapter(Country[] countries) {

        this.countries = countries;

    }
    public static class CountryViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCountry;
        private TextView tvCaptial;
        private TextView tvPopulation;
        private ImageView ivFlag;

        public CountryViewHolder(View itemView){
            super(itemView);
            this.ivFlag= itemView.findViewById(R.id.ivFlag);
            this.tvCountry=  itemView.findViewById(R.id.tvCountry);
            this.tvCaptial= itemView.findViewById(R.id.tvCapital);
            this.tvPopulation= itemView.findViewById(R.id.tvPopulation);
        }
        public void bindCountry(Country country){
            tvCountry.setText(country.getCountryName());
            tvCaptial.setText(country.getCountryCapital());
            tvPopulation.setText(""+country.getCountryPopulation());
            int id = itemView.getContext().getResources().getIdentifier("_"+country.getCountryCode().toLowerCase(),
                    "drawable", ivFlag.getContext().getPackageName());
            ivFlag.setImageResource(id);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country,parent,false);
        return new CountryViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Country country=countries[position];
        CountryViewHolder cvh=(CountryViewHolder)holder;
        cvh.bindCountry(country);

    }

    @Override
    public int getItemCount() {
        return countries.length;
    }
}
