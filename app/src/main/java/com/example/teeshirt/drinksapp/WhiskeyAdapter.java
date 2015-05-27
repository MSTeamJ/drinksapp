package com.example.teeshirt.drinksapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

/**
 * Created by teeshirt on 5/27/15.
 */
public class WhiskeyAdapter extends ParseQueryAdapter<Drink> {
    public WhiskeyAdapter(Context context){
        super(context, new ParseQueryAdapter.QueryFactory<Drink>(){
            public ParseQuery<Drink> create(){
                ParseQuery query = new ParseQuery("Drink");
                query.whereEqualTo("category","Whiskey");
                return query;
            }
        });
    }

    @Override
    public View getItemView(Drink drink, View v, ViewGroup parent) {
        if (v==null){
            v = View.inflate(getContext(),R.layout.rowview,null);
        }

        super.getItemView(drink, v, parent);

        ParseImageView icon = (ParseImageView) v.findViewById(android.R.id.icon);
        ParseFile imageFile = drink.getParseFile("image");

        if (imageFile!=null){
            icon.setParseFile(imageFile);
            icon.loadInBackground();
        }

        TextView text1 = (TextView) v.findViewById(R.id.text1);
        text1.setText(drink.getString("name"));


        return v;
    }
}
