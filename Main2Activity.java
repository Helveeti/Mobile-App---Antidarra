package com.example.infojallu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//Luominen
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnMinus, btnReset;
    TextView numberCounter, infoText, alkInfo;
    RadioButton radioShotti, radioViski, radioTolkki, radioTuoppi,radioViini;
    RadioGroup radio;
    private Counter count;
    private DoubleCounter luku;

    double  maara = 0;


    //Alustaminen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAdd = findViewById(R.id.addButton);
        btnMinus = findViewById(R.id.minusButton);
        btnReset = findViewById(R.id.resetButton);

        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        numberCounter = findViewById(R.id.background);
        infoText = findViewById(R.id.infoView);
        alkInfo = findViewById(R.id.alkPoltto);
        count = new Counter(300, 0);
        luku = new DoubleCounter(900,0);


        radioShotti = findViewById(R.id.shottiButton);
        radioViski = findViewById(R.id.viskiButton);
        radioTolkki = findViewById(R.id.tolkkiButton);
        radioTuoppi = findViewById(R.id.tuoppiRadio);
        radioViini = findViewById(R.id.viiniButton);
        radio = findViewById(R.id.radioGroup);


    }

    @Override
    public void onClick(View v) {
        //riippuen mikä radioButton on valittuna ja jos lisää niin lisää tietyn arvon ja päivittää summan
        if (v.getId() == R.id.addButton){
            if (radio.getCheckedRadioButtonId() == R.id.viskiButton){
                luku.add();
                maara = ((12.0 * luku.getValue())*1)/7;
            }else if (radio.getCheckedRadioButtonId() == R.id.tuoppiRadio){
                luku.ad();
                maara = ((12.0 * luku.getValue())*1.5)/7;
            }else if (radio.getCheckedRadioButtonId() == R.id.shottiButton){
                luku.add();
                maara = (12.0 * luku.getValue() * 1)/7;
            } else if ( radio.getCheckedRadioButtonId() == R.id.tolkkiButton){
                luku.add();
                maara = (12.0 * luku.getValue() * 1) / 7;
            }else if (radio.getCheckedRadioButtonId() == R.id.viiniButton){
                luku.add();
                maara = ((12.0 * luku.getValue())*1)/7;
            }
            count.plus();
            numberCounter.setText(String.valueOf(count.getValue()));
            infoText.setText("Olet juonut " + luku.getValue() + " annosta alkoholia ja tarvitset " + luku.getValue() + " lasin vettä.");
            alkInfo.setText("Juomasi alkoholimäärä on palanut pois noin " + Math.round(maara * 100.00) / 100.00 + " tunnin kuluttua juomisen aloittamisesta.");


            //riippuen mikä radioButton on valittuna ja jos lisää niin vähentäää tietyn arvon ja päivittää summan
        }else if (v.getId() == R.id.minusButton){
            if (radio.getCheckedRadioButtonId() == R.id.viskiButton){
                luku.reduce();
                maara =  ((12.0 * luku.getValue())*1)/7;
            }else if (radio.getCheckedRadioButtonId() == R.id.tuoppiRadio){
                luku.red();
                maara =  ((12.0 * luku.getValue())*1.5)/7;
            }else if (radio.getCheckedRadioButtonId() == R.id.shottiButton){
                luku.reduce();
                maara = ((12.0 * luku.getValue())*1)/7;
            } else if ( radio.getCheckedRadioButtonId() == R.id.tolkkiButton){
                luku.reduce();
                maara = ((12.0 * luku.getValue())*1)/7;
            }else if (radio.getCheckedRadioButtonId() == R.id.viiniButton){
                luku.reduce();
                maara = ((12.0 * luku.getValue())*1)/7;
            }
            count.minus();
            numberCounter.setText(String.valueOf(count.getValue()));
            infoText.setText("Olet juonut " + luku.getValue() + " annosta alkoholia ja tarvitset " + luku.getValue() + " lasin vettä.");
            alkInfo.setText("Juomasi alkoholimäärä on palanut pois noin " + Math.ceil(maara) + " tunnin kuluttua juomisen aloittamisesta.");

            //buttonia painetaan niin nollaa kaikki arvot
        }else if (v.getId() == R.id.resetButton){
            count.reset();
            numberCounter.setText(String.valueOf(count.getValue()));
            infoText.setText("Et ole juonut alkoholia. :)");
            alkInfo.setText("Et ole juonut alkoholia. :)");
            luku.nollaus();
            maara = 0;
        }
     }
            //painettua Buttonia, vie seuraavalle sivulle.
    public void nextPage(View v){

        Intent nextActivity = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(nextActivity);

    }

}


