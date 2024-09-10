package tp_5;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Directorio {
    private TreeMap<Long, Contacto> contactos;
    
    public Directorio(){
        this.contactos = new TreeMap<>();
    }
    
    public void agregarContacto(Long telefono, Contacto contacto){
        contactos.put(telefono, contacto);
    }
    
    public Contacto buscarContacto(Long telefono){
        return contactos.get(telefono);
    }
    
    public Set<Long> buscarTelefono(String apellido){
        Set<Long> telefonos = new TreeSet<>();
        for(Map.Entry<Long, Contacto> entry : contactos.entrySet()){
            if(entry.getValue().getApellido().equals(apellido)){
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }
    
    public ArrayList<Contacto> buscarContactos(String ciudad){
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        for(Contacto contacto : contactos.values()){
            if(contacto.getCiudad().equals(ciudad)){
                listaContactos.add(contacto);
            }
        }
        return listaContactos;
    }
    
    public void borrarContacto(Long telefono){
        contactos.remove(telefono);
    }
}