package com.example.proiect.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proiect.R;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ViewHolder> {

    Context context;
    String[] descriptions;
    int[] imagepngs;


    @NonNull
    @Override
    public CardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tile_card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardsAdapter.ViewHolder holder, int position) {
    holder.description.setText(descriptions[position]);
    holder.cardImage.setImageResource(imagepngs[position]);
    }

    @Override
    public int getItemCount() {
        return descriptions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView description;
        ImageView cardImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.card_text);
            cardImage = itemView.findViewById(R.id.card_image);
        }
    }

    public CardsAdapter(Context context, String[] descriptions, int[] imagepngs) {
        this.context = context;
        this.descriptions = descriptions;
        this.imagepngs = imagepngs;
    }
}
