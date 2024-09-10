package tp_5;

public class TP_5 {

    public static void main(String[] args){
        Directorio directorio = new Directorio();
        
        Contacto contacto1 = new Contacto("11223344", "Sargento", "Garcia", "Destacamento 16", "Los Angeles");
        Contacto contacto2 = new Contacto("22334455", "Diego", "Vega", "Rancho de la Vega", "Los Angeles");
        Contacto contacto3 = new Contacto("33445566", "Martin", "Garcia", "Adolfina 362", "La Plata");
        Contacto contacto4 = new Contacto("44556677", "Alejo", "Acosta", "Antezana 247", "Villa Crespo");
        Contacto contacto5 = new Contacto("55667788", "Jesica", "Lampadatti", "Amberes 1086", "Caballito");
        
        directorio.agregarContacto(5473849244L, contacto1);
        directorio.agregarContacto(1346474321L, contacto2);
        directorio.agregarContacto(2436679763L, contacto3);
        directorio.agregarContacto(8762459234L, contacto4);
        directorio.agregarContacto(3785386733L, contacto5);
        
        System.out.println("Contacto con el telefono: 5473849244 " + directorio.buscarContacto(5473849244L));
        System.out.println("Telefonos con apellido Garcia: " + directorio.buscarTelefono("Garcia"));
        System.out.println("Contactos de Los Angeles: " + directorio.buscarContactos("Los Angeles"));
        directorio.borrarContacto(5473849244L);
        System.out.println("Se elimino el contacto con el telefono 5473849244: " + directorio.buscarContacto(5473849244L));
    }
}
