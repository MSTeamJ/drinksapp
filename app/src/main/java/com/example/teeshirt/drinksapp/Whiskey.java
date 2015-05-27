package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Whiskey extends ListActivity {
    private WhiskeyAdapter whiskeyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whiskey);

        whiskeyAdapter = new WhiskeyAdapter(this);
        whiskeyAdapter.setImageKey("image");
        whiskeyAdapter.setTextKey("name");

        setListAdapter(whiskeyAdapter);
    }


}
