package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


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


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}

