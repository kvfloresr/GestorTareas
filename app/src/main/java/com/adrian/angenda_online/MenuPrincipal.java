package com.adrian.angenda_online;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        // Configurar listener para gestionar los eventos de selección de elementos de la barra de navegación
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            // Aquí puedes manejar los eventos de selección de elementos de la barra de navegación
            // y realizar acciones correspondientes según el elemento seleccionado
            return true;
        });
    }
}