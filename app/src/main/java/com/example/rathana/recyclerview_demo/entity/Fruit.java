package com.example.rathana.recyclerview_demo.entity;

import android.support.annotation.DrawableRes;

public class Fruit {
    private int id;
    private String title;
    @DrawableRes private int image;

    public Fruit() { }

    public Fruit(int id, String title, int image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
