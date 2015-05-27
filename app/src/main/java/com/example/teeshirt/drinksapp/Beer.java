package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class Beer extends ListActivity {

    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);




        customAdapter = new CustomAdapter(this);
        customAdapter.setTextKey("name");
        customAdapter.setImageKey("image");

        setListAdapter(customAdapter);

    }


}


/*
final ParseObject beer = new ParseObject("Drink");
ParseQuery<Drink> query = ParseQuery.getQuery("Drink");
query.whereEqualTo("category","beer");
        query.findInBackground(new FindCallback<Drink>() {
@Override
public void done(List<Drink> list, ParseException e) {
        if (e==null){
        String name= beer.getString("name");

        }
        }
        });*/
