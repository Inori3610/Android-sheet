package com.example.qlxe_php_database;

import android.content.Intent;
import android.os.Bundle;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstLoaixe;
    Loaixeapdapter adapter;
    ArrayList<Loaixe> mangloaixe;


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
        lstLoaixe =(ListView) findViewById(R.id.listViewDSLoaixe);
        mangloaixe = new ArrayList<>();
        READJSON("http://192.168.1.220/php/getloaixe.php");
        adapter=new Loaixeapdapter(MainActivity.this,R.layout.dongloaixe,mangloaixe);
        lstLoaixe.setAdapter(adapter);

        lstLoaixe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Loaixe loaixe = mangloaixe.get(i);
                Intent mh2 = new Intent(MainActivity.this,ActivityXe.class);
                Bundle bundle = new Bundle();
                bundle.putString("maloai",loaixe.getMaloai());
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
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        mangloaixe.add(new Loaixe(jsonObject.getString("maloai"), jsonObject.getString("tenloai")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG);
            }
    });
        requestQueue.add(jsonArrayRequest);
    }

}