package com.example.rathana.recyclerview_demo.data;

import com.example.rathana.recyclerview_demo.data.local.FruitRepository;

public class Database {

    private Database(){}
    private static Database database;
    public static Database getInstance(){
        if(database==null)
            database=new Database();

        return database;
    }

    public FruitRepository getFruitRepository(){
        return new FruitRepository();
    }

}
