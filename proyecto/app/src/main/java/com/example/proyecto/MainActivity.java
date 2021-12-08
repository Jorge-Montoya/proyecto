package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyecto.models.modelo;
import com.example.proyecto.cosasrecycler.adaptator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch, bSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=findViewById(R.id.luces);
        iniciar();
    }

    public void iniciar(){

        List<modelo> elements=new ArrayList<>();

        elements.add(new modelo("Temperatura",new Intent(this,Temperatura.class)));
        elements.add(new modelo("Humedad",new Intent(this,Temperatura.class)));
        elements.add(new modelo("Humo",new Intent(this,Temperatura.class)));
        elements.add(new modelo("Ultrasonico",new Intent(this,Temperatura.class)));
        elements.add(new modelo("Movimiento",new Intent(this,Temperatura.class)));

        adaptator root=new adaptator(elements, this, new adaptator.OnItemClickListener() {
            @Override
           public void OnItemClick(adaptator view) {

            }
        });


        RecyclerView recyclerView= findViewById(R.id.reciclador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(root);
    }

    public void onclick(View view) {
        if (view.getId()==R.id.luces){
            if (aSwitch.isChecked()){
                String url = "https://io.adafruit.com/api/v2/Jared_Marentez/feeds/led/data";
                JSONObject datos = new JSONObject();
                try {
                    datos.put("value", "ON");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest sendData = new JsonObjectRequest(Request.Method.POST, url, datos, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "Luces encendidas", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();


                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("X-AIO-Key","aio_EDbk824WyerjDic1ewTuAA4eYjOI");
                        return headers;
                    }
                };

                SingletonRequest.getInstance(this).addToRequestQue(sendData);
            } else{
                String url = "https://io.adafruit.com/api/v2/Jared_Marentez/feeds/led/data";
                JSONObject datos = new JSONObject();
                try {
                    datos.put("value", "OFF");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest sendData = new JsonObjectRequest(Request.Method.POST, url, datos, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "Luces apagadas", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();


                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("X-AIO-Key","aio_EDbk824WyerjDic1ewTuAA4eYjOI");
                        return headers;
                    }
                };
                SingletonRequest.getInstance(this).addToRequestQue(sendData);
            }
        }
    }
}