package com.upchiapas.CargaManual;

import com.upchiapas.CargaManual.models.Alumno;
import com.upchiapas.CargaManual.models.Materia;
import com.upchiapas.CargaManual.models.Usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Usuario> usuarios=new ArrayList<>();
    private static ArrayList<Materia> materias=new ArrayList<>(7);
    private static ArrayList<Alumno> alumnos=new ArrayList<>();
    private static Materia carga=new Materia();
    private static int sMateria=0;
    private static String nombre="-";
    private static Scanner entrada=new Scanner(System.in);
    public static void main(String[] args) {
        usuarios.add(new Usuario(123451, "abc"));
        usuarios.add(new Usuario(123452, "def"));
        usuarios.add(new Usuario(123453, "ghi"));
        usuarios.add(new Usuario(123454, "jkl"));
        usuarios.add(new Usuario(123455, "mno"));
        usuarios.add(new Usuario(123456, "pqrs"));
        iniciarSesion();
    }

    public static void iniciarSesion(){
        int matricula;
        String passware; boolean inicio=false; boolean maestro=false; int j=0;
        do{
            System.out.println("Ingrese su matricula");
            matricula=entrada.nextInt();
            System.out.println("Ingrese su contraceña");
            passware=entrada.next();
            for (int i=0; i<6; i++){
                if (matricula==usuarios.get(i).getMatricula()&& passware.equals(usuarios.get(i).getPasware())){
                    System.out.println("Inicio de sesion exitoso");
                    inicio=true;
                    if(passware.length()==4){
                        maestro=true;
                        j=i;
                    }
                }
            }
            if (!inicio){
                System.out.println("Matricula o contraceña incorrectos vuelva a intentar");
            }
        } while (!inicio);
        cargarMaterias(maestro, j);
    }

    public static void cargarMaterias(boolean maestro,int j){
        String materia, grupo;
        if (!maestro){
            System.out.println("Ingrese su nombre");
            nombre=entrada.next();
            System.out.println("Indique la cantidad de materias a cargar");
            sMateria=entrada.nextInt();
            for (int i=0;i<sMateria; i++){
                System.out.println("Que materia quieres cargar");
                materia = entrada.next();
                System.out.println("En que grupo quiere llevar la matria");
                grupo = entrada.next();
                materias.add(new Materia(materia, grupo.charAt(0)));
                alumnos.add(new Alumno(nombre, usuarios.get(i).getMatricula(),materias));
            }
            carga=solicidudCargaManual();
        }
        else
            mostrarCargaManual(sMateria);
        iniciarSesion();
    }
    public static Materia solicidudCargaManual() {
        String nombre="-"; String comparador, grupo="-";
        System.out.println("Desea carga manual?");
        comparador=entrada.next();
        if (comparador.equals("si")||comparador.equals("Si")) {
            System.out.println("Ingrese la materia que desea cargar");
            nombre = entrada.next();
            System.out.println("Ingrese el grupo en el que quiere llevar su materia");
            grupo = entrada.next();
        }
        return new Materia(nombre, grupo.charAt(0));
    }
    public static void mostrarCargaManual(int sMateria){
        int matrucula, i=0; boolean mas=true; String opcion;
        Iterator iterator=alumnos.iterator();
        System.out.println("Ingrese la matricula del alumno que desea buscar");
        matrucula=entrada.nextInt();
        while (mas&&iterator.hasNext()) {
            if (matrucula==alumnos.get(i).getMatricula()) {
                System.out.println("El alumno " + alumnos.get(i).getNombre() + " tiene las siguentes materias ");
                alumnos.get(i).Materias(sMateria);
                mas=false;
                System.out.print("El alumno "+alumnos.get(i).getNombre()+" quiere cargar esta materia: "+carga.getNombre()+" en el grupo: "+carga.getGrupo()+"\n");
                System.out.println("Cargar materia?");
                opcion=entrada.next();
                if (opcion.equals("Si")||opcion.equals("si")){
                    materias.add(carga);
                    System.out.println("Se añadio la materia");
                }
            }
            iterator.next();
            i++;
        }
    }
}
