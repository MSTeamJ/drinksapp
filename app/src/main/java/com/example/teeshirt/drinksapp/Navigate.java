package com.example.teeshirt.drinksapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Navigate extends ActionBarActivity {
    private Button search, type, talk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        search = (Button)findViewById(R.id.search);
        type = (Button) findViewById(R.id.type);
        talk = (Button) findViewById(R.id.talk);

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        search.setTypeface(font);
        type.setTypeface(font);
        talk.setTypeface(font);

        type.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Navigate.this, Drinkclasses.class);
                        startActivity(intent);
                    }
                }
        );

        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Navigate.this, Search.class);
                        startActivity(intent);
                    }
                }
        );


        talk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Navigate.this, Talk.class);
                        startActivity(intent);
                    }
                }
        );

    }


}
