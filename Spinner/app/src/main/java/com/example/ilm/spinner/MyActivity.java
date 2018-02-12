package com.example.ilm.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MyActivity extends Activity implements Spinner.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] elementos = {"Toledo", "Ciudad Real", "Cuenca", "Guadalajara", "Albacete"};

        ArrayAdapter<String> adaptador;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Spinner sp = (Spinner) findViewById(R.id.spinner);
        //podemos usar adapter porque usamos cadenas sino habrá que hacer uno nosotros para pasar otro tipo de objetos
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementos);
        //le decimos que diseño/aspecto es el que se va a mostrar cuando se despliegue y utilizamos una plantilla de android
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adaptador);

        //hay otro evento onDropDown y el controlador de eventos
        sp.setOnItemSelectedListener(this);
    }
    //aqui implementamos un tipo distinto de evento
    public void onItemSelected(AdapterView<?> a, View view, int position, long id){
        TextView t=(TextView)findViewById(R.id.textView);
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        //mostarmos el texto del spninner seleccionado
        t.setText(sp.getSelectedItem().toString());
    }

    public void onNothingSelected(AdapterView<?> a){
        TextView t=(TextView)findViewById(R.id.textView);
        t.setText("No se ha seleccionado nada");
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
