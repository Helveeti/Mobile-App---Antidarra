package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

/* Veera A. */

public class fourth_page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public static final String EXTRA = "Extra";
    public static final String TAG = "Tag";
    private int message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);
        radioGroup = findViewById(R.id.group);

        /* Getting the last page's info */

        Bundle intent = getIntent().getExtras();
        message = intent.getInt(third_page.EXTRA, 0);
    }

    /* Button */

    public void nextPage(View v){
        if (radioGroup.getCheckedRadioButtonId() == R.id.yksi) {
            /* Send the info forward */

            Log.d(TAG, "Vahan send");
            Intent nextActivity = new Intent(fourth_page.this, fifth_page.class);
            int little = message;
            nextActivity.putExtra(EXTRA, little);
            startActivity(nextActivity);
        }else if (radioGroup.getCheckedRadioButtonId() == R.id.kaksi){
            /* Send the info forward */

            Log.d(TAG, "Weak send");
            Intent nextActivity = new Intent(fourth_page.this, fifth_page.class);
            int heikko = message + 5;
            nextActivity.putExtra(EXTRA, heikko);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.kolme){
            /* Send the info forward */

            Log.d(TAG, "Medium send");
            Intent nextActivity = new Intent(fourth_page.this, fifth_page.class);
            int keski = message + 15;
            nextActivity.putExtra(EXTRA, keski);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.nelja){
            /* Send the info forward */

            Log.d(TAG, "Strong send");
            Intent nextActivity = new Intent(fourth_page.this, fifth_page.class);
            int vahva = message + 20;
            nextActivity.putExtra(EXTRA, vahva);
            startActivity(nextActivity);
        }else{
            Log.d(TAG, "Couldn't send");
        }
    }
}
