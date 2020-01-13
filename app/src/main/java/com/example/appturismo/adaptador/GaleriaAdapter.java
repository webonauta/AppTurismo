package com.example.appturismo.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appturismo.R;
import com.example.appturismo.modelo.Galeria;

import java.util.List;

public class GaleriaAdapter extends RecyclerView.Adapter<GaleriaAdapter.GaleriaViewHolder> {

    Context mContext;
    List<Galeria>mData;

    public GaleriaAdapter(Context mContext, List<Galeria> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public GaleriaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_galeria, viewGroup, false);
        return new GaleriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GaleriaViewHolder galeriaViewHolder, int i) {
        Glide.with(mContext).load(mData.get(i).getImg_link()).into(galeriaViewHolder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class GaleriaViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        public GaleriaViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.img_galeria);
        }
    }
}
