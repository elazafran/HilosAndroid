package com.example.ilm.menusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MyActivity extends Activity implements ListView.OnItemClickListener{

    ListView starks;
    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Creamos lista de starks para el menú contextual
        starks=(ListView)findViewById(R.id.listaStarks);
        registerForContextMenu(starks);

        //creamos lista de lannisters (seleccionable múltiple) para el
        //Action Mode Context Menu
        ListView listaLannisters=(ListView)findViewById(R.id.listaLannisters);

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                getResources().getStringArray(R.array.lannisters));



        listaLannisters.setAdapter(adaptador);
        listaLannisters.setOnItemClickListener(this);


    }

    public void onItemClick(AdapterView<?> p, View v, int position, long id){

        // Start the CAB using the ActionMode.Callback defined above
        mActionMode = MyActivity.this.startActionMode(mActionModeCallback);
        v.setSelected(true);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.starks,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.matar:
                Toast.makeText(getApplicationContext(), "Hemos matado a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
            case R.id.sanar:
                Toast.makeText(getApplicationContext(), "Hemos sanado a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
            case R.id.enviarmensjae:
                Toast.makeText(getApplicationContext(), "Le hemos enviado un mensaje a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "Le hemos hecho otra cosa a " +
                        starks.getItemAtPosition(info.position), Toast.LENGTH_LONG).show();
                return true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    //Se llama a este método cuando se ha seleccionado una opción del menú de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.Arbol:
                Toast.makeText(getApplicationContext(),"Se ha seleccionado Árbol Genialógico",Toast.LENGTH_LONG).show();
                return true;
            case R.id.ajustes:
                Toast.makeText(getApplicationContext(),"Se ha pulsado la opción de \"ajustes\"",Toast.LENGTH_LONG).show();
                return true;
            case R.id.verMiembros:
                Toast.makeText(getApplicationContext(),"Se ha pulsado la opción Ver Miembros",Toast.LENGTH_LONG).show();
                return true;
            case R.id.asesinados:
            case R.id.heridos:
            case R.id.aparecer:
            case R.id.vivos:
                Toast.makeText(getApplicationContext(),"Has seleccionado ver ("+item.getTitle()+")",Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Menú ActionMode
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.lannisters, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Se llama a este método cuando se ha pulsado en la lista de los lannisters
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId()) {
                case R.id.aniquilar:
                    //hay que crear un Aniquilar() para recorrer todos los elementos seleccionado (checked) en la listView
                    Toast.makeText(getApplicationContext(), "Hemos aniquilado a algún Lannister",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.encerrar:
                    Toast.makeText(getApplicationContext(), "Hemos encerrado a algún Lannister", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.salvar:
                    Toast.makeText(getApplicationContext(), "Hemos salvado a algún Lannister", Toast.LENGTH_LONG).show();
                    return true;

                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

}
