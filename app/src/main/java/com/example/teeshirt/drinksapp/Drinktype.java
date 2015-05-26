package com.example.teeshirt.drinksapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Drinktype extends ActionBarActivity {
    public Bundle frag;
    private String fragName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinktype);


        frag = getIntent().getExtras();
        if (frag!=null){
            fragName = frag.getString("frag");
            changeFragment();
        }
    }


    public void changeFragment(){
        Fragment fragment;

        if (fragName.equals("beer")){
            fragment = new BeerFragment();
        }
        else if (fragName.equals("brandy")){
            fragment = new BrandyFragment();
        }
        else if (fragName.equals("gin")){
            fragment = new GinFragment();
        }
        else if (fragName.equals("liqueur")){
            fragment = new LiqueurFragment();
        }
        else if (fragName.equals("rum")){
            fragment = new RumFragment();
        }
        else if (fragName.equals("tequilla")){
            fragment = new TequillaFragment();
        }
        else if (fragName.equals("vodka")){
            fragment = new VodkaFragment();
        }
        else if (fragName.equals("whiskey")){
            fragment = new WhiskeyFragment();
        }
        else{
            fragment = new WineFragment();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragHolder, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
