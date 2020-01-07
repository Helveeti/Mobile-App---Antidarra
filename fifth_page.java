package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

public class fifth_page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public static final String EXTRA = "Extra";
    public static final String TAG = "Tag";
    private int message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_page);
        radioGroup = findViewById(R.id.group);

        /* Getting the last page's info */

        Bundle intent = getIntent().getExtras();
        message = intent.getInt(fourth_page.EXTRA, 0);
    }

    /* Button */

    public void nextPage(View v){
        if (radioGroup.getCheckedRadioButtonId() == R.id.yksi) {
            /* Send the info forward */

            Log.d(TAG, "Ryyppy send");
            Intent nextActivity = new Intent(fifth_page.this, sixth_page.class);
            int vahva = message + 20;
            nextActivity.putExtra(EXTRA, vahva);
            startActivity(nextActivity);
        }else if (radioGroup.getCheckedRadioButtonId() == R.id.kaksi){
            /* Send the info forward */

            Log.d(TAG, "Lepo send");
            Intent nextActivity = new Intent(fifth_page.this, sixth_page.class);
            int lepo = message;
            nextActivity.putExtra(EXTRA, lepo);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.kolme){
            /* Send the info forward */

            Log.d(TAG, "Burana send");
            Intent nextActivity = new Intent(fifth_page.this, sixth_page.class);
            int laake = message;
            nextActivity.putExtra(EXTRA, laake);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.nelja){
            /* Send the info forward */

            Log.d(TAG, "Jaffa send");
            Intent nextActivity = new Intent(fifth_page.this, sixth_page.class);
            int limu = message + 5;
            nextActivity.putExtra(EXTRA, limu);
            startActivity(nextActivity);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.viisi){
            /* Send the info forward */

            Log.d(TAG, "All above send");
            Intent nextActivity = new Intent(fifth_page.this, sixth_page.class);
            int kaikki = message + 30;
            nextActivity.putExtra(EXTRA, kaikki);
            startActivity(nextActivity);
        }else{
            Log.d(TAG, "Couldn't send");
        }
    }
}
