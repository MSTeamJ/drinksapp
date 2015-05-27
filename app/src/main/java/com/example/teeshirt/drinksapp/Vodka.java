package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Vodka extends ListActivity {
    private VodkaAdapter vodkaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vodka);

        vodkaAdapter = new VodkaAdapter(this);
        vodkaAdapter.setImageKey("image");
        vodkaAdapter.setTextKey("name");

        setListAdapter(vodkaAdapter);

        final ListView listView = (ListView)findViewById(android.R.id.list);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object val = listView.getItemAtPosition(position);
                        Drink selected = (Drink) val;
                        String nom = selected.getName();

                        Intent intent = new Intent(getApplicationContext(), Details.class);
                        intent.putExtra("drinkname", nom);
                        startActivity(intent);
                    }
                }
        );
    }


}
