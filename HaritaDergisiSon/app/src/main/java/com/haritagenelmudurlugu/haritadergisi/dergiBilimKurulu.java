package com.haritagenelmudurlugu.haritadergisi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class dergiBilimKurulu extends AppCompatActivity {

    ArrayList a3 = new ArrayList();
    ListView listLinks1;
    ArrayAdapter adapter2;
    EditText araAd;

    String url = "https://www.harita.gov.tr/webservis.php?get=dergibilimkurulu";
    //String url = "https://www.harita.gov.tr/dergi-bilim-kurulu/sayfa/9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dergibilimkurulu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        listLinks1 = (ListView)findViewById(R.id.listviewLinks1);


        //Text için request
        StringRequest request3 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataRutbe(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata-Tekrar Deneyiniz!!", Toast.LENGTH_SHORT).show();

            }
        });


        //Text için queue
        RequestQueue rQueue3 = Volley.newRequestQueue(dergiBilimKurulu.this);
        rQueue3.add(request3);

        }

    //Rutbe değerlerine erişiyoruz
    void parseJsonDataRutbe (String jsonStringRutbe) {
        try {
            JSONObject objectRutbe = new JSONObject(jsonStringRutbe);
            JSONArray linksArrayRutbe = objectRutbe.getJSONArray("dergibilimkurulu");


            for (int j = 0; j < linksArrayRutbe.length(); ++j) {
                a3.add(linksArrayRutbe.getJSONObject(j).get("fullText"));

                }

            adapter2 = new ArrayAdapter(this,R.layout.activity_listview_3, a3);
            listLinks1.setAdapter(adapter2);

            EditText araAd =(EditText) findViewById(R.id.araAd);
            araAd.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    (dergiBilimKurulu.this).adapter2.getFilter().filter(s);

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });





        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}