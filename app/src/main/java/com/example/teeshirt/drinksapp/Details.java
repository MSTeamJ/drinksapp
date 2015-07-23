package com.example.teeshirt.drinksapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.view.WindowManager;
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
    public Bundle namebundle, tokenbundle;
    private String drinkname, twToken;
    private TextView nom, price, desc, pricelabel,rater;
    private ParseImageView parseImageView;
    private RatingBar rating;

    private EditText etComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        loadDetails();
        commenting();
    }


    public  void  loadDetails(){
        namebundle = getIntent().getExtras();
        if (namebundle!=null){
            drinkname = namebundle.getString("drinkname");
        }

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc107")));
        getActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + drinkname + "</font>"));
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        getActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

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
    }



    public void commenting(){
        tokenbundle=getIntent().getExtras();
        if (tokenbundle!=null){
            twToken=tokenbundle.getString("activetoken");
        }

        etComment = (EditText)findViewById(R.id.etComment);
        etComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (twToken==null || twToken.equals("")){
                    Intent intent = new Intent(Details.this, TwitterLogin.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Details.this, twToken, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

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
    protected void onRestart() {
        loadDetails();
        commenting();
    }
}

