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
        Iterator<Materia> i = listaMaterias.iterator();
        boolean rep = false;
        
            while (i.hasNext()) {
                Materia mat = i.next();
                if (mat.equals(m)) {
                    rep = true;
                    System.out.println("Ya se ha agregado esta materia (" + m.getNombre() + " ) ");
                    break;
                }
            }
            if(!rep){
                listaMaterias.add(m);
                System.out.println("Se ha agregado la materia " + m.getNombre());
            }
    }
    public void listarMaterias(){
        if (listaMaterias.isEmpty()){
            System.out.println("Este alumno no se ha matriculado en ninguna materia");            
        } else {
            System.out.println("Materias inscritas del alumno ("+nombre+" "+apellido+ ")");
            for (Materia mat : listaMaterias){
                System.out.println(mat.getNombre());
            }
        }
    }
}

