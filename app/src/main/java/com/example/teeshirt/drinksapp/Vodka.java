package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Vodka extends ListActivity {
    private VodkaAdapter vodkaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vodka);

        vodkaAdapter = new VodkaAdapter(this);
        vodkaAdapter.setImageKey("image");
        vodkaAdapter.setTextKey("name");

        setListAdapter(vodkaAdapter);
    }


}
