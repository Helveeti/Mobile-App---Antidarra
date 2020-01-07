package com.example.jallu;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* Veera A. */

public class final_page extends AppCompatActivity {
    public static final String SAVE = "Tallennettu";
    public static final String EXTRA = "Extra";
    private ImageView etusivu;
    private ImageView laskuri;
    private ImageView kysely;
    private ImageView tietoa;
    private TextView value;
    private Value valueArvot;
    private int message;
    private int palautus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        etusivu = findViewById(R.id.etusivu);
        etusivu.setVisibility(View.INVISIBLE);
        laskuri = findViewById(R.id.laskuri);
        laskuri.setVisibility(View.INVISIBLE);
        kysely = findViewById(R.id.kysely);
        kysely.setVisibility(View.INVISIBLE);
        tietoa = findViewById(R.id.tietoa);
        tietoa.setVisibility(View.INVISIBLE);

        value = findViewById(R.id.arvot);
        value.setVisibility(View.INVISIBLE);


        /* Getting the info from the last page */

        Bundle intent = getIntent().getExtras();
        assert intent != null;
        message = intent.getInt(seventh_page.EXTRA);
        palautus = intent.getInt(first_page.EXTRA);

        /* Printing the value */

        SharedPreferences prefGet = getSharedPreferences(SAVE, Activity.MODE_PRIVATE);
        valueArvot = new Value(prefGet.getInt("Palautus", 0));
        value.setText(Integer.toString(valueArvot.getValue()));

        /* Printing the results */

        TextView title = findViewById(R.id.title);

        if (valueArvot == null) {

            if (message < 30 && message > 0) {
                title.setText(
                        "Sait vastaukseksi: Onneksi olkoon! \nOlet huomannut että hauskaa voi olla ilman viinaa. \n \nTiesitkö miten juomattomuus vaikuttaa kroppaasi? \n1. Painosi putoaa \n2. Vastuskykysi lujittuu \n3. Nukut paremmin \n4. Mielialasi kohenee \n5. Riskisi sairastua syöpään pienenevät \n6. Vatsasi rauhoittuu \n7. Ihosi kirkastuu \n8. Liikunta puree paremmin \n9. Sydämmesi ja aivojesi terveys paranee \n10. Solusi uusiutuvat ja alat virkistyä!"
                );
                onPause();
            } else if (message > 100) {
                title.setText(
                        "Sait vastaukseksi:\n" +
                                "Olet huomannut että viinaa voi olla ilman hauskaa!\n" +
                                "Oletko huomannut tämän kropastasi?\n" +
                                "\n" +
                                "1. Kestät paljon alkoholia ilman krapulaa? Tämä on yleensä merkki siitä, että olet tottunut alkoholinkäyttäjä ja kuulut riskiryhmään.\n" +
                                "2. Heräät yöllä vessaan? Tämä voi olla merkki siitä, että juot enemmän alkoholia kuin elimistö pystyy käsittelemään.\n" +
                                "3. Sinulla on vatsavaivoja? Tämä voi olla merkki puhkeavasta maksasairauksesta.\n" +
                                "4. Ihosi ja silmävalkuaisesi alkavat kellertää? Se on merkki siitä, että maksa ei toimi normaalisti.\n"
                );
                onPause();
            } else {
                title.setText(
                        "Sait vastaukseksi: Onneksi olkoon!\n" +
                                "Olet huomannut että voi olla hauskaa ja viinaa!\n" +
                                "\n" +
                                "Tiesitkö miten kohtuukäytön vähentäminen vaikuttaa kroppaasi?\n" +
                                "\n" +
                                "1. Maksan rasvamäärä pienenee keskimäärin 15-20 prosentilla. Se pienentää merkittävästi maksakirroosin riskiä.\n" +
                                "2. Verensokeri laskee keskimäärin 16 prosentilla. Se taas tarkoittaa pienempää 2-tyypin diabeteksen riskiä.\n" +
                                "3. Kolesteroliarvot paranevat 5 prosentilla. Pudotus vähentää sydäntautien riskiä.\n"
                );
                onPause();
            }
        }else{
            if (palautus < 30 && palautus > 0) {
                title.setText(
                        "Sait vastaukseksi: Onneksi olkoon! \nOlet huomannut että hauskaa voi olla ilman viinaa. \n \nTiesitkö miten juomattomuus vaikuttaa kroppaasi? \n1. Painosi putoaa \n2. Vastuskykysi lujittuu \n3. Nukut paremmin \n4. Mielialasi kohenee \n5. Riskisi sairastua syöpään pienenevät \n6. Vatsasi rauhoittuu \n7. Ihosi kirkastuu \n8. Liikunta puree paremmin \n9. Sydämmesi ja aivojesi terveys paranee \n10. Solusi uusiutuvat ja alat virkistyä!"
                );
            } else if (palautus > 100) {
                title.setText(
                        "Sait vastaukseksi:\n" +
                                "Olet huomannut että viinaa voi olla ilman hauskaa!\n" +
                                "Oletko huomannut tämän kropastasi?\n" +
                                "\n" +
                                "1. Kestät paljon alkoholia ilman krapulaa? Tämä on yleensä merkki siitä, että olet tottunut alkoholinkäyttäjä ja kuulut riskiryhmään.\n" +
                                "2. Heräät yöllä vessaan? Tämä voi olla merkki siitä, että juot enemmän alkoholia kuin elimistö pystyy käsittelemään.\n" +
                                "3. Sinulla on vatsavaivoja? Tämä voi olla merkki puhkeavasta maksasairauksesta.\n" +
                                "4. Ihosi ja silmävalkuaisesi alkavat kellertää? Se on merkki siitä, että maksa ei toimi normaalisti.\n"
                );
            } else if (palautus > 30 && palautus < 100) {
                title.setText(
                        "Sait vastaukseksi: Onneksi olkoon!\n" +
                                "Olet huomannut että voi olla hauskaa ja viinaa!\n" +
                                "\n" +
                                "Tiesitkö miten kohtuukäytön vähentäminen vaikuttaa kroppaasi?\n" +
                                "\n" +
                                "1. Maksan rasvamäärä pienenee keskimäärin 15-20 prosentilla. Se pienentää merkittävästi maksakirroosin riskiä.\n" +
                                "2. Verensokeri laskee keskimäärin 16 prosentilla. Se taas tarkoittaa pienempää 2-tyypin diabeteksen riskiä.\n" +
                                "3. Kolesteroliarvot paranevat 5 prosentilla. Pudotus vähentää sydäntautien riskiä.\n"
                );
            } else {
                title.setText("Kokeile  myöhemmin uudestaan.");
            }
        }
    }

    /* Saving the value */

    public void onPause(){
        super.onPause();

        SharedPreferences prefPut = getSharedPreferences(SAVE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("Palautus", palautus);
        prefEditor.putInt("Message", message);
        prefEditor.commit();

        Intent nextActivity = new Intent(this, first_page.class);
        nextActivity.putExtra(EXTRA, message);
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

    /* Moving to other page */

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
