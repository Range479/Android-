package com.example.bitsandpizzas2;

public class Pizza {

    private String name;
    private int imageResourceId;

    public static final Pizza[] pizzas = {
            new Pizza("Diavolo",(int)R.drawable.diavolo),
            new Pizza("Funghi", (int)R.drawable.funghi)
    };

    private Pizza(String name, int imageResourceId){
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName(){
        return this.name;
    }

    public int getImageResourceId(){
        return this.imageResourceId;
    }
}
