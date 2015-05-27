package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Wine extends ListActivity {

    private WineAdapter wineAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);

        wineAdapter = new WineAdapter(this);
        wineAdapter.setImageKey("image");
        wineAdapter.setTextKey("name");

        setListAdapter(wineAdapter);
    }


}
