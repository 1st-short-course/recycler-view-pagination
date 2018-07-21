package com.example.rathana.recyclerview_demo.data.local;

import com.example.rathana.recyclerview_demo.R;
import com.example.rathana.recyclerview_demo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository {

    private List<Fruit>  fruits =new ArrayList<>();

    public FruitRepository(){
        for(int i=0;i<10;i++){
            fruits.add(new Fruit(i,"Khmer Fruit "+i , R.drawable.grape));
        }
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void addFruitItem(Fruit fruit){
        this.fruits.add(fruit);
    }
    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Fruit> getFruitsByPage( int page){
        List<Fruit> list=new ArrayList<>();
        int newId=page*10;
        for(int i = 0;i<10;i++){
            int id =i+newId;
            list.add(new Fruit(id,"grape  "+id,R.drawable.grape));
        }
        this.fruits.addAll(list);
        return list;
    }

}
