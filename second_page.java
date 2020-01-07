package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class second_page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public static final String EXTRA = "Extra";
    public static final String TAG = "Tag";
    private int message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        radioGroup = findViewById(R.id.group);

        /* Getting the last page's info */

        Bundle intent = getIntent().getExtras();
        message = intent.getInt(first_page.EXTRA, 0);
    }

    /* Button */

    public void nextPage(View v){
        if (radioGroup.getCheckedRadioButtonId() == R.id.yksi) {
            /* Send the info forward */

            Log.d(TAG, "One send");
            Intent nextActivity = new Intent(second_page.this, third_page.class);
            int little = message + 5;
            nextActivity.putExtra(EXTRA, little);
            startActivity(nextActivity);
        }else if (radioGroup.getCheckedRadioButtonId() == R.id.kaksi){
            /* Send the info forward */

            Log.d(TAG, "Two send");
            Intent nextActivity = new Intent(second_page.this, third_page.class);
            int heikko = message + 10;
            nextActivity.putExtra(EXTRA, heikko);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.kolme){
            /* Send the info forward */

            Log.d(TAG, "Three send");
            Intent nextActivity = new Intent(second_page.this, third_page.class);
            int keski = message + 15;
            nextActivity.putExtra(EXTRA, keski);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.nelja){
            /* Send the info forward */

            Log.d(TAG, "Four send");
            Intent nextActivity = new Intent(second_page.this, third_page.class);
            int vahva = message + 20;
            nextActivity.putExtra(EXTRA, vahva);
            startActivity(nextActivity);
        }else{
            Log.d(TAG, "Couldn't send");
        }
    }
}
