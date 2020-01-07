package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class antidarra extends AppCompatActivity {
    private TextView info;
    Button btnAdd, btnMinus, btnReset;
    TextView numberCounter, infoText, alkInfo;
    RadioButton radioShotti, radioViski, radioTolkki, radioTuoppi,radioViini;
    RadioGroup radio;
    private Counter count;
    private DoubleCounter luku;
    private double maara;
    private ImageView etusivu;
    private ImageView laskuri;
    private ImageView kysely;
    private ImageView tietoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antidarra);

        info = findViewById(R.id.infoText);
        info.setText("Huom! Laskuri perustuu noin 70 kiloisen, normaalikuntoisen ihmisen alkoholin käyttöön. Terve maksa polttaa alkoholia suunnilleen gramman tunnissa per kymmenen kehonpainokiloa. Laskuri on vain arvio eikä sovelluksen kehittäjät takaa sen todenmukaisuutta jokaisen kohdalla. ");

        btnAdd = findViewById(R.id.addButton);
        btnMinus = findViewById(R.id.minusButton);
        btnReset = findViewById(R.id.resetButton);

        numberCounter = findViewById(R.id.counterValue);
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


        /* For menu */
        etusivu = findViewById(R.id.etusivu4);
        etusivu.setVisibility(View.INVISIBLE);
        laskuri = findViewById(R.id.laskuri4);
        laskuri.setVisibility(View.INVISIBLE);
        kysely = findViewById(R.id.kysely4);
        kysely.setVisibility(View.INVISIBLE);
        tietoa = findViewById(R.id.tietoa4);
        tietoa.setVisibility(View.INVISIBLE);

    }

    public void onClick(View v) {
        //riippuen mikä radioButton on valittuna ja jos lisää niin lisää tietyn arvon ja päivittää summan
        if (v.getId() == R.id.addButton){
            if (radio.getCheckedRadioButtonId() == R.id.viskiButton){
                luku.add();
                maara = ((12.0 * luku.getValue())*1)/7;
                count.plus();
            }else if (radio.getCheckedRadioButtonId() == R.id.tuoppiRadio){
                luku.ad();
                maara = ((12.0 * luku.getValue())*1.5)/7;
                count.plus();
            }else if (radio.getCheckedRadioButtonId() == R.id.shottiButton){
                luku.add();
                maara = (12.0 * luku.getValue() * 1)/7;
                count.plus();
            } else if ( radio.getCheckedRadioButtonId() == R.id.tolkkiButton){
                luku.add();
                maara = (12.0 * luku.getValue() * 1) / 7;
                count.plus();
            }else if (radio.getCheckedRadioButtonId() == R.id.viiniButton){
                luku.add();
                maara = ((12.0 * luku.getValue())*1)/7;
                count.plus();
            }
            numberCounter.setText(String.valueOf(count.getValue()));
            infoText.setText("Olet juonut " + luku.getValue() + " annosta alkoholia ja tarvitset " + luku.getValue() + " lasin vettä.");
            alkInfo.setText("Juomasi alkoholimäärä on palanut pois noin " + Math.round(maara * 100.00) / 100.00 + " tunnin kuluttua juomisen aloittamisesta.");


            //riippuen mikä radioButton on valittuna ja jos lisää niin vähentäää tietyn arvon ja päivittää summan
        }else if (v.getId() == R.id.minusButton){
            if (radio.getCheckedRadioButtonId() == R.id.viskiButton){
                luku.reduce();
                maara =  ((12.0 * luku.getValue())*1)/7;
                count.minus();
            }else if (radio.getCheckedRadioButtonId() == R.id.tuoppiRadio){
                luku.red();
                maara =  ((12.0 * luku.getValue())*1.5)/7;
                count.minus();
            }else if (radio.getCheckedRadioButtonId() == R.id.shottiButton){
                luku.reduce();
                maara = ((12.0 * luku.getValue())*1)/7;
                count.minus();
            } else if ( radio.getCheckedRadioButtonId() == R.id.tolkkiButton){
                luku.reduce();
                maara = ((12.0 * luku.getValue())*1)/7;
                count.minus();
            }else if (radio.getCheckedRadioButtonId() == R.id.viiniButton){
                luku.reduce();
                maara = ((12.0 * luku.getValue())*1)/7;
                count.minus();
            }
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

    /* Menu - Veera A. */

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
