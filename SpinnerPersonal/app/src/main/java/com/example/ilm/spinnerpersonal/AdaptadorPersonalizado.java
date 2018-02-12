package com.example.ilm.spinnerpersonal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Comparator;

/**
 * Created by rafa on 8/11/17.
 */
//aqui decimos de que tipo es el arrayAdapter,
    //comparator si vamos hacer con cadena de caracters o enteros, no hace falta, pero si vamos a ordenar de otra manera
    // ncesimos implementear la interfaz
public class AdaptadorPersonalizado extends ArrayAdapter<Ciudad> implements Comparator<Ciudad> {
    private Ciudad[] ciudades;
    private Activity activity;

    public AdaptadorPersonalizado(Context ctx, int txtViewResourceId, Ciudad[] objects){
        //si no hacemos el super nuestra clase base no tiene constacia, entoces no tendremos acceso a los métodos
        super(ctx, txtViewResourceId, objects);
        ciudades = objects;
        //saca de contexto la actividad para poder manejarla
        activity = (Activity)ctx;
    }

    //al ser un spinner necesitamos un dropDown
    @Override
    public View getDropDownView(int position, View cnvtView, ViewGroup prnt){
        return crearFilaPersonalizada(position, cnvtView, prnt);
    }
    //todos los metedos tiene que tener una manera de devolver cada unos de los views que formanParte de su GroupView
    // en la creacion se van a ir añadiendo al groupWiew
    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt){

        return crearFilaPersonalizada(pos, cnvtView, prnt);
    }

    /**
     * cuando se construye un adaptador
     *
     * @param position cada posicion del elemento dentro del view group parent
     * @param convertView
     * @param parent
     * @return devuelve mi fila que es un view que es donde fue llamado a los metodos que esta esperando
     */
    public View crearFilaPersonalizada(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = activity.getLayoutInflater();
        View miFila = inflater.inflate(R.layout.lineaspiner, parent, false);

        //aqui estaoms hacemos haciendo referencia a mi layout lineaspiner
        TextView nombre = (TextView) miFila.findViewById(R.id.nombre);
        //aqui el modelo de datos lo tenemos que indexar, cogemos el orden en que aparece en array
        nombre.setText(ciudades[position].getNombre());

        TextView descripcion = (TextView) miFila.findViewById(R.id.descripcion);
        descripcion.setText(ciudades[position].getDescripcion());

        TextView habitantes = (TextView) miFila.findViewById(R.id.habitantes);
        habitantes.setText(String.valueOf(ciudades[position].getHabitantes()));

        //aqui cogerra
        ImageView imagen = (ImageView) miFila.findViewById(R.id.imagenCiudad);
        imagen.setImageResource(ciudades[position].getImagen());
        return miFila;

    }

    // aqui hemos ordenado por habitantes, pero igual el usuario ha guadaro un dato de que quiere verlo de otra manera
    // esto se va utilizar cuando hagamos un sort de este modelo de datos, con lo cual tenemos ordenada la o personalizada
    // si tenemos la bbdd de datos esto no se usaria se hacía se hacia la peticion a la bbdd
    @Override
    public int compare(Ciudad ciudad, Ciudad t1) {
        //aqui
        if(ciudad.getHabitantes()>t1.getHabitantes())
            return 1;
        else if (ciudad.getHabitantes()<t1.getHabitantes())
            return -1;

        return 0;
    }
}
