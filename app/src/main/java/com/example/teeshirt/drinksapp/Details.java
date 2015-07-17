package com.example.teeshirt.drinksapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.lang.reflect.Field;
import java.util.List;

import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;


public class Details extends Activity {
    public Bundle namebundle;
    private String drinkname;
    private TextView nom, price, desc, pricelabel,rater;
    private ParseImageView parseImageView;
    private RatingBar rating;
    private TwitterLoginButton loginButton;
    private EditText etComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);




        namebundle = getIntent().getExtras();
        if (namebundle!=null){
            drinkname = namebundle.getString("drinkname");
        }

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc107")));
        getActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + drinkname + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getActionBar().setDisplayHomeAsUpEnabled(true);



        price = (TextView)findViewById(R.id.price);
        desc = (TextView)findViewById(R.id.desc);
        pricelabel = (TextView)findViewById(R.id.pricelabel);
        rater = (TextView)findViewById(R.id.rater);


        parseImageView = (ParseImageView)findViewById(R.id.pic);

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        desc.setTypeface(font);
        rater.setTypeface(font);
        price.setTypeface(font);
        pricelabel.setTypeface(font);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Drink");
        query.whereEqualTo("name", drinkname);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < list.size(); i++) {
                        price.setText("" + list.get(i).getInt("price") + "/-");
                        desc.setText(list.get(i).getString("description"));
                        ParseFile imageFile = list.get(i).getParseFile("image");

                        if (imageFile != null) {
                            parseImageView.setParseFile(imageFile);
                            parseImageView.loadInBackground();
                        }

                    }
                } else {
                    Toast.makeText(Details.this, "Sijaget kitu", Toast.LENGTH_LONG).show();
                }
            }
        });

        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });

       // ratingBarListener();
        twitterLogin();

    }


   /* public void ratingBarListener(){
        rating = (RatingBar)findViewById(R.id.rating);
        //txt = (TextView)findViewById(R.id.txt);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Details.this, "You've rated " + drinkname + " " + String.valueOf(rating), Toast.LENGTH_LONG).show();
                disabled();
            }
        });
    }

    public void disabled(){
        rating.setClickable(false);
        rating.setVisibility(RatingBar.GONE);
    }*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    public void twitterLogin(){
        etComment = (EditText)findViewById(R.id.etComment);
        etComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Details.this);
                builder.setMessage("twii").setCancelable(true);

                AlertDialog alert = builder.create();
                alert.setTitle("Twitter Login");
                alert.show();
            }
        });
    }
}


