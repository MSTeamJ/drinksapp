package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Rum extends ListActivity {
    private RumAdapter rumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rum);

        rumAdapter = new RumAdapter(this);
        rumAdapter.setImageKey("image");
        rumAdapter.setTextKey("name");

        setListAdapter(rumAdapter);
    }


}
