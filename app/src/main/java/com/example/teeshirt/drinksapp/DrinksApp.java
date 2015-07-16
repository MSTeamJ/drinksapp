package com.example.teeshirt.drinksapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by teeshirt on 5/25/15.
 */
public class DrinksApp  extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "WaWMGDNgKagMEV3V86hF4MUWg";
    private static final String TWITTER_SECRET = "v8dEyGrraAQqwGOqIHq9YW6r8HnGdNW3Xmj8wxqsAuoEXCJdpT";

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        ParseObject.registerSubclass(Drink.class);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "rX8Lvsu6lSbJtNBv68dau6PXdwBIIxpat5yhb8Oi", "8mSAWHT06DWuziC80L8K0NQ2g5tvC90c9x7cFwuq");

    }
}
