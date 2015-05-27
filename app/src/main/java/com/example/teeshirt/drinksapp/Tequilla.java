package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Tequilla extends ListActivity {
    private TequillaAdapter tequillaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tequilla);

        tequillaAdapter = new TequillaAdapter(this);
        tequillaAdapter.setImageKey("image");
        tequillaAdapter.setTextKey("name");

        setListAdapter(tequillaAdapter);
    }


}
