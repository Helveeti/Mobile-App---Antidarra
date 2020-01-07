package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EtusivuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etusivu);
    }

    public void clickedLaskuri(View v) {
        startActivity(new Intent(this, antidarra.class));
    }

    public void clickedKysely(View v) {
        startActivity(new Intent(this, first_page.class));
    }

    public void clickedTietoa(View v) {
        startActivity(new Intent(this, tietoa.class));
    }
}
