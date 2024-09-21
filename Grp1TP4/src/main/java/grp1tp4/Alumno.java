package grp1tp4;

import java.util.HashSet;
import java.util.Iterator;

public class Alumno{
    private int legajo;
    private String apellido;
    private String nombre;
    private HashSet <Materia> listaMaterias = new HashSet();
    
    public Alumno(int legajo, String apellido, String nombre){
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean agregarMateria(Materia m){
        for (Materia materia : listaMaterias) {
            if(materia.equals(m)){
                listaMaterias.add(m);
                return true;
            }           
        }
        return false;      
    }

    @Override
    public String toString(){
        return nombre + " " + apellido;
    }
    
    public int cantidadMaterias(){
        Iterator it = listaMaterias.iterator();
        int cantMaterias = 0;
        while (it.hasNext()) {            
            cantMaterias += 1;           
        }
        return cantMaterias;
    }
}