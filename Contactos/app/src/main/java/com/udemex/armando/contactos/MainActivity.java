package com.udemex.armando.contactos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nombre= null;
    private TextInputEditText telefono = null;
    private TextInputEditText email = null;
    private TextInputEditText desc = null;
    DatePicker dpFecha;


    private String nombree="";
    private String telefonoe="";
    private String emaile="";
    private String desce="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (TextInputEditText) findViewById(R.id.txtnombre);
        telefono = (TextInputEditText) findViewById(R.id.txttelefono);
        email = (TextInputEditText) findViewById(R.id.txtmail);
        desc = (TextInputEditText) findViewById(R.id.txtdescripcion);
        dpFecha = (DatePicker)findViewById(R.id.calen);

        try {
            nombree = getIntent().getStringExtra("nombre");
            telefonoe = getIntent().getStringExtra("telefono");
            emaile = getIntent().getStringExtra("email");
            desce= getIntent().getStringExtra("desc");
            dpFecha.updateDate(getIntent().getExtras().getInt(getResources().getString(R.string.pFecha_nacimientoYear)),  getIntent().getExtras().getInt(getResources().getString(R.string.pFecha_nacimientoMonth)), getIntent().getExtras().getInt(getString(R.string.pFecha_nacimientoDay)));
            nombre.setText(nombree);
            telefono.setText(telefonoe);
            email.setText(emaile);
            desc.setText(desce);

        }catch (Exception e){}

    }



    public void enviar(View view){
        Intent intent = new Intent(MainActivity.this, Presentacion.class);
        intent.putExtra("nombre",""+nombre.getText().toString());
        intent.putExtra("telefono",telefono.getText().toString());
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("desc",desc.getText().toString());
        int year = dpFecha.getYear();
        int month = dpFecha.getMonth();
        int day = dpFecha.getDayOfMonth();
        intent.putExtra(getString(R.string.pFecha_nacimientoYear), year);
        intent.putExtra(getString(R.string.pFecha_nacimientoMonth), month);
        intent.putExtra(getString(R.string.pFecha_nacimientoDay), day);
        startActivity(intent);

    }
}
