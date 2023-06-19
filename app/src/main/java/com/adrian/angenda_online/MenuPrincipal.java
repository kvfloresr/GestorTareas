package com.adrian.angenda_online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_mas) {
                    // Iniciar la actividad de añadir
                    Intent intent = new Intent(MenuPrincipal.this, Anadir.class);
                    startActivity(intent);
                    return true;
                }
                else if (itemId == R.id.navigation_calendario) {
                    // Iniciar la actividad de inicio
                    Intent intent = new Intent(MenuPrincipal.this, Calendario.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });
    }
}
