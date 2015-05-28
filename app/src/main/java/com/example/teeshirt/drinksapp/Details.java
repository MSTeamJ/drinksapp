package com.example.teeshirt.drinksapp;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class Details extends ActionBarActivity {
    public Bundle namebundle;
    private String drinkname;
    private TextView nom, price, desc, pricelabel;
    private ParseImageView parseImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);




        namebundle = getIntent().getExtras();
        if (namebundle!=null){
            drinkname = namebundle.getString("drinkname");
        }

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc107")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + drinkname + "</font>"));
        getSupportActionBar().setElevation(1);
        //nom = (TextView)findViewById(R.id.nom);
        price = (TextView)findViewById(R.id.price);
        desc = (TextView)findViewById(R.id.desc);
        pricelabel = (TextView)findViewById(R.id.pricelabel);

        parseImageView = (ParseImageView)findViewById(R.id.pic);

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        desc.setTypeface(font);
        //nom.setTypeface(font);
        price.setTypeface(font);
        pricelabel.setTypeface(font);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Drink");
        query.whereEqualTo("name", drinkname);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    for (int i=0; i <list.size(); i++){
                        //nom.setText(list.get(i).getString("name"));
                        price.setText(""+list.get(i).getInt("price")+"/-");
                        desc.setText(list.get(i).getString("description"));
                        ParseFile imageFile = list.get(i).getParseFile("image");

                        if (imageFile!=null){
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


}


