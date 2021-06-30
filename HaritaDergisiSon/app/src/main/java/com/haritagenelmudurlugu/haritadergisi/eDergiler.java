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

public class eDergiler extends AppCompatActivity {
    ListView listLinks,listLinks2;
    ArrayList a2 = new ArrayList();

    //DERGİ ARŞİVİ BUTONU
    String url = "https://www.harita.gov.tr/webservis.php?get=arsiv";
    /*String url = "https://www.harita.gov.tr/harita-dergisi-arsivi";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edergiler);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);

        listLinks = (ListView)findViewById(R.id.listviewLinks);

        //baslik için request
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata-Tekrar Deneyiniz*", Toast.LENGTH_SHORT).show();
                }
        });

        //linkler için request
        StringRequest request2 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonDataLinks(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Hata-Tekrar Deneyiniz**", Toast.LENGTH_SHORT).show();

            }
        });
        //baslık için
        RequestQueue rQueue = Volley.newRequestQueue(eDergiler.this);
        rQueue.add(request);

        //linkler için
        RequestQueue rQueue2 = Volley.newRequestQueue(eDergiler.this);
        rQueue2.add(request2);
    }
    //baslik değerini çekiyoruz
    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray linksArray = object.getJSONArray("arsiv");
            ArrayList al = new ArrayList();

            for(int i = 0; i < linksArray.length(); ++i) {
                if (i==0){ al.add(linksArray.getJSONObject(i).get("baslik")+"  (Son Sayı)"); i++;}
                al.add(linksArray.getJSONObject(i).get("baslik"));
            }
            ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_listview_2, al);
            listLinks.setAdapter(adapter);
            listLinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    // Get the selected item text from ListView
                    String selectedItem = (String) parent.getItemAtPosition(position);
                    final String linkler="https://www.harita.gov.tr/uploads/files/mapmagazines/"+a2.get(position);
                    /* Intent i =new Intent(getApplicationContext(),showingPdf.class);
                      i.putExtra("send_string",linkler);
                      startActivity(i); */

                    AlertDialog.Builder builder = new AlertDialog.Builder(eDergiler.this);
                    builder.setTitle("Harita e-Dergi");
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
                            //  Toast.makeText(getApplicationContext(), "PDF İndiriliyor", Toast.LENGTH_SHORT).show();
                            // "http://docs.google.com/viewer?url=" +
                            startActivity(intent);
                        }
                    });
                    builder.show();

                }//ON CLICK
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //linklere erişiyoruz
    void parseJsonDataLinks (String jsonString2) {
        try {
            JSONObject object2 = new JSONObject(jsonString2);
            JSONArray linksArray2 = object2.getJSONArray("arsiv");

            for(int j = 0; j < linksArray2.length(); j++) {
                a2.add(linksArray2.getJSONObject(j).get("fotograf"));
                /* https://www.harita.gov.tr/images/dergi/*/
            }
            ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, a2);
            listLinks2.setAdapter(adapter2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}