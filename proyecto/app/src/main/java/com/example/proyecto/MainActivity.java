package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.proyecto.models.modelo;
import com.example.proyecto.cosasrecycler.adaptator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*
<<<<<<< HEAD
=======
*/
        iniciar();/*
>>>>>>> b214914c24b159fb6df5f0ae467416a3e5ffe80c*/
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

}