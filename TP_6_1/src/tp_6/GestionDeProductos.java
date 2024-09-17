package tp_6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionDeProductos extends JFrame {

    // interfaz component
    private JComboBox<String> categoriaComboBox;
    private JTextField nombreTextField;
    private JTextField precioTextField;
    private JButton agregarButton;
    private final JTable productosTable;
    private DefaultTableModel tableModel;

    public GestionDeProductos() {
        // window config
        setTitle("Gestión de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel panelControles = new JPanel();
        panelControles.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // etiqueta y comboBox de categoria
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelControles.add(new JLabel("Categoría:"), gbc);

        categoriaComboBox = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Farmacia", "Ropa", "Perfumería"});
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelControles.add(categoriaComboBox, gbc);

        // etiqueta y texto del nombre
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelControles.add(new JLabel("Nombre:"), gbc);

        nombreTextField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelControles.add(nombreTextField, gbc);

        // etiqueta y texto del precio
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelControles.add(new JLabel("Precio ($):"), gbc);

        precioTextField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelControles.add(precioTextField, gbc);

        // boton agregar producto
        agregarButton = new JButton("Agregar producto");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelControles.add(agregarButton, gbc);

        // panel para tabla
        String[] columnNames = {"Nombre", "Categoría", "Precio"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productosTable);

        // accion del botón agregar producto
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        // agregar paneles a la ventana
        add(panelControles, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agregarProducto() {
        // Validar los campos de entrada
        String categoria = (String) categoriaComboBox.getSelectedItem();
        String nombre = nombreTextField.getText();
        String precioTexto = precioTextField.getText();

        if (nombre.isEmpty() || precioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double precio = Double.parseDouble(precioTexto);

            // Agregar producto a la tabla
            Object[] nuevoProducto = {nombre, categoria, precio};
            tableModel.addRow(nuevoProducto);

            // Limpiar los campos de entrada
            nombreTextField.setText("");
            precioTextField.setText("");
            categoriaComboBox.setSelectedIndex(0);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la aplicación
        SwingUtilities.invokeLater(() -> {
            GestionDeProductos app = new GestionDeProductos();
            app.setVisible(true);
        });
    }
}