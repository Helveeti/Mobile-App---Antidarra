package com.example.jallu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

/* Veera A. */

public class seventh_page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public static final String EXTRA = "Extra";
    public static final String TAG = "Tag";
    public static final String SAVE = "Tallennettu";
    private int message;
    private TextView value;
    private Value valueArvot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_page);
        radioGroup = findViewById(R.id.group);
        value = findViewById(R.id.arvo);
        value.setVisibility(View.INVISIBLE);

        /* Getting the last page's info */

        Bundle intent = getIntent().getExtras();
        message = intent.getInt(sixth_page.EXTRA, 0);

        /* Printing the value */

        SharedPreferences prefGet = getSharedPreferences(EXTRA, Activity.MODE_PRIVATE);
        valueArvot = new Value(prefGet.getInt("kaynnitValue", 0));
        value.setText(Integer.toString(message));
    }

    /* Saving the value */

    public void onPause(){
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(SAVE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("kaynnitValue", valueArvot.getValue());
        prefEditor.putInt("Message", message);
        prefEditor.apply();
    }

    /* Button */

    public void nextPage(View v) {
        if (radioGroup.getCheckedRadioButtonId() == R.id.yksi) {
            /* Send the info forward and to first_page */

            Log.d(TAG, "None send");
            Intent nextActivity = new Intent(seventh_page.this, final_page.class);
            int none = message;
            nextActivity.putExtra(EXTRA, none);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.kaksi) {
            /* Send the info forward and to first_page */

            Log.d(TAG, "Pari kertaa send");
            Intent nextActivity = new Intent(seventh_page.this, final_page.class);
            int pari = message + 5;
            nextActivity.putExtra(EXTRA, pari);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.kolme) {
            /* Send the info forward and to first_page */

            Log.d(TAG, "Viikko send");
            Intent nextActivity = new Intent(seventh_page.this, final_page.class);
            int viikko = message + 15;
            nextActivity.putExtra(EXTRA, viikko);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.nelja) {
            /* Send the info forward and to first_page */

            Log.d(TAG, "Pari vko send");
            Intent nextActivity = new Intent(seventh_page.this, final_page.class);
            int parivko = message + 30;
            nextActivity.putExtra(EXTRA, parivko);
            startActivity(nextActivity);
        } else {
            Log.d(TAG, "Couldn't send");
        }
    }
}
