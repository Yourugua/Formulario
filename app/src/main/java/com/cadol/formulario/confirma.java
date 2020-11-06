package com.cadol.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;

public class confirma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion);

        AppCompatButton btneditar = (AppCompatButton) findViewById(R.id.btneditar);

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saco texto Nombre
                TextView txtNombre = (TextView) findViewById(R.id.datoNombre);
                final String tmpNombre = (String) txtNombre.getText();
                //Saco texto f_Nacieminto
                TextView txtFnacimiento = (TextView) findViewById(R.id.datoFecha);
                final CharSequence tmpfecha = txtFnacimiento.getText();;
                //Saco texto Telefono
                TextView txtTel = (TextView) findViewById(R.id.datoTel);
                final CharSequence tmpTel = (String) txtTel.getText();
                //Saco texto Email
                TextView txtemail = (TextView) findViewById(R.id.datoEmail);
                final CharSequence tmpEmail = txtemail.getText();
                //Saco texto Descripcion
                TextView txtDescr = (TextView) findViewById(R.id.datoDescr);
                final CharSequence tmpDescr = txtDescr.getText();

                Intent intent = new Intent(confirma.this, MainActivity.class);
                intent.putExtra("Dato12", String.valueOf(tmpNombre));
                intent.putExtra("Dato22", String.valueOf(tmpfecha));
                intent.putExtra("Dato32",String.valueOf(tmpTel));
                intent.putExtra("Dato42",String.valueOf(tmpEmail));
                intent.putExtra("Dato52",String.valueOf(tmpDescr));

                startActivity(intent);
                finish(); // Finalizo la actividad anterior es decir dejo solo la de los datos.
            }
        });

        ReciboDatos();
    }

    private void ReciboDatos() {
        // Defino TextView
        TextView datoNombre;
        TextView datoFecha;
        TextView datoTel;
        TextView datoEmail;
        TextView datoDescr;

        Bundle parametros = getIntent().getExtras();
        // Traigo String
        String nombre   = parametros.getString("Dato1");
        String Nacimiento   = parametros.getString("Dato2");
        String Telefono   = parametros.getString("Dato3");
        String Email   = parametros.getString("Dato4");
        String Descripcion   = parametros.getString("Dato5");

        // Cargo
        datoNombre   = findViewById(R.id.datoNombre);
        datoFecha   = findViewById(R.id.datoFecha);
        datoTel   = findViewById(R.id.datoTel);
        datoEmail   = findViewById(R.id.datoEmail);
        datoDescr   = findViewById(R.id.datoDescr);

        // Muestro
        datoNombre.setText(nombre);
        datoFecha.setText(Nacimiento);
        datoTel.setText(Telefono);
        datoEmail.setText(Email);
        datoDescr.setText(Descripcion);

    }

}
