package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Brandy extends ListActivity {
    private BrandyAdapter brandyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brandy);

        brandyAdapter = new BrandyAdapter(this);
        brandyAdapter.setImageKey("image");
        brandyAdapter.setTextKey("name");

        setListAdapter(brandyAdapter);
    }


}
