package grp1tp5;


public class Contacto implements Comparable<Contacto> {
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;

    public Contacto(int dni, String nombre, String apellido, String direccion, String ciudad){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public String toString(){
        return "DNI: " + dni + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Direccion: " + direccion + ", Ciudad: " + ciudad;        
    }
    
    @Override
    public int compareTo(Contacto o){
        if(dni == o.dni){
            return 0;
        }else if (dni > o.dni){
            return 1;
        }else{
            return -1;
        }
    }
}
