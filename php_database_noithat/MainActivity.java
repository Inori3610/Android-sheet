package com.example.php_database_noithat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

public class MainActivity extends AppCompatActivity {

    ListView lstloaiNT;
    LoaiNTadapter adapter;
    ArrayList<LoaiNT> mangloaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lstloaiNT = (ListView) findViewById(R.id.lst);
        mangloaint = new ArrayList<>();
        READJSON("http://192.168.1.18/php/getloaint.php");
        adapter = new LoaiNTadapter(MainActivity.this,R.layout.dongloaint,mangloaint);
        lstloaiNT.setAdapter(adapter);

        lstloaiNT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LoaiNT loaiNT = mangloaint.get(position);
                Bundle bundle = new Bundle();
                Intent mh2 = new Intent(MainActivity.this,MainActivity2.class);
                bundle.putString("maloaiNT",loaiNT.getMaloaiNT());
                mh2.putExtras(bundle);
                startActivity(mh2);

            }
        });

    }


    private void READJSON(String URL){
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("JSON_DEBUG", "Received JSON: " + response.toString());
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        mangloaint.add(new LoaiNT(jsonObject.getString("maloaiNT"), jsonObject.getString("tenloaiNT")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG);
            }
    });
        requestQueue.add(jsonArrayRequest);

    }
}