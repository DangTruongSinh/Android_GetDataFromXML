package com.truongsinh.luyentapgetdatafromxml;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {
    ArrayList<Item> arrayList;
    sukien sukien;
    interface sukien{
        void phanhoisukien(int position);
    }
    public AdapterItem(ArrayList<Item> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_cardview,viewGroup,false);
        sukien = (AdapterItem.sukien) viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem.ViewHolder viewHolder, final int i) {
            Item item = arrayList.get(i);
            ImageView imageView = viewHolder.cardView.findViewById(R.id.img_hinh);
            imageView.setImageResource(item.getHinh());
            TextView textView = viewHolder.cardView.findViewById(R.id.txt_tieude);
            textView.setText(item.getStt());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sukien.phanhoisukien(i);
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
