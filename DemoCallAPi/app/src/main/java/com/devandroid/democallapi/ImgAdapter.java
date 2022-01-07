package com.devandroid.democallapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {
Context context;
List<IMG> list;

    public ImgAdapter(Context context) {
        this.context = context;

    }

    public void setList(List<IMG> list) {
        this.list = list;
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImgAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemimg,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ImgAdapter.ViewHolder holder, int position) {
       IMG img=list.get(position);
       holder.id.setText(String.valueOf(img.getId()));
       holder.tieude.setText(img.getTitle());
        Picasso.get().load(img.getUrl()).fit().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView id,tieude;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_img);
            id=itemView.findViewById(R.id.item_id);
            tieude=itemView.findViewById(R.id.item_title);
        }
    }
}
