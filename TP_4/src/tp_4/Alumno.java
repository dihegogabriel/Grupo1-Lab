package tp_4;

import java.util.HashSet;
import java.util.Iterator;

public class Alumno {
    int legajo;
    String apellido;
    String nombre;
    HashSet<Materia> listaMaterias = new HashSet<>();

    public Alumno(int legajo, String apellido, String nombre) {
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
    
    public void agregarMateria(Materia m){
        Iterator i = listaMaterias.iterator();
        boolean rep = false;
        while (i.hasNext()) {            
            if(i.next() == m){
                rep = true;
            }
        }
        if(rep){
            listaMaterias.add(m);
        }
    }
}
