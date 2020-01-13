package com.example.appturismo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appturismo.R;
import com.example.appturismo.models.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.MyViewHolder> {

    Context context;
    List<Place> mData;
    PlaceItemClickListener placeItemClickListener;

    public PlaceAdapter(Context context, List<Place> mData, PlaceItemClickListener listener) {
        this.context = context;
        this.mData = mData;
        placeItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.place_item, viewGroup, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.TvTitle.setText(mData.get(i).getTitle());
        myViewHolder.ImgPlace.setImageResource(mData.get(i).getThumnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        private TextView TvTitle;
        private ImageView ImgPlace;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TvTitle = itemView.findViewById(R.id.item_place_title);
            ImgPlace = itemView.findViewById(R.id.item_place_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    placeItemClickListener.onplaceClick(mData.get(getAdapterPosition()), ImgPlace);
                }
            });
        }
    }
}
