package com.example.teeshirt.drinksapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;


public class CustomAdapter extends ParseQueryAdapter<ParseObject>{
    public CustomAdapter(Context context){
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>(){
            public ParseQuery create(){
                ParseQuery query = new ParseQuery("Drink");
                query.whereEqualTo("category","beer");
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v==null){
            v = View.inflate(getContext(),R.layout.rowview,null);
        }

        super.getItemView(object, v, parent);

        ParseImageView icon = (ParseImageView) v.findViewById(R.id.icon);
        ParseFile imageFile = object.getParseFile("image");

        if (imageFile!=null){
            icon.setParseFile(imageFile);
            icon.loadInBackground();
        }

        TextView text1 = (TextView) v.findViewById(R.id.text1);
        text1.setText(object.getString("name"));


        return v;
    }
}
