package com.manriquetavi.curso3semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DetalleContacto extends AppCompatActivity {

    private TextView txtName;
    private TextView txtPhoneNum;
    private TextView txtMailContent;
    private TextView txtDescriptionContent;
    private TextView txtBirthDateNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_detalle);


        Bundle parametros = getIntent().getExtras();
        String nombrecompleto = parametros.getString("NombreCompleto");
        String celular = parametros.getString("Celular");
        String correo = parametros.getString("Correo");
        String fecha = parametros.getString("Fecha");
        String descripcion = parametros.getString("Descripcion");


        txtName = (TextView)findViewById(R.id.txtName);
        txtPhoneNum = (TextView)findViewById(R.id.txtPhoneNum);
        txtMailContent = (TextView)findViewById(R.id.txtMailContent);
        txtBirthDateNum = (TextView)findViewById(R.id.txtBirthDateNum);
        txtDescriptionContent = (TextView)findViewById(R.id.txtDescriptionContent);

        txtName.setText(nombrecompleto);
        txtPhoneNum.setText(celular);
        txtMailContent.setText(correo);
        txtBirthDateNum.setText(fecha);
        txtDescriptionContent.setText(descripcion);

    }

    //Metodo para el boton "Editar Datos"
    public void editarDatos(View view){
        finish();
    }
}