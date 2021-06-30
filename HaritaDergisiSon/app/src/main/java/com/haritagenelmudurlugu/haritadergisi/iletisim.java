package com.haritagenelmudurlugu.haritadergisi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class iletisim extends AppCompatActivity {
TextView adres,telefon,faks,email,tel1,tel2,email2,tel3,tel4,email3,tel5,tel6,tel7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iletisim);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        adres=(TextView) findViewById(R.id.adres);
        adres.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_home_black_18dp, 0, 0, 0);

        telefon=(TextView) findViewById(R.id.telefon);
        telefon.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        faks=(TextView) findViewById(R.id.faks);
        faks.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_print_black_18dp,0,0,0);

        email=(TextView) findViewById(R.id.email);
        email.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_email_black_18dp,0,0,0);

        tel1=(TextView) findViewById(R.id.tel1);
        tel1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        tel2=(TextView) findViewById(R.id.tel2);
        tel2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        email2=(TextView) findViewById(R.id.email2);
        email2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_email_black_18dp,0,0,0);


        tel3=(TextView) findViewById(R.id.tel3);
        tel3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        tel4=(TextView) findViewById(R.id.tel4);
        tel4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        email3=(TextView) findViewById(R.id.email3);
        email3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_email_black_18dp,0,0,0);

        tel5=(TextView) findViewById(R.id.tel5);
        tel5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        tel6=(TextView) findViewById(R.id.tel6);
        tel6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);

        tel7=(TextView) findViewById(R.id.tel7);
        tel7.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_contact_phone_black_18dp,0,0,0);


    }
}
