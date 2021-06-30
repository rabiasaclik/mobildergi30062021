package com.haritagenelmudurlugu.haritadergisi;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haritagenelmudurlugu.haritadergisi.helper.MakaleArrayAdapter;
import com.haritagenelmudurlugu.haritadergisi.model.Makale;
import com.haritagenelmudurlugu.haritadergisi.model.MakaleResponse;

import java.util.ArrayList;

public class makale extends AppCompatActivity {

    ListView listviewMakale;

    ArrayList<Makale> makaleler = new ArrayList<>();

  private MakaleArrayAdapter adapter;

 private  EditText ara;

    String url = "https://www.harita.gov.tr/webservis.php?get=makale";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makale);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        listviewMakale = (ListView)findViewById(R.id.listviewMakale);

        //Makale Adı için request
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


        //baslık için
        RequestQueue rQueue = Volley.newRequestQueue(makale.this);
        rQueue.add(request);

    }

    //baslik değerini çekiyoruz
    void parseJsonData(String jsonString) {
        try {

            GsonBuilder gsonBuilder = new GsonBuilder();

            Gson gson = gsonBuilder.create();

            MakaleResponse makaleResponse = gson.fromJson(jsonString,MakaleResponse.class);

            this.makaleler = makaleResponse.getResult();

            adapter = new MakaleArrayAdapter(this,R.layout.activity_listview_2, this.makaleler);

            listviewMakale.setAdapter(adapter);

            final EditText ara=(EditText) findViewById(R.id.ara);

            listviewMakale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   Makale clickedMakale =  adapter.getItemInPosition(position);


                    final   String linkler="https://www.harita.gov.tr/images/dergi/makaleler/"+clickedMakale.getLink();
                    AlertDialog.Builder builder = new AlertDialog.Builder(makale.this);
                    builder.setTitle("Harita e-Dergi - Makale");
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
                            intent.setDataAndType(Uri.parse(linkler), "text/html");
                            startActivity(intent);

                        }
                    });


                    builder.show();
                    }
            });//listview click son


            //makale aranınca 
            ara.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                makale.this.adapter.filter(charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}