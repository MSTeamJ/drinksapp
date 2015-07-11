package com.example.teeshirt.drinksapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;


public class Drinkclasses extends Activity {
    ActionBar actionBar;
    ListView drinkslist;
    String[] categories = {"Beer","Brandy","Gin","Liqueur","Rum","Tequilla","Vodka","Whiskey","Wine"};
    Integer[] icons = {R.drawable.beer, R.drawable.brandy, R.drawable.gin, R.drawable.liqueur, R.drawable.rum, R.drawable.tequilla,R.drawable.vodka, R.drawable.whiskey, R.drawable.wine};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkclasses);


        drinkslist = (ListView)findViewById(R.id.drinkslist);
        ListAdapter adapter = new ListAdapter(Drinkclasses.this, categories, icons);
        drinkslist.setAdapter(adapter);

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc107")));
        getActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + "Categories" + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));



        drinkslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();

                switch(position){
                    case 0:
                        intent = new Intent(getBaseContext(), Beer.class);
                        break;

                    case 1:
                        intent = new Intent(getBaseContext(), Brandy.class);
                        break;

                    case 2:
                        intent = new Intent(getBaseContext(), Gin.class);
                        break;

                    case 3:
                        intent = new Intent(getBaseContext(), Liqueur.class);
                        break;

                    case 4:
                        intent = new Intent(getBaseContext(), Rum.class);
                        break;

                    case 5:
                        intent = new Intent(getBaseContext(), Tequilla.class);
                        break;

                    case 6:
                        intent = new Intent(getBaseContext(), Vodka.class);
                        break;

                    case 7:
                        intent = new Intent(getBaseContext(), Whiskey.class);
                        break;

                    case 8:
                        intent = new Intent(getBaseContext(), Wine.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }


}
