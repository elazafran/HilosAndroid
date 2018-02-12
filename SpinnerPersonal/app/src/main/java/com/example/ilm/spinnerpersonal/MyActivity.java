package com.example.ilm.spinnerpersonal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MyActivity extends Activity implements Spinner.OnItemSelectedListener{

    Ciudad[] ciudades = { new Ciudad("Toledo", "La ciudad Imperial",240000,R.drawable.toledo),
            new Ciudad("Ciudad Real", "Qué gran ciudad",134000,R.drawable.ciudadreal),
            new Ciudad("Albacete","Ciudad gastronómica",156000,R.drawable.albacete),
            new Ciudad("Cuenca", "Ciudad encantada",210000,R.drawable.cuenca),
            new Ciudad("Guadalajara", "Ciudad colgante",104000,R.drawable.guadalajara) };

    //R.drawable.guadalajara esto es un numeor que le selecciona el diccionario que crea android


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //queremos utilizar un combo
        Spinner selectorCiudades = (Spinner) findViewById(R.id.spinner);
        //Aqui ya no llamamos a ArrayAdapter, hemos utilizados los mismo parametros pero porque hemos querido
        AdaptadorPersonalizado a=new AdaptadorPersonalizado(this, R.layout.lineaspiner, ciudades);
        selectorCiudades.setAdapter(a);
        selectorCiudades.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        TextView c=(TextView)view.findViewById(R.id.nombre);
        TextView seleccion=(TextView)findViewById(R.id.ciudadSeleccionada);

        seleccion.setText(c.getText());
    }

    public void onNothingSelected(AdapterView<?> parent){
        TextView seleccion=(TextView)findViewById(R.id.ciudadSeleccionada);
        seleccion.setText("nada seleccionado!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
