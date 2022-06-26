package com.upchiapas.CargaManual.models;

public class Usuario {
    private int matricula;
    private String password;

    public Usuario(int matricula, String password){
        this.matricula=matricula;
        this.password=password;
    }
    public Usuario(){}

    public int getMatricula() {return matricula;}

    public String getPasware() {return password;}

    public void setMatricula(int matricula) {this.matricula = matricula;}
}
