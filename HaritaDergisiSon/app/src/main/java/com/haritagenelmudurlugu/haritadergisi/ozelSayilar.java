package com.haritagenelmudurlugu.haritadergisi;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class ozelSayilar extends AppCompatActivity {
    ListView listLinks,listLinks2;
    ArrayList a58 = new ArrayList();

    String url = "https://www.harita.gov.tr/webservis.php?get=ozeldergiler";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ozelsayilar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        listLinks = (ListView)findViewById(R.id.listviewLinks);
        listLinks.addHeaderView(new View(this));
        listLinks.addFooterView(new View(this));

        //baslik için request
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata-Tekrar Deneyiniz!!", Toast.LENGTH_SHORT).show();

            }
        });



        //linkler için request
        StringRequest request3 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataLinks(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata-Tekrar Deneyiniz!!", Toast.LENGTH_SHORT).show();

            }
        });

        //baslık için
        RequestQueue rQueue = Volley.newRequestQueue(ozelSayilar.this);
        rQueue.add(request);

        //linkler için
        RequestQueue rQueue2 = Volley.newRequestQueue(ozelSayilar.this);
        rQueue2.add(request3);

    }//MAIN

    //baslik değerini çekiyoruz
    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray linksArray = object.getJSONArray("ozeldergiler");
            ArrayList al = new ArrayList();

            int sayi1 = linksArray.length();
            for(int i = 0; i < linksArray.length(); ++i) {
                al.add(linksArray.getJSONObject(i).get("baslik"));
            }

            ArrayAdapter adapter5 = new ArrayAdapter(this, R.layout.activity_listview, al);
            listLinks.setAdapter(adapter5);
            listLinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int ppp = position;
                    // Get the selected item text from ListView
                    String selectedItem = (String) parent.getItemAtPosition(position);

                    final   String linkler2="https://www.harita.gov.tr/images/dergi/"+a58.get(position-1);

                    /* Intent i =new Intent(getApplicationContext(),showingPdf.class);
                      i.putExtra("send_string",linkler);
                      startActivity(i); */

                    AlertDialog.Builder builder = new AlertDialog.Builder(ozelSayilar.this);
                    builder.setTitle("Harita Özel Dergiler");
                    builder.setMessage("Pdf olarak indirmek istiyor musunuz ?");
                    builder.setNegativeButton("İPTAL", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id) {

                            //İptal butonuna basılınca yapılacaklar.Sadece kapanması isteniyorsa boş bırak.

                        }
                    });


                    builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Tamam butonuna basılınca yapılacakları yaz
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(linkler2), "text/html");
                            //   Toast.makeText(getApplicationContext(), "PDF İndiriliyor", Toast.LENGTH_SHORT).show();
// "http://docs.google.com/viewer?url=" +
                            startActivity(intent);

                        }
                    });


                    builder.show();

                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //linklere erişiyoruz
    void parseJsonDataLinks (String jsonString58) {
        try {
            JSONObject object3 = new JSONObject(jsonString58);
            JSONArray linksArray3 = object3.getJSONArray("ozeldergiler");



            for(int f = 0; f < linksArray3.length(); f++) {
                a58.add(linksArray3.getJSONObject(f).get("fotograf"));
                // https://www.harita.gov.tr/images/dergi/
            }
            int sayi2 = linksArray3.length();
         /*   ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, a2);
            listLinks2.setAdapter(adapter2); */
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
