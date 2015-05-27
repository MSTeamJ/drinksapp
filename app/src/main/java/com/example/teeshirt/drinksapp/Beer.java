package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.os.Bundle;


public class Beer extends ListActivity {

    private BeerAdapter beerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);




        beerAdapter = new BeerAdapter(this);
        beerAdapter.setTextKey("name");
        beerAdapter.setImageKey("image");

        setListAdapter(beerAdapter);

    }


}


/*
final ParseObject beer = new ParseObject("Drink");
ParseQuery<Drink> query = ParseQuery.getQuery("Drink");
query.whereEqualTo("category","beer");
        query.findInBackground(new FindCallback<Drink>() {
@Override
public void done(List<Drink> list, ParseException e) {
        if (e==null){
        String name= beer.getString("name");

        }
        }
        });*/
