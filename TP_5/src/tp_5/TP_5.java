package tp_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TP_5{
    public class FormularioContacto extends JFrame {
    private JTextField dniField, nombreField, apellidoField, ciudadField, direccionField, telefonoField;
    private JButton agregarButton;

    public FormularioContacto() {
        setTitle("Formulario de Contacto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Crear campos de entrada
        dniField = new JTextField();
        nombreField = new JTextField();
        apellidoField = new JTextField();
        ciudadField = new JTextField();
        direccionField = new JTextField();
        telefonoField = new JTextField();

        // Crear botón de agregar
        agregarButton = new JButton("Agregar Contacto");

        // Añadir componentes al formulario
        add(new JLabel("DNI:"));
        add(dniField);
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido:"));
        add(apellidoField);
        add(new JLabel("Ciudad:"));
        add(ciudadField);
        add(new JLabel("Dirección:"));
        add(direccionField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(agregarButton);

        // Acciones del botón
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });
    }

    private void agregarContacto() {
        String dni = dniField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String ciudad = ciudadField.getText();
        String direccion = direccionField.getText();
        Long telefono = Long.valueOf(telefonoField.getText());

        Contacto nuevoContacto = new Contacto(dni, nombre, apellido, ciudad, direccion, telefono);
        // Aquí deberías llamar al método agregarContacto del directorio
        // directorio.agregarContacto(nuevoContacto);

        JOptionPane.showMessageDialog(this, "Contacto agregado: " + nombre);
        clearFields();
    }

    private void clearFields() {
        dniField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        ciudadField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioContacto formulario = new FormularioContacto();
            formulario.setVisible(true);
        });
    }
}}