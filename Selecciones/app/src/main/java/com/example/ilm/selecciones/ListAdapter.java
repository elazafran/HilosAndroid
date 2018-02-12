package com.example.ilm.selecciones;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

/**
 * aqui tenemos solamente elementos de la vista,
 * hace controlador que comunica la vista con el modelo de datos
 *
 * Created by rafa on 6/11/17.
 */

public class ListAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    public ListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
