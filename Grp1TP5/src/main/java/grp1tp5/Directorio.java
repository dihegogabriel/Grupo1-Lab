package grp1tp5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Directorio {
    private TreeMap<Long, Contacto> directorioTelefonico;
    private TreeSet<Contacto> listaContactos;
    
    public Directorio(){
        this.directorioTelefonico = new TreeMap<>();
        this.listaContactos = new TreeSet<>();
    }
    
    public boolean agregarContacto(Long telefono, Contacto contacto){
        Iterator<Contacto> listaC = listaContactos.iterator();
        while(listaC.hasNext()){
            if(listaC.next().compareTo(contacto)==0){                            
                return false;
            }
        }        
        for(Map.Entry<Long, Contacto> entry : directorioTelefonico.entrySet()){
            if(entry.getKey().equals(telefono)){
                return false;
            }
        }
        listaContactos.add(contacto);
        directorioTelefonico.put(telefono, contacto);        
        return true;        
    }
    
    public Contacto buscarContacto(Long telefono){        
        return directorioTelefonico.get(telefono);
    }
    
    public Set<Long> buscarTelefono(String apellido){
        Set<Long> telefonos = new TreeSet<>();
        for(Map.Entry<Long, Contacto> entry : directorioTelefonico.entrySet()){
            if(entry.getValue().getApellido().equals(apellido)){
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }
    
    public ArrayList<Contacto> buscarContactos(String ciudad){
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        for(Contacto contacto : directorioTelefonico.values()){
            if(contacto.getCiudad().equals(ciudad)){
                listaContactos.add(contacto);
            }
        }
        return listaContactos;
    }
    
    public void borrarContacto(Long telefono){
        Contacto contacto = directorioTelefonico.get(telefono);
        Iterator<Contacto> listaC = listaContactos.iterator();
        while(listaC.hasNext()){
            if(listaC.next().compareTo(contacto)==0){                            
                listaC.remove();
            }
        }                
        directorioTelefonico.remove(telefono);
    }
}