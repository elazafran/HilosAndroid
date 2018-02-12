package com.example.ilm.selecciones;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MyActivity extends Activity implements ListView.OnItemClickListener{

    public void onItemClick(AdapterView<?> a, View view, int position, long id){
        TextView t=(TextView)findViewById(R.id.textView);
        ListView l=(ListView)findViewById(R.id.listView);
        String seleccionado=new String();
        //esto devuelve un array de booleanos y se guarda en esta clase
        //mirar como hacer un objeto de este tipo de manera manual
        SparseBooleanArray checked = l.getCheckedItemPositions();

        for(int i=0;i<checked.size();i++)
            //esta indexado la colección, aqui trae valor verdadero o falso
            if(checked.valueAt(i)){
                seleccionado=seleccionado+
                        //aqui trae el nombre
                        a.getItemAtPosition(checked.keyAt(i)).toString()
                        +";";
            }
        t.setText(seleccionado);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String [] elementos={"Toledo","Ciudad Real","Cuenca","Guadalajara","Albacete"};

        ArrayAdapter<String> adaptador;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ListView l=(ListView)findViewById(R.id.listView);
        // aqui le decimos que es multiple
        l.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        //le pasamos un layout que ya viene listo de android
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,elementos);
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
