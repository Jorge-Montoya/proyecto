
package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class Humo extends AppCompatActivity {
    TextView texto1,texto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humo);
        texto1=findViewById(R.id.elfeed_id4);
        texto2=findViewById(R.id.valor4);
        sensorhumo();
    }
    private void sensorhumo() {
        String link = "";
        JSONObject datos = new JSONObject();
        JsonObjectRequest registro = new JsonObjectRequest(Request.Method.GET, link, datos, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                final Gson gson = new Gson();
                try{
                    String a = response.getString("feed_id");
                    String b = response.getString("value");
                    texto1.setText(a);
                    texto2.setText(b);
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