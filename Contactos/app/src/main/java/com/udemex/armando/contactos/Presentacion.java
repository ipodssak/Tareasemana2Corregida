package com.udemex.armando.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Presentacion extends AppCompatActivity {
    private String nombre="";
    private String telefono="";
    private String email="";
    private String desc="";
    int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        TextView j = (TextView)findViewById(R.id.nombresineditar);
        TextView k = (TextView)findViewById(R.id.telefonosin);
        TextView l = (TextView)findViewById(R.id.emailsin);
        TextView o = (TextView)findViewById(R.id.txtfecha);
        TextView m = (TextView)findViewById(R.id.txtdesc);

        nombre = getIntent().getStringExtra("nombre");
        telefono = getIntent().getStringExtra("telefono");
        email = getIntent().getStringExtra("email");
        desc = getIntent().getStringExtra("desc");

        ano = getIntent().getExtras().getInt(getString(R.string.pFecha_nacimientoYear));
        dia= getIntent().getExtras().getInt(getString(R.string.pFecha_nacimientoDay));
        mes = getIntent().getExtras().getInt(getString(R.string.pFecha_nacimientoMonth));

        j.setText("Nombre:   "+nombre);
        k.setText("Telefono:  "+telefono);
        l.setText("Email:  "+email);
        m.setText("Desc:  "+desc);
        int messs=mes+1;


        String fecha = "La fecha de nacimiento es  "+dia+" "+messs+" "+ano;

        o.setText(""+fecha);

    }

    public void editar(View view){
        Intent intent = new Intent(Presentacion.this, MainActivity.class);
        intent.putExtra("nombre",""+nombre);
        intent.putExtra("telefono",telefono);
        intent.putExtra("email",email);
        intent.putExtra("desc",desc);
        intent.putExtra(getString(R.string.pFecha_nacimientoYear), ano);
        intent.putExtra(getString(R.string.pFecha_nacimientoMonth), mes);
        intent.putExtra(getString(R.string.pFecha_nacimientoDay), dia);


        startActivity(intent);

    }
}
