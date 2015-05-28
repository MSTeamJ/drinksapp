package com.example.teeshirt.drinksapp;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;




public class Beer extends ListActivity {

    private BeerAdapter beerAdapter;

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);



        beerAdapter = new BeerAdapter(this);
        beerAdapter.setTextKey("name");
        beerAdapter.setImageKey("image");

        setListAdapter(beerAdapter);

        final ListView listView = (ListView)findViewById(android.R.id.list);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object val = listView.getItemAtPosition(position);
                        Drink selected = (Drink)val;
                        String nom = selected.getName();

                        Intent intent = new Intent(getApplicationContext(), Details.class);
                        intent.putExtra("drinkname", nom);
                        startActivity(intent);
                    }
                }
        );
    }


}

