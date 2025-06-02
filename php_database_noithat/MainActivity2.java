package com.example.php_database_noithat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lstNT;
    NoithatAdapter adapter;
    ArrayList<Noithat> mangnoithat;
    String maloaiNT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstNT = (ListView) findViewById(R.id.lstnt);
        mangnoithat = new ArrayList<>();

        Intent mh2 = getIntent();
        Bundle bundle = mh2.getExtras();

        maloaiNT = bundle.getString("maloaiNT","ddd");
        String URL = "http://192.168.1.18/php/getnoithat.php?maloaiNT=" + maloaiNT;
        Log.d("INFO_TAG", "Link connect : "+URL);

        READJSON(URL);

        adapter = new NoithatAdapter(MainActivity2.this,R.layout.dongnoithat,mangnoithat);
        lstNT.setAdapter(adapter);
    }

    private void READJSON(String URL){
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        mangnoithat.add(new Noithat(jsonObject.getString("manoithat"),
                                                    jsonObject.getString("tennoithat"),
                                                    jsonObject.getString("donvitinh"),
                                                    jsonObject.getInt("soluong"),
                                                    jsonObject.getInt("dongia"),
                                                    jsonObject.getString("maloaiNT"),
                                                    jsonObject.getString("hinhanh")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity2.this,error.toString(),Toast.LENGTH_LONG);
            }
    });
        requestQueue.add(jsonArrayRequest);
    }
}