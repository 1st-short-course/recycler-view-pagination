package com.example.rathana.recyclerview_demo.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.recyclerview_demo.R;

public class FruitViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView,btnLike,btnBookmark,btnMenu;
    public TextView title;


    public FruitViewHolder(View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imageView);
        title=itemView.findViewById(R.id.title);
        btnLike=itemView.findViewById(R.id.favorite);
        btnBookmark =itemView.findViewById(R.id.bookmark);
        btnMenu=itemView.findViewById(R.id.menu);
    }

}
