package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Gin extends ListActivity {
    private GinAdapter ginAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gin);

        ginAdapter = new GinAdapter(this);
        ginAdapter.setImageKey("image");
        ginAdapter.setTextKey("name");

        setListAdapter(ginAdapter);
    }


}
