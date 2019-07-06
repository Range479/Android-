package com.example.starbuzz;

public class Drink {
    private String name; //名字
    private String description; //描述
    private int imageResourceId; //图片资源ID
    public static final Drink[] drinks = { //所有饮料的信息
            new Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter),
    };

    public Drink(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }

}
