package com.example.teeshirt.drinksapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Talk extends ActionBarActivity {
    private RadioGroup tasteGroup;
     private RadioButton radio, sweet, spicy, woody,dry;
    private Button tasteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);

        tasteGroup = (RadioGroup)findViewById(R.id.tasteGroup);
        sweet = (RadioButton)findViewById(R.id.sweet);
        spicy = (RadioButton)findViewById(R.id.spicy);
        woody = (RadioButton)findViewById(R.id.woody);
        dry = (RadioButton)findViewById(R.id.dry);

        TextView txtWhat = (TextView) findViewById(R.id.txtWhat);
        tasteBtn = (Button)findViewById(R.id.tasteBtn);

        tasteBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected = tasteGroup.getCheckedRadioButtonId();
                        radio = (RadioButton) findViewById(selected);
                        String taste = radio.getText().toString();
                        Intent intent = new Intent(Talk.this,Aroma.class);
                        intent.putExtra("taste",taste);
                        startActivity(intent);
                    }
                }
        );

        Typeface font = Typeface.createFromAsset(getAssets(), "raleway.ttf");
        txtWhat.setTypeface(font);
        sweet.setTypeface(font);
        tasteBtn.setTypeface(font);

    }

}
