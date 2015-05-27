package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Beer extends ListActivity {

    private BeerAdapter beerAdapter;


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
                        //Toast.makeText(Beer.this, nom, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Details.class);
                        intent.putExtra("drinkname", nom);
                        startActivity(intent);
                    }
                }
        );
    }


}

