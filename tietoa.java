package com.example.jallu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tietoa extends AppCompatActivity {
    private ImageView etusivu;
    private ImageView laskuri;
    private ImageView kysely;
    private ImageView tietoa;
    private TextView alko;
    private TextView krapula;
    private TextView links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tietoa);

        etusivu = findViewById(R.id.etusivu3);
        etusivu.setVisibility(View.INVISIBLE);
        laskuri = findViewById(R.id.laskuri3);
        laskuri.setVisibility(View.INVISIBLE);
        kysely = findViewById(R.id.kysely3);
        kysely.setVisibility(View.INVISIBLE);
        tietoa = findViewById(R.id.tietoa3);
        tietoa.setVisibility(View.INVISIBLE);

        alko = findViewById(R.id.alkoholi);
        alko.setText("Alkoholin käyttö on Suomessa yleistä. 15 - vuotta täyttäneiden keskuudessa alkoholin kulutus on n. 10 litran luokkaa per vuosi. Suomessa miehien riskiraja alkoholin käytölle on  maksimissaan 7 annosta päivässä ja 24 annosta viikossa tai naisilla 5 annosta päivässä ja 16 annosta viikossa. Yleisesti ottaen naiset kestävät alkoholia huonommin kuin miehet kehon vesiosuuden ollessa pienempi. Nuorilla elimistön sietokyky on yleisesti ottaen parempi mikä yleensä lisää humalanhakuista juomista. ");
        krapula = findViewById(R.id.krapula);
        krapula.setText("Krapula on vieroitustila jossa hermoston toimintaa on häiritty alkoholilla mistä seuraa nestehukkaa ja verensokerin laskua. Kun alkoholi poistuu elimistöstä, pyrkii hermosto palautumaan normaalitilaan josta aiheutuvat krapulan oireet kuten päänsärkyä, vapinaa ja pahoinvointia. Alkoholi toimi diureettina mistä johtuen on tärkeää juoda vettä alkoholin nauttimisen yhteydessä sekä syödä hyvin. Runsaan juomisen jälkeen olisi syytä välttää saunomista ja runsaasti verensokeria kuluttavaa liikuntaa. \n" +
                "Lisää tietoa mm. seuraavista linkeistä");
        links = findViewById(R.id.links);
        links.setClickable(true);
        links.setMovementMethod(LinkMovementMethod.getInstance());
        String paihde = "<a href='https://paihdelinkki.fi/'> Päihdelinkki | </a>";
        String kohtuullisesti = "<a href='https://www.kohtuullisesti.fi/'> Kohtuullisesti | </a>";
        String nuoret = "<a href='https://nuortenlinkki.fi/tietopiste/pikatieto/alkoholi'> Nuortenlinkki </a>";
        links.setText(Html.fromHtml(paihde + kohtuullisesti + nuoret));
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
