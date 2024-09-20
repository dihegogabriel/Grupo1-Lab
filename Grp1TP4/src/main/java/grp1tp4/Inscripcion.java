/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grp1tp4;

import static grp1tp4.Colegio.listaAlumnos;
import static grp1tp4.Colegio.listaMaterias;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author grupo1-l@boratorio_TUDS */
public class Inscripcion {
    private LocalDate fecha;
    private int codigoMat;
    private int codigoAlu;
    private String sel;

    public Inscripcion(LocalDate fecha, int codigoMat, int codigoAlu) {
        this.fecha = fecha;
        this.codigoMat = codigoMat;
        this.codigoAlu = codigoAlu;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        sel= "";
        for (Materia materia : listaMaterias) {
            if(materia.getIdMateria() == codigoMat){
                sel= materia.getNombre();
            }           
        }
        return sel;
    }


    public String getAlumno() {
        sel= "";
        for (Alumno alumno : listaAlumnos) {
            if(alumno.getLegajo() == codigoAlu){
                sel= alumno.toString();
            }           
        }
        return sel;        

    }

    public int getCodigoMat() {
        return codigoMat;
    }

    public void setCodigoMat(int codigoMat) {
        this.codigoMat = codigoMat;
    }

    public int getCodigoAlu() {
        return codigoAlu;
    }

    public void setCodigoAlu(int codigoAlu) {
        this.codigoAlu = codigoAlu;
    }


    @Override
    public String toString() {
        return "Inscripcion{" + "fecha=" + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", codigoMat=" + codigoMat + ", codigoAlu=" + codigoAlu + '}';
    }

}
