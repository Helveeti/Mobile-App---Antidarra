package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

/* Veera A. */

public class sixth_page extends AppCompatActivity {
    private RadioGroup radioGroup;
    public static final String EXTRA = "Extra";
    public static final String TAG = "Tag";
    private int message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_page);
        radioGroup = findViewById(R.id.group);

        /* Getting the last page's info */

        Bundle intent = getIntent().getExtras();
        message = intent.getInt(fifth_page.EXTRA, 0);
    }

    /* Button */

    public void nextPage(View v) {
        if (radioGroup.getCheckedRadioButtonId() == R.id.yksi) {
            /* Send the info forward */

            Log.d(TAG, "Ei ikinä send");
            Intent nextActivity = new Intent(sixth_page.this, seventh_page.class);
            int never = message;
            nextActivity.putExtra(EXTRA, never);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.kaksi) {
            /* Send the info forward */

            Log.d(TAG, "Harvoin send");
            Intent nextActivity = new Intent(sixth_page.this, seventh_page.class);
            int lepo = message;
            nextActivity.putExtra(EXTRA, lepo);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.kolme) {
            /* Send the info forward */

            Log.d(TAG, "Usein send");
            Intent nextActivity = new Intent(sixth_page.this, seventh_page.class);
            int laake = message + 10;
            nextActivity.putExtra(EXTRA, laake);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.nelja) {
            /* Send the info forward */

            Log.d(TAG, "Aina send");
            Intent nextActivity = new Intent(sixth_page.this, seventh_page.class);
            int limu = message + 15;
            nextActivity.putExtra(EXTRA, limu);
            startActivity(nextActivity);
        } else if (radioGroup.getCheckedRadioButtonId() == R.id.viisi) {
            /* Send the info forward */

            Log.d(TAG, "No idea send");
            Intent nextActivity = new Intent(sixth_page.this, seventh_page.class);
            int kaikki = message + 20;
            nextActivity.putExtra(EXTRA, kaikki);
            startActivity(nextActivity);
        } else {
            Log.d(TAG, "Couldn't send");
        }
    }
}
