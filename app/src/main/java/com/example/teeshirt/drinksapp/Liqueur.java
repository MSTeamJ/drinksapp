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


public class Liqueur extends ListActivity {
    private LiqueurAdapter liqueurAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liqueur);

        liqueurAdapter = new LiqueurAdapter(this);
        liqueurAdapter.setImageKey("image");
        liqueurAdapter.setTextKey("name");

        setListAdapter(liqueurAdapter);

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
