package com.example.ilm.spinnerpersonal;

/**
 * Created by rafa on 8/11/17.
 */

public class Ciudad {
    private String nombre;
    private String descripcion;
    private int habitantes;
    private int imagen;

    public Ciudad(String nombre, String descripcion, int habitantes, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.habitantes = habitantes;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
