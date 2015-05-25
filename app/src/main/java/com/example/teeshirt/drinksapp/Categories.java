package com.example.teeshirt.drinksapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;




public class Categories extends ActionBarActivity {
    ListView listView;
    String[] categories = {"Beer","Brandy","Gin","Liqueur","Rum","Tequilla","Vodka","Whiskey","Wine"};
    Integer[] icons = {R.drawable.beer, R.drawable.brandy, R.drawable.gin, R.drawable.liqueur, R.drawable.rum, R.drawable.tequilla,R.drawable.vodka, R.drawable.whiskey, R.drawable.wine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        listView = (ListView)findViewById(R.id.listView);
        ListAdapter adapter = new ListAdapter(Categories.this, categories, icons);

        listView.setAdapter(adapter);

    }


}
