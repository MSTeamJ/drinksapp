package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

import mehdi.sakout.fancybuttons.FancyButton;


public class Latest extends ListActivity {

    private ParseQueryAdapter<Drink> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest);

        adapter=new ParseQueryAdapter<Drink>(this, Drink.class);
        adapter.setTextKey("name");
        //adapter.setTextKey("category");
        adapter.setImageKey("image");

        setListAdapter(adapter);


        FancyButton all = (FancyButton)findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Latest.this, Drinkclasses.class);
                startActivity(i);
            }
        });


    }


}


/*
ArrayList<String> drinks = new ArrayList<String>();
final ArrayAdapter<String> drinksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1);
ListView list = (ListView)findViewById(android.R.id.list);

list.setAdapter(drinksAdapter);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Drink");
        query.findInBackground(new FindCallback<ParseObject>() {
@Override
public void done(List<ParseObject> drinksObj, ParseException e) {
        if (e == null) {
        for (int i = 0; i < drinksObj.size(); i++) {
        String name = drinksObj.get(i).getString("name");
        String category = drinksObj.get(i).getString("category");
        ParseFile image = drinksObj.get(i).getParseFile("image");

        drinksAdapter.add(name);
        drinksAdapter.add(category);
        //drinksAdapter.add(image);
        }
        }
        }
        });*/
