package com.example.teeshirt.drinksapp;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Wine extends ListActivity {

    private WineAdapter wineAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);

        wineAdapter = new WineAdapter(this);
        wineAdapter.setImageKey("image");
        wineAdapter.setTextKey("name");

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc107")));
        getActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Wine" + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));


        setListAdapter(wineAdapter);

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
