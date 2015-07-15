package com.example.teeshirt.drinksapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;




public class Latest extends Activity {

    private ParseQueryAdapter<Drink> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest);

        TextView dir = (TextView) findViewById(R.id.dir);



        Button all = (Button)findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Latest.this, Navigate.class);
                startActivity(i);
            }
        });


        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        dir.setTypeface(font);
        all.setTypeface(font);

    }


}


