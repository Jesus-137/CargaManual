package com.upchiapas.CargaManual.models;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private int matricula;
    private ArrayList<Materia> materias;

    public Alumno(String nombre, int matricula, ArrayList<Materia> materias){
        this.nombre=nombre;
        this.matricula=matricula;
        this.materias=materias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void Materias(int cantida){
        for (int i=0; i<cantida;i++){
            System.out.printf(i+1+" "+materias.get(i).getNombre()+" en el grupo "+materias.get(i).getGrupo()+"\n");
        }
    }
}
