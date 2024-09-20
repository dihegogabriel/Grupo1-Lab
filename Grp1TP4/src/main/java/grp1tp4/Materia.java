package grp1tp4;

import static grp1tp4.Colegio.listaMaterias;

/**
 *
 * @author grupo1-l@boratorio_TUDS */

public class Materia {
    
    private int idMateria;
    private String nombre;
    private int anio;

    public Materia(int idMateria, String nombre, int anio) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean crearMateria(Materia m){
        for (Materia materia : listaMaterias) {
            if(materia.equals(m)){
                listaMaterias.add(m);
                return true;
            }           
        }
        return false;      
    }
    
    @Override
    public String toString() {
        return  nombre + " (Año: " + anio+ ")";
    }
    
    
}
