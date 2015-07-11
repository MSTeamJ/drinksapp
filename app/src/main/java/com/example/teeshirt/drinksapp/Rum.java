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


public class Rum extends ListActivity {
    private RumAdapter rumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rum);

        rumAdapter = new RumAdapter(this);
        rumAdapter.setImageKey("image");
        rumAdapter.setTextKey("name");

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc107")));
        getActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Rum" + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        setListAdapter(rumAdapter);

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
