package com.example.qlxe_php_database;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityXe extends AppCompatActivity {

    ListView lstXe;
    ArrayList<Xe> mangxe;
    Xeadapter adapter;
    String maloai;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lstXe = findViewById(R.id.listViewDsxe);
        mangxe = new ArrayList<>();

        Intent mh2 = getIntent();
        Bundle bundle = mh2.getExtras();

        maloai = bundle.getString("maloai","ddd");
        String url = "http://192.168.1.220/php/getxe.php?maloai=" + maloai;
        Log.d("INFO_TAG", "Link connect : "+url);

        READJSON(url);
        adapter = new Xeadapter(ActivityXe.this,R.layout.dongxe,mangxe);
        lstXe.setAdapter(adapter);


    }

    private void READJSON(String url){
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        mangxe.add(new Xe(object.getString("maxe"), object.getString("tenxe"), object.getInt("namsx"), object.getString("maloai"), object.getString("hinh")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActivityXe.this,error.toString(),Toast.LENGTH_LONG);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}