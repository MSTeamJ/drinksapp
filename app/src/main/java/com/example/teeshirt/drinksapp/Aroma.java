package com.example.teeshirt.drinksapp;

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


public class Aroma extends ActionBarActivity {
    private RadioGroup aromaGroup;
    private RadioButton radio, floral, citrus, woody, malty;
    public Bundle taste;
    public String drinkTaste;
    public Button aromaBtn;
    public TextView txtAroma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aroma);

        taste = getIntent().getExtras();
        if (taste!=null){
            drinkTaste = taste.getString("taste");
            Toast.makeText(Aroma.this, drinkTaste, Toast.LENGTH_SHORT).show();

            txtAroma = (TextView) findViewById(R.id.txtAroma);

            floral = (RadioButton) findViewById(R.id.floral);
            woody = (RadioButton) findViewById(R.id.woody);
            citrus = (RadioButton) findViewById(R.id.citrus);
            malty = (RadioButton) findViewById(R.id.malty);

            aromaGroup = (RadioGroup) findViewById(R.id.aromaGroup);
            aromaBtn = (Button) findViewById(R.id.aromaBtn);

            Typeface typeface = Typeface.createFromAsset(getAssets(), "raleway.ttf");
            floral.setTypeface(typeface);
            woody.setTypeface(typeface);
            citrus.setTypeface(typeface);
            malty.setTypeface(typeface);
            txtAroma.setTypeface(typeface);
            aromaBtn.setTypeface(typeface);

            aromaBtn.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int selected = aromaGroup.getCheckedRadioButtonId();
                            radio = (RadioButton) findViewById(selected);
                            Toast.makeText(Aroma.this, radio.getText().toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aroma, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
