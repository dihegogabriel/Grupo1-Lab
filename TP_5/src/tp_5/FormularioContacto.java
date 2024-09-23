package tp_5;

import javax.swing.*;

public class FormularioContacto extends JFrame{
    private JTextField txtDni, txtNombre, txtApellido, txtDireccion, txtCiudad, txtTelefono;
    private Directorio directorio;

    public FormularioContacto(){
        directorio = new Directorio();
        setTitle("Formulario de Contacto");
        setLayout(null);

        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 30, 100, 25);
        add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(130, 30, 150, 25);
        add(txtDni);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 30, 100, 25);
        btnBuscar.addActionListener(e -> buscarContacto());
        add(btnBuscar);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 70, 150, 25);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 110, 100, 25);
        add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(130, 110, 150, 25);
        add(txtApellido);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(30, 150, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(130, 150, 150, 25);
        add(txtDireccion);

        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setBounds(30, 190, 100, 25);
        add(lblCiudad);

        txtCiudad = new JTextField();
        txtCiudad.setBounds(130, 190, 150, 25);
        add(txtCiudad);

        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(30, 230, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(130, 230, 150, 25);
        add(txtTelefono);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(30, 270, 100, 25);
        btnNuevo.addActionListener(e -> limpiarFormulario());
        add(btnNuevo);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 270, 100, 25);
        btnGuardar.addActionListener(e -> guardarContacto());
        add(btnGuardar);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(270, 270, 100, 25);
        btnBorrar.addActionListener(e -> borrarContacto());
        add(btnBorrar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(390, 270, 100, 25);
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);

        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // funcion para buscar un contacto por número de teléfono
    private void buscarContacto(){
        try{
            Long telefono = Long.parseLong(txtTelefono.getText());
            Contacto contacto = directorio.buscarContacto(telefono);
            
            if(contacto != null){
                txtDni.setText(contacto.getDni());
                txtNombre.setText(contacto.getNombre());
                txtApellido.setText(contacto.getApellido());
                txtDireccion.setText(contacto.getDireccion());
                txtCiudad.setText(contacto.getCiudad());
                JOptionPane.showMessageDialog(this, "Contacto encontrado.");
            }else{
                JOptionPane.showMessageDialog(this, "Contacto no encontrado.");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número de teléfono válido.");
        }
    }

    // funcion para guardar un nuevo contacto
    private void guardarContacto(){
        try{
            Long telefono = Long.parseLong(txtTelefono.getText());
            String dni = txtDni.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String direccion = txtDireccion.getText();
            String ciudad = txtCiudad.getText();

            Contacto nuevoContacto = new Contacto(dni, nombre, apellido, direccion, ciudad);
            directorio.agregarContacto(telefono, nuevoContacto);
            
            JOptionPane.showMessageDialog(this, "Contacto guardado exitosamente.");
            limpiarFormulario();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número de teléfono válido.");
        }
    }

    // funcion para borrar un contacto
    private void borrarContacto(){
        try{
            Long telefono = Long.parseLong(txtTelefono.getText());
            Contacto contacto = directorio.buscarContacto(telefono);

            if(contacto != null){
                directorio.borrarContacto(telefono);
                JOptionPane.showMessageDialog(this, "Contacto borrado exitosamente.");
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(this, "Contacto no encontrado.");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número de teléfono válido.");
        }
    }

    // limpiar el formulario
    private void limpiarFormulario(){
        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
        txtTelefono.setText("");
    }

    public static void main(String[] args){
        new FormularioContacto();
    }
}