package com.example.teeshirt.drinksapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;


public class Drinkclasses extends ActionBarActivity {
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

        drinkslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();

                switch(position){
                    case 0:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","beer");
                        break;

                    case 1:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","brandy");
                        break;

                    case 2:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","gin");
                        break;

                    case 3:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","liqueur");
                        break;

                    case 4:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","rum");
                        break;

                    case 5:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","tequilla");
                        break;

                    case 6:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","vodka");
                        break;

                    case 7:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","whiskey");
                        break;

                    case 8:
                        intent = new Intent(getBaseContext(), Drinktype.class);
                        intent.putExtra("frag","wine");
                        break;
                }
                startActivity(intent);
            }
        });
    }


}
