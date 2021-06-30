package com.haritagenelmudurlugu.haritadergisi;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button eDergiler,ozelSayilar,makaleSorgulama,dergiYonetimKurulu,dergiBilimKurulu,makaleYazımEsasları,hgmUygulamaları;
    Uri uri = Uri.parse("http://instagram.com/_u/harita_turkiye");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);


        eDergiler=(Button) findViewById(R.id.eDergiler);

        ozelSayilar=(Button) findViewById(R.id.ozelSayilar);
        makaleSorgulama=(Button) findViewById(R.id.makaleSorgulama);
        dergiYonetimKurulu=(Button) findViewById(R.id.dergiYonetimKurulu);
        dergiBilimKurulu=(Button) findViewById(R.id.dergiBilimKurulu);
        makaleYazımEsasları=(Button) findViewById(R.id.makaleYazımEsasları);
        hgmUygulamaları=(Button) findViewById(R.id.hgmUygulamaları);



        eDergiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, com.haritagenelmudurlugu.haritadergisi.eDergiler.class);
                startActivity(i);
            }
        });


        ozelSayilar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, com.haritagenelmudurlugu.haritadergisi.ozelSayilar.class);
                startActivity(i);
            }
        });

        makaleSorgulama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,makale.class);
                startActivity(i);
            }
        });

        dergiYonetimKurulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, com.haritagenelmudurlugu.haritadergisi.dergiYonetimKurulu.class);
                startActivity(i);
            }
        });

        dergiBilimKurulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, com.haritagenelmudurlugu.haritadergisi.dergiBilimKurulu.class);
                startActivity(i);
            }
        });

        makaleYazımEsasları.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,makaleYazimEsaslari.class);
                startActivity(i);
            }
        });

        hgmUygulamaları.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,hgmUygulamalari.class);
                startActivity(i);
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_iletisim:
                                Intent ii = new Intent(MainActivity.this,iletisim.class);
                                startActivity(ii);

                                break;
                            case R.id.action_twitter:
                                Intent intent2 = null;
                                try {
                                    // get the Twitter app if possible
                                    MainActivity.this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                                    intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=1047436629219180544"));
                                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                } catch (Exception e) {
                                    // no Twitter app, revert to browser
                                    intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/harita_turkiye"));
                                }
                                MainActivity.this.startActivity(intent2);

                                break;
                            case R.id.action_instagram:

                                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                                likeIng.setPackage("com.instagram.android");

                                try {
                                    startActivity(likeIng);
                                } catch (ActivityNotFoundException e) {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://instagram.com/harita_turkiye")));
                                }
                                break;


                        }
                        return true;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id==R.id.action_hakkinda)
        {
            Intent in = new Intent(MainActivity.this,hakkinda.class);
            startActivity(in);
        }

        else if (id==R.id.action_mail)
        {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"hgm@harita.gov.tr"});
            i.putExtra(Intent.EXTRA_SUBJECT, "");
            i.putExtra(Intent.EXTRA_TEXT   , "");
            try {
                startActivity(Intent.createChooser(i, "Mail Gönder..."));
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "E-mail gönderecek bir program bulunamadı !", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}