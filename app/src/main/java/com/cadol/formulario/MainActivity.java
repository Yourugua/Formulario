package com.cadol.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    public Editable tmpNombre;
    public Editable tmpTel;
    public Editable tmpEmail;
    public Editable tmpDescr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDisplayDate =  findViewById(R.id.txtFnacimiento);
        mDisplayDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int anio = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                    MainActivity.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    onDateSetListener,
                    anio,mes,dia);
                dialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                mes= mes +1;
                String date = dia + "/" + mes + "/" + anio;
                mDisplayDate.setText(date);
            }
        };

        AppCompatButton btnSiguiente = (AppCompatButton) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Saco texto Nombre
                TextInputEditText txtNombre = (TextInputEditText) findViewById(R.id.txtNombre);
                tmpNombre = txtNombre.getText();
                //Saco texto f_Nacieminto
                TextView txtFnacimiento = (TextView) findViewById(R.id.txtFnacimiento);
                final CharSequence tmpfecha = txtFnacimiento.getText();;
                //Saco texto Telefono
                TextInputEditText txtTel = (TextInputEditText) findViewById(R.id.txtTel);
                tmpTel = txtTel.getText();
                //Saco texto Email
                TextInputEditText txtemail = (TextInputEditText) findViewById(R.id.txtemail);
                tmpEmail = txtemail.getText();
                //Saco texto Descripcion
                EditText txtDescr = (EditText) findViewById(R.id.txtDescr);
                tmpDescr = txtDescr.getText();

                Intent intent = new Intent(MainActivity.this, confirma.class);
                intent.putExtra("Dato1", String.valueOf(tmpNombre));
                intent.putExtra("Dato2", String.valueOf(tmpfecha));
                intent.putExtra("Dato3",String.valueOf(tmpTel));
                intent.putExtra("Dato4",String.valueOf(tmpEmail));
                intent.putExtra("Dato5",String.valueOf(tmpDescr));

                startActivity(intent);
                finish(); // Finalizo la actividad anterior es decir dejo solo la de los datos.
            }
        });

        ReciboDatos2();
    }

    private void ReciboDatos2() {
        // Defino TextView
        TextInputEditText txtNombre;
        TextView txtFnacimiento;
        TextInputEditText txtTel;
        TextInputEditText txtemail;
        EditText txtDescr;

        Bundle parametros2 = getIntent().getExtras();
        // Traigo String
        if (parametros2 != null) {
          String nombre   = parametros2.getString("Dato12");
          String Nacimiento   = parametros2.getString("Dato22");
          String Telefono   = parametros2.getString("Dato32");
          String Email   = parametros2.getString("Dato42");
          String Descripcion   = parametros2.getString("Dato52");

          // Cargo
          txtNombre   = findViewById(R.id.txtNombre);
          txtFnacimiento   = findViewById(R.id.txtFnacimiento);
          txtTel   = findViewById(R.id.txtTel);
          txtemail   = findViewById(R.id.txtemail);
          txtDescr   = findViewById(R.id.txtDescr);

          // Muestro
          txtNombre.setText(nombre);
          txtFnacimiento.setText(Nacimiento);
          txtTel.setText(Telefono);
          txtemail.setText(Email);
          txtDescr.setText(Descripcion);
        };
    }
}