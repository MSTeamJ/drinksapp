package com.example.teeshirt.drinksapp;


import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.text.ParseException;


public class BeerFragment extends Fragment{
    Context myContext;

    public BeerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ListView listView = (ListView)container.findViewById(android.R.id.list);
        CustomAdapter adapter = new CustomAdapter(getActivity());

        listView.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_beer, container, false);
    }







}


/*public void getBeer(){

        ParseQueryAdapter<ParseObject> beerAdapter = new ParseQueryAdapter<ParseObject>(getActivity(),"Drink" );
        beerAdapter.setTextKey("name");
        beerAdapter.setImageKey("image");

        setListAdapter(beerAdapter);


    }
*/