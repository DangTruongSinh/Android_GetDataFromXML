package com.truongsinh.luyentapgetdatafromxml;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRSS extends RecyclerView.Adapter<AdapterRSS.ViewHolder> {
    ArrayList<ItemRSS> arrayList;
    public AdapterRSS(ArrayList<ItemRSS> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_rss,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ItemRSS itemRSS = arrayList.get(i);

        viewHolder.txt_tieude.setText(itemRSS.getTieude()+"");
        viewHolder.txt_noidung.setText(itemRSS.getNoidung()+"");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_tieude;
        TextView txt_noidung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txt_tieude = itemView.findViewById(R.id.txt_title);
            this.txt_noidung = itemView.findViewById(R.id.txt_noidung);
        }
    }
}
