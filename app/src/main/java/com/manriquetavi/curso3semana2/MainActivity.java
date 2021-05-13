package com.manriquetavi.curso3semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private EditText textEditInputName;
    private EditText textEditInputPhone;
    private EditText textEditInputEmail;
    private EditText textEditInputDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        textEditInputName = (EditText)findViewById(R.id.textEditInputName);
        textEditInputPhone = (EditText)findViewById(R.id.textEditInputPhone);
        textEditInputEmail = (EditText)findViewById(R.id.textEditInputEmail);
        textEditInputDescription = (EditText)findViewById(R.id.textEditInputDescription);
    }

    //Metodo par el boton "Siguiente"
    public void siguiente(View view){
        Intent i = new Intent(this, DetalleContacto.class);
        i.putExtra("Fecha",dateButton.getText().toString());
        i.putExtra("NombreCompleto", textEditInputName.getText().toString());
        i.putExtra("Celular", textEditInputPhone.getText().toString());
        i.putExtra("Correo", textEditInputEmail.getText().toString());
        i.putExtra("Descripcion", textEditInputDescription.getText().toString());
        startActivity(i);
    }

    private String getTodaysDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dayOfMonth,month,year);
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth,month,year);
                dateButton.setText(date);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,dayOfMonth);
    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return getMonthFormat(month) + "/" + dayOfMonth + "/" + year;
    }

    public String getMonthFormat(int month) {
        switch (month){
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUG";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";
            default:
                return "INV";
        }
    }

    public void showDatePickerDialog(View view) {
        datePickerDialog.show();
    }
}