package com.example.teeshirt.drinksapp;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Drink")
public class Drink extends ParseObject{
    public Drink(){

    }

    public String getName() {
        return getString("name");
    }
    public void setName(String name) {
        put("name",name);
    }


    public String getCategory() {
        return getString("category");
    }
    public void setCategory(String category) {
        put("category",category);
    }


    public String getDescription() {
        return getString("description");
    }
    public void setDescription(String description) {
        put("description",description);
    }


    public Integer getPrice() {
        return getInt("price");
    }
    public void setPrice(int price) {
         put("price",price);
    }


    public ParseFile getImage() {
        return getParseFile("image");
    }
    public void setImage(ParseFile image) {
        put("image", image);
    }

}
