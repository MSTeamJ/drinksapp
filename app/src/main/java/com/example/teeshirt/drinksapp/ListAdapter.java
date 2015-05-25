package com.example.teeshirt.drinksapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by teeshirt on 5/25/15.
 */
public class ListAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] categories;
    private final Integer[] icons;

    public ListAdapter(Activity context, String[] categories, Integer[] icons){
        super(context, R.layout.list_item,categories);
        this.context = context;
        this.categories = categories;
        this.icons = icons;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView txt = (TextView)rowView.findViewById(R.id.txt);
        ImageView img = (ImageView)rowView.findViewById(R.id.img);

        /*Typeface font = Typeface.createFromAsset(context.getAssets(), "OpenSans.ttf");
        txt.setTypeface(font);
*/
        txt.setText(categories[position]);
        img.setImageResource(icons[position]);

        return rowView;
    }
}
