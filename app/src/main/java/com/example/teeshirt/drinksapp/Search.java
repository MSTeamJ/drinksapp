package com.example.teeshirt.drinksapp;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class Search extends ActionBarActivity {
    private EditText etSearch;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        etSearch.setTypeface(font);
        btnSearch.setTypeface(font);
        

    }


}
