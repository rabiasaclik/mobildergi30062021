package com.haritagenelmudurlugu.haritadergisi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class hgmUygulamalari extends AppCompatActivity {
    Button buttonAtlas,buttonGeoportal,buttonTemelHesaplamalar,buttonTemelJeodezik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hgmuygulamari);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        buttonAtlas=(Button) findViewById(R.id.buttonAtlas);
        buttonGeoportal=(Button) findViewById(R.id.buttonGeoportal);
        buttonTemelHesaplamalar=(Button) findViewById(R.id.buttonTemelHesaplamalar);
        buttonTemelJeodezik=(Button) findViewById(R.id.buttonTemelJeodezik);


        buttonAtlas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://atlas.harita.gov.tr/"));
                startActivity(intent);
            }
        });


        buttonGeoportal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://geoportal.harita.gov.tr"));
                startActivity(intent);
            }
        });

        buttonTemelHesaplamalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.harita.gov.tr/temel-jeodezik-hesaplamalar"));
                startActivity(intent);
            }
        });


        buttonTemelJeodezik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.harita.gov.tr/sunum/"));
                startActivity(intent);

            }
        });

        }
}