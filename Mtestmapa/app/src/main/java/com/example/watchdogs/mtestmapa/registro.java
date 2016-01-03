package com.example.watchdogs.mtestmapa;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class registro extends AppCompatActivity {
ImageView foto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        foto2 = (ImageView) findViewById(R.id.foto);
        foto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Contact Image"), 1);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registro.this, LoginActivity.class));
            }
        });

        findViewById(R.id.botonguardar).setOnClickListener(new SignUpListener(this));


    }


    public UserInfo getUserInfo() {
        try {
            EditText textNombre = (EditText) findViewById(R.id.editnombre);
            String nombre = textNombre.getText().toString();

            EditText textPassword = (EditText) findViewById(R.id.editcontraseña);
            String contraseña = textPassword.getText().toString();

            EditText textCorreo = (EditText) findViewById(R.id.editcorreo);
            String correo = textCorreo.getText().toString();

            EditText textTelefono = (EditText) findViewById(R.id.edittelefono);
            String telefono = textTelefono.getText().toString();

            EditText textEdad = (EditText) findViewById(R.id.editedad);
            String stringedad = textEdad.getText().toString();

            int edad = stringedad.equals("")? 0: Integer.parseInt(stringedad);


            EditText textSexo = (EditText) findViewById(R.id.editsexo);
            String sexo = textSexo.getText().toString();

            return new UserInfo(nombre, edad, sexo, telefono, new LoginInfo(correo, contraseña));
        } catch (Exception e) {
            showMessage(e.getMessage());
            return null;
        }
    }

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
