package com.example.infojallu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


//Luominen
public class MainActivity extends AppCompatActivity {
    //Alustaminen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //painettua Buttonia, vie seuraavalle sivulle.

    public void nextPage(View v){

        Intent nextActivity = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(nextActivity);

    }
}
