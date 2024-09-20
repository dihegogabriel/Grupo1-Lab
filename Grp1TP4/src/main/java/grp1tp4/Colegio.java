/*
 Un Alumno tiene un nro de legajo, un apellido, un nombre y una lista HashSet de 
materias en las que está inscripto; para ello tiene un método agregarMateria que 
permite inscribir al Alumno en una materia determinada (implementar de manera tal 
que no deje inscribir un alumno en dos materias iguales.) y otro método cantidadMaterias 
que devuelve la cantidad de materias a las que está inscripto el alumno.

La Materia tiene un idMateria, un nombre de la materia y año al que pertenece, 
tiene además un constructor que inicializa sus propiedades y métodos get y set 
para cada uno de sus atributos.

Se pide:

En el método main de una clase de nombre Colegio:

1. Crear las materias:
a. Ingles I de primer año.
b. Matemáticas de primer año. c. Laboratorio 1 de primer año

2. Crear 2 alumnos.
a. López Martin con legajo 1001.
b. Martínez Brenda con legajo 1002. 

3. Inscribir a López en las 3 materias.

4. Inscribir a Martínez en las 3 materias y volver a inscribirlo en Laboratorio 1. 

5. Visualizar la cantidad de materias a las que está inscripto cada alumno.
 */

package grp1tp4;

import java.time.LocalDate;
import java.util.HashSet;

/**
 *
 * @author grupo1-l@boratorio_TUDS */

public class Colegio {
            public static HashSet<Alumno> listaAlumnos= new HashSet(); ;
            public static HashSet<Materia> listaMaterias= new HashSet();
            public static HashSet<Inscripcion> listaInscripciones= new HashSet();
        
            public static void main(String[] args) {
            
            Materia mat1= new Materia(154, "Ingles 1", 1);
            Materia mat2= new Materia(155, "Matemática", 1);
            Materia mat3= new Materia(156, "Laboratorio 1", 1);
            listaMaterias.add(mat1);
            listaMaterias.add(mat2);
            listaMaterias.add(mat3);
            
            Alumno alu1= new Alumno(1001,"López", "Martín");
            Alumno alu2= new Alumno(1002,"Martínez", "Brenda");
            listaAlumnos.add(alu1);
            listaAlumnos.add(alu2);
                
            Inscripcion inc1= new Inscripcion(LocalDate.now(),154,1001);
            Inscripcion inc2= new Inscripcion(LocalDate.now(),155,1001);
            Inscripcion inc3= new Inscripcion(LocalDate.now(),156,1001);
            listaInscripciones.add(inc1);
            listaInscripciones.add(inc2);
            listaInscripciones.add(inc3);

            Principal.main(args);
            

            
            

            
    }
}
