package com.haritagenelmudurlugu.haritadergisi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
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

public class dergiYonetimKurulu extends AppCompatActivity {
    ArrayList a2 = new ArrayList();
    ArrayList a3 = new ArrayList();
    ArrayList a4 = new ArrayList();
   TextView No,No1,No2,No3,No4,Gorev,Gorev1,Gorev2,Gorev3,Gorev4,Rutbe,Rutbe1,Rutbe2,Rutbe3,Rutbe4;

    String url = "https://www.harita.gov.tr/webservis.php?get=dergiyonetimkurulu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dergiyonetimkurulu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        //no için request
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata2-Tekrar Deneyiniz!!", Toast.LENGTH_SHORT).show();

            }
        });

        //görev için request
        StringRequest request2 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataLinks(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata2-Tekrar Deneyiniz!!", Toast.LENGTH_SHORT).show();

            }
        });

        //Rutbe için request
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




        //baslık için
        RequestQueue rQueue = Volley.newRequestQueue(dergiYonetimKurulu.this);
        rQueue.add(request);

        //linkler için
        RequestQueue rQueue2 = Volley.newRequestQueue(dergiYonetimKurulu.this);
        rQueue2.add(request2);

        //Rutbe için
        RequestQueue rQueue3 = Volley.newRequestQueue(dergiYonetimKurulu.this);
        rQueue3.add(request3);






    }

    //No değerini çekiyoruz
    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray linksArray = object.getJSONArray("dergiyonetimkurulu");
            ArrayList al = new ArrayList();

            for(int i = 0; i < linksArray.length(); i++) {
                al.add(linksArray.getJSONObject(i).get("No"));
            }

            No=(TextView) findViewById(R.id.No);
            No.setText((String)al.get(0));
            No1=(TextView) findViewById(R.id.No1);
            No1.setText((String)al.get(1));
            No2=(TextView) findViewById(R.id.No2);
            No2.setText((String)al.get(2));
            No3=(TextView) findViewById(R.id.No3);
            No3.setText((String)al.get(3));
            No4=(TextView)findViewById(R.id.No4);
            No4.setText((String)al.get(4));



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //
    //Görev değelerlerine erişiyoruz
    void parseJsonDataLinks (String jsonString2) {
        try {
            JSONObject object2 = new JSONObject(jsonString2);
            JSONArray linksArray2 = object2.getJSONArray("dergiyonetimkurulu");


            for (int j = 0; j < linksArray2.length(); ++j) {
                a2.add(linksArray2.getJSONObject(j).get("Görev"));
                }

                Gorev=(TextView) findViewById(R.id.Gorev);
                Gorev.setText((String)a2.get(0));
                Gorev1=(TextView) findViewById(R.id.Gorev1);
                Gorev1.setText((String)a2.get(1));
                Gorev2=(TextView) findViewById(R.id.Gorev2);
                Gorev2.setText((String)a2.get(2));
                Gorev3=(TextView)findViewById(R.id.Gorev3);
                Gorev3.setText((String)a2.get(3));
                Gorev4=(TextView) findViewById(R.id.Gorev4);
                Gorev4.setText((String)a2.get(4));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void parseJsonDataLinks2 (String jsonString2) {
        try {
            JSONObject object2 = new JSONObject(jsonString2);
            JSONArray linksArray2 = object2.getJSONArray("dergiyonetimkurulu");


            for (int j = 0; j < linksArray2.length(); ++j) {
                a2.add(linksArray2.getJSONObject(j).get("Görev"));
            }

            Gorev=(TextView) findViewById(R.id.Gorev);
            Gorev.setText((String)a2.get(0));
            Gorev1=(TextView) findViewById(R.id.Gorev1);
            Gorev1.setText((String)a2.get(1));
            Gorev2=(TextView) findViewById(R.id.Gorev2);
            Gorev2.setText((String)a2.get(2));
            Gorev3=(TextView)findViewById(R.id.Gorev3);
            Gorev3.setText((String)a2.get(3));
            Gorev4=(TextView) findViewById(R.id.Gorev4);
            Gorev4.setText((String)a2.get(4));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Rutbe değerlerine erişiyoruz
    void parseJsonDataRutbe (String jsonStringRutbe) {
        try {
            JSONObject objectRutbe = new JSONObject(jsonStringRutbe);
            JSONArray linksArrayRutbe = objectRutbe.getJSONArray("dergiyonetimkurulu");


            for (int j = 0; j < linksArrayRutbe.length(); ++j) {
                a3.add(linksArrayRutbe.getJSONObject(j).get("rutbeAd"));
            }

            Rutbe=(TextView) findViewById(R.id.rutbeAd);
            Rutbe.setText((String)a3.get(0));
            Rutbe1=(TextView)findViewById(R.id.rutbeAd1);
            Rutbe1.setText((String)a3.get(1));
            Rutbe2=(TextView)findViewById(R.id.rutbeAd2);
            Rutbe2.setText((String)a3.get(2));
            Rutbe3=(TextView) findViewById(R.id.rutbeAd3);
            Rutbe3.setText((String)a3.get(3));
            Rutbe4=(TextView)findViewById(R.id.rutbeAd4);
            Rutbe4.setText((String)a3.get(4));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    }