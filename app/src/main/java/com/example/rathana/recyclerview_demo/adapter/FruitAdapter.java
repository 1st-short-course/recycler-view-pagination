package com.example.rathana.recyclerview_demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.rathana.recyclerview_demo.EditFruitActivity;
import com.example.rathana.recyclerview_demo.MainActivity;
import com.example.rathana.recyclerview_demo.R;
import com.example.rathana.recyclerview_demo.adapter.viewholder.FruitViewHolder;
import com.example.rathana.recyclerview_demo.entity.Fruit;

import java.util.List;

public class FruitAdapter  extends RecyclerView.Adapter<FruitViewHolder>{

    private List<Fruit> fruits;
    private Context context;

    public FruitAdapter(Context context) {
        this.context = context;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits=fruits;
    }

    public void updateFruits(List<Fruit> fruits){
        this.fruits.addAll(fruits);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FruitViewHolder holder, int position) {
        Fruit fruit= fruits.get(position);
        if(fruit!=null){
            holder.imageView.setImageResource(fruit.getImage());
            holder.title.setText(fruit.getTitle());
        }

        holder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu=new PopupMenu(context,v);
                menu.inflate(R.menu.popup_menu);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.edit:
                                //intent new screen
                                Intent intent =new Intent(context, EditFruitActivity.class);
                                intent.putExtra("pos",holder.getAdapterPosition());
                                ((AppCompatActivity) context).startActivityForResult(intent, MainActivity.REQUEST_CODE);
                                return true;

                            case R.id.remove:
                                return  true;
                        }
                        return false;
                    }
                });

                menu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.fruits.size();
    }

    public void updateFruit(Fruit fruit) {
        this.fruits.set(fruit.getId(),fruit);
        notifyItemChanged(fruit.getId());
    }
}
