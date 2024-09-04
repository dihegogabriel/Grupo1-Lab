package tp_4;

public class Colegio {
    public static void main(String[] args) {
        Materia materia1 = new Materia(1, "Ingles I", 1);
        Materia materia2 = new Materia(2, "Matematicas", 1);
        Materia materia3 = new Materia(3, "Laboratorio 1", 1);
        
        Alumno alumno1 = new Alumno(1001, "López", "Martin");
        Alumno alumno2 = new Alumno(1002, "Martínez", "Brenda");
        
        alumno1.agregarMateria(materia3);
        alumno1.agregarMateria(materia2);
        alumno1.agregarMateria(materia1);
        
        alumno2.agregarMateria(materia3);
        alumno2.agregarMateria(materia2);
        alumno2.agregarMateria(materia1);
        alumno2.agregarMateria(materia1);
    }
}