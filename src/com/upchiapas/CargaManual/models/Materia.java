package com.upchiapas.CargaManual.models;

public class Materia {
    private String nombre;
    private char grupo;

    public Materia(){
        this("-",'-');
    }
    public Materia(String nombre, char grupo){
        this.nombre=nombre;
        this.grupo=grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGrupo() {
        return grupo;
    }
}
