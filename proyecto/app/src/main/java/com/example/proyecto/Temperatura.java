package com.example.proyecto;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

//import com.google.gson.Gson;

public class Temperatura extends AppCompatActivity {
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        text1.findViewById(R.id.elfeed_id2);
        text2.findViewById(R.id.valor2);
        sensortempe();
    }
    private void sensortempe() {
        String link = "";
        JSONObject datos = new JSONObject();
        JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // final Gson gson = new Gson();
                try{
                    String a = response.getString("feed_id");
                    String b = response.getString("value");
                    text1.setText(a);
                    text2.setText(b);
                }catch(JSONException e){
                    e.printStackTrace();

                }}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }

        }
        );
    }
}