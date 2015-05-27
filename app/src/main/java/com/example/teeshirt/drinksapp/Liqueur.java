package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Liqueur extends ListActivity {
    private LiqueurAdapter liqueurAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liqueur);

        liqueurAdapter = new LiqueurAdapter(this);
        liqueurAdapter.setImageKey("image");
        liqueurAdapter.setTextKey("name");

        setListAdapter(liqueurAdapter);
    }


}
