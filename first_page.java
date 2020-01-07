package com.example.jallu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

/* Veera A. */

public class first_page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public static final String EXTRA = "Extra";
    public static final String TAG = "Tag";
    public static final String SAVE = "Tallennettu";
    private ImageView etusivu;
    private ImageView laskuri;
    private ImageView kysely;
    private ImageView tietoa;
    private TextView kaynnit;
    private Value valueKaynnit;
    private int message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        radioGroup = findViewById(R.id.group);

        /* Setting menu items to invisible as default */

        etusivu = findViewById(R.id.etusivu2);
        etusivu.setVisibility(View.INVISIBLE);
        laskuri = findViewById(R.id.laskuri2);
        laskuri.setVisibility(View.INVISIBLE);
        kysely = findViewById(R.id.kysely2);
        kysely.setVisibility(View.INVISIBLE);
        tietoa = findViewById(R.id.tietoa2);
        tietoa.setVisibility(View.INVISIBLE);
        kaynnit = findViewById(R.id.kaynnit);
        kaynnit.setVisibility(View.INVISIBLE);

        /* Recieving value from final page */

        Bundle intent = getIntent().getExtras();
        message = intent != null ? intent.getInt(final_page.EXTRA, 0) : 0;

        SharedPreferences prefGet = getSharedPreferences(SAVE, Activity.MODE_PRIVATE);
        valueKaynnit = new Value(prefGet.getInt("kaynnitValue", 0));

        if (valueKaynnit.getValue() != 0) {
            Log.d(TAG, "Value not empty");

            /* Sending user back to final page if gallup has been filled */

            Intent nextActivity = new Intent(first_page.this, final_page.class);
            nextActivity.putExtra(EXTRA, message);
            nextActivity.putExtra(EXTRA, valueKaynnit.getValue());
            startActivity(nextActivity);
        }else{
            Log.d(TAG, "Value is empty");
        }

        /* Counting the visits on the page */

        valueKaynnit.plusItem(message);
        kaynnit.setText(Integer.toString(valueKaynnit.getValue()));
    }

    /* Saving the visiting value */

    public void onPause(){
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(SAVE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("kaynnitValue", message);
        prefEditor.apply();
    }

    /* Send button */

    public void nextPage(View v){
        if (radioGroup.getCheckedRadioButtonId() == R.id.kaksi){
            /* Send the info forward */

            Log.d(TAG, "Weak send");
            Intent nextActivity = new Intent(first_page.this, second_page.class);
            int heikko = 10;
            nextActivity.putExtra(EXTRA, heikko);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.kolme){
            /* Send the info forward */

            Log.d(TAG, "Medium send");
            Intent nextActivity = new Intent(first_page.this, second_page.class);
            int keski = 16;
            nextActivity.putExtra(EXTRA, keski);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.nelja){
            /* Send the info forward */

            Log.d(TAG, "Strong send");
            Intent nextActivity = new Intent(first_page.this, second_page.class);
            int vahva = 24;
            nextActivity.putExtra(EXTRA, vahva);
            startActivity(nextActivity);
        }else{
            Log.d(TAG, "Couldn't send");
        }
    }

    /* Menu */

    public void clickedMenu (View v){

        /* Checking the visibility status */

        if (etusivu.getVisibility() == View.VISIBLE) {

            etusivu.setVisibility(View.INVISIBLE);
            laskuri.setVisibility(View.INVISIBLE);
            kysely.setVisibility(View.INVISIBLE);
            tietoa.setVisibility(View.INVISIBLE);

        } else if (etusivu.getVisibility() == View.INVISIBLE) {
            etusivu.setVisibility(View.VISIBLE);
            laskuri.setVisibility(View.VISIBLE);
            kysely.setVisibility(View.VISIBLE);
            tietoa.setVisibility(View.VISIBLE);
        }
    }

    /* Moving to other page by menu */

    public void clickedEtusivu (View v){
        if (etusivu.getVisibility() == View.VISIBLE){
            startActivity(new Intent(this, EtusivuActivity.class));
        }
    }

    public void clickedLaskuri (View v) {
        if (laskuri.getVisibility() == View.VISIBLE) {
            startActivity(new Intent(this, antidarra.class));
        }
    }

    public void clickedKysely (View v) {
        if (kysely.getVisibility() == View.VISIBLE) {
            startActivity(new Intent(this, first_page.class));
        }
    }

    public void clickedTietoa (View v) {
        if (tietoa.getVisibility() == View.VISIBLE) {
            startActivity(new Intent(this, tietoa.class));
        }
    }
}
