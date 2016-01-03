package com.example.watchdogs.mtestmapa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.Registrarbottondir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, registro.class));
            }
        });

        findViewById(R.id.accederboton).setOnClickListener(new LoginListener(this));
    }

    public LoginInfo getLoginInfo() {
        try {
            EditText textCorreo = (EditText) findViewById(R.id.correocampo);
            String correo = textCorreo.getText().toString();

            EditText textPassword = (EditText) findViewById(R.id.contraseñacampo);
            String contraseña = textPassword.getText().toString();

            return new LoginInfo(correo, contraseña);
        } catch (Exception e) {
            showMessage(e.getMessage());
            return null;
        }
    }

    public void loginSuccesful() {
        showMessage("Login exitoso");
        startActivity(new Intent(LoginActivity.this, Main22Activity.class));
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
