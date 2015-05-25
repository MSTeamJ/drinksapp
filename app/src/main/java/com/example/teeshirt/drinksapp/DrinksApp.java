package com.example.teeshirt.drinksapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by teeshirt on 5/25/15.
 */
public class DrinksApp  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Drink.class);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "rX8Lvsu6lSbJtNBv68dau6PXdwBIIxpat5yhb8Oi", "8mSAWHT06DWuziC80L8K0NQ2g5tvC90c9x7cFwuq");

    }
}
