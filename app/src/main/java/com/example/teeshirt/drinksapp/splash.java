package com.example.teeshirt.drinksapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class splash extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView splashtext = (TextView)findViewById(R.id.splashtext);
        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        splashtext.setTypeface(font);

        Thread splash = new Thread(){
            public void run(){
                try {
                   sleep(5000);
                    Intent intent = new Intent(splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        splash.start();



    }




}
