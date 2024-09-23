package tp_5;

import java.util.*;

public class Directorio{
    private TreeMap<Long, Contacto> directorio = new TreeMap<>();

    // agregar contacto
    public void agregarContacto(Long telefono, Contacto contacto){
        directorio.put(telefono, contacto);
    }

    // buscar contacto por telefono
    public Contacto buscarContacto(Long telefono){
        return directorio.get(telefono);
    }

    // buscar Teléfonos por apellido
    public Set<Long> buscarTelefono(String apellido){
        Set<Long> telefonos = new HashSet<>();
        for(Map.Entry<Long, Contacto> entry : directorio.entrySet()){
            if(entry.getValue().getApellido().equalsIgnoreCase(apellido)){
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }

    // buscar contactos por ciudad
    public ArrayList<Contacto> buscarContactos(String ciudad){
        ArrayList<Contacto> contactosCiudad = new ArrayList<>();
        for(Contacto contacto : directorio.values()) {
            if(contacto.getCiudad().equalsIgnoreCase(ciudad)){
                contactosCiudad.add(contacto);
            }
        }
        return contactosCiudad;
    }

    // borrar Contacto por telefono
    public void borrarContacto(Long telefono){
        directorio.remove(telefono);
    }
}