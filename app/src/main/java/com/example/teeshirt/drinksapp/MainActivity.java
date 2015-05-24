package com.example.teeshirt.drinksapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseObject;

import at.markushi.ui.CircleButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "rX8Lvsu6lSbJtNBv68dau6PXdwBIIxpat5yhb8Oi", "8mSAWHT06DWuziC80L8K0NQ2g5tvC90c9x7cFwuq");


        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        CircleButton cb = (CircleButton)findViewById(R.id.cb);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Latest.class);
                startActivity(intent);
            }
        });
    }



}
