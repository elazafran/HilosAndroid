package com.example.ilm.selecciones;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MyActivity extends Activity implements ListView.OnItemClickListener{

    public void onItemClick(AdapterView<?> a, View view, int position, long id){
        TextView t=(TextView)findViewById(R.id.textView);
        t.setText("Has elegido:"+a.getItemAtPosition(position).toString());
        //t.setText("Has elegido:"+((TextView)view).getText()); //OTRA OPCIÓN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String [] elementos={"Toledo","Ciudad Real","Cuenca","Guadalajara","Albacete"};
        ArrayAdapter<String> adaptador;

        ListView l=(ListView)findViewById(R.id.listView);

        //elementos es el modelo de datos

        adaptador=new ArrayAdapter<String>(this,R.layout.fila,elementos);

        //l.setAdapter(new ListAdapter(this,R.layout.fila));
        // aqui se produce onAttach()
        l.setAdapter(adaptador);
        l.setOnItemClickListener(this);
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
