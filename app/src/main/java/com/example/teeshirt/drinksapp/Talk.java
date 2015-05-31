package com.example.teeshirt.drinksapp;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;


public class Talk extends ActionBarActivity {

    RadioButton sweet, spicy, woody, dry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);

        TextView txtWhat = (TextView) findViewById(R.id.txtWhat);

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        txtWhat.setTypeface(font);
    }

}
