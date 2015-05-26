package com.example.teeshirt.drinksapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class Drinkclasses extends ActionBarActivity {
    ListView drinkslist;
    String[] categories = {"Beer","Brandy","Gin","Liqueur","Rum","Tequilla","Vodka","Whiskey","Wine"};
    Integer[] icons = {R.drawable.beer, R.drawable.brandy, R.drawable.gin, R.drawable.liqueur, R.drawable.rum, R.drawable.tequilla,R.drawable.vodka, R.drawable.whiskey, R.drawable.wine};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkclasses);


        drinkslist = (ListView)findViewById(R.id.drinkslist);
        ListAdapter adapter = new ListAdapter(Drinkclasses.this, categories, icons);
        drinkslist.setAdapter(adapter);
    }


}
