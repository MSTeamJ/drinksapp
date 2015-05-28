package com.example.teeshirt.drinksapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Search extends ActionBarActivity {
    private EditText etSearch;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = (EditText) findViewById(R.id.etSearch);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        etSearch.setTypeface(font);
        btnSearch.setTypeface(font);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = etSearch.getText().toString();
                Intent intent = new Intent(Search.this, Result.class);
                intent.putExtra("term", searchTerm);
                startActivity(intent);
            }
        });


    }


}
