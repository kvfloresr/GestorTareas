package com.adrian.angenda_online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonIniciarSesion = findViewById(R.id.IniciarSesion);
        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad del menú principal
                Intent intent = new Intent(Login.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
