package tp6_2;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

public class GestionProductos extends JFrame {
    private JDesktopPane desktopPane;
    private TreeSet<Producto> productos;

    public GestionProductos() {
        setTitle("Gestión de Productos - DeTodo S.A.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);

        desktopPane = new JDesktopPane();
        add(desktopPane);

        productos = new TreeSet<>();

        // Crear menu
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuAdmin = new JMenu("Administración");
        JMenuItem menuItemGestion = new JMenuItem("Gestionar Productos");
        menuAdmin.add(menuItemGestion);
        menuBar.add(menuAdmin);
        
        JMenu menuConsulta = new JMenu("Consultas");
        JMenuItem menuItemNombre = new JMenuItem("Consultar por Nombre");
        JMenuItem menuItemPrecio = new JMenuItem("Consultar por Precio");
        JMenuItem menuItemRubro = new JMenuItem("Consultar por Rubro");
        
        menuConsulta.add(menuItemNombre);
        menuConsulta.add(menuItemPrecio);
        menuConsulta.add(menuItemRubro);
        menuBar.add(menuConsulta);
        
        setJMenuBar(menuBar);

        // menuEvents
        menuItemGestion.addActionListener(e -> mostrarGestionProductos());
        menuItemNombre.addActionListener(e -> mostrarConsultaPorNombre());
        menuItemPrecio.addActionListener(e -> mostrarConsultaPorPrecio());
        menuItemRubro.addActionListener(e -> mostrarConsultaPorRubro());
    }

    // Ventana gestion de productos
    private void mostrarGestionProductos() {
        JInternalFrame gestionFrame = new JInternalFrame("Gestión de Productos", true, true, true, true);
        gestionFrame.setSize(400, 400);
        gestionFrame.setVisible(true);
        
        JPanel panel = new JPanel(new GridLayout(6, 2));
        
        JLabel lblCodigo = new JLabel("Código:");
        JTextField txtCodigo = new JTextField();
        JLabel lblDescripcion = new JLabel("Descripción:");
        JTextField txtDescripcion = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        JSpinner spnPrecio = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
        JLabel lblStock = new JLabel("Stock:");
        JSpinner spnStock = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        JLabel lblRubro = new JLabel("Rubro:");
        JComboBox<String> cmbRubro = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Perfumería"});

        JButton btnGuardar = new JButton("Guardar Producto");

        panel.add(lblCodigo);
        panel.add(txtCodigo);
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblPrecio);
        panel.add(spnPrecio);
        panel.add(lblStock);
        panel.add(spnStock);
        panel.add(lblRubro);
        panel.add(cmbRubro);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(btnGuardar);
        
        gestionFrame.add(panel);
        desktopPane.add(gestionFrame);

        btnGuardar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                String descripcion = txtDescripcion.getText();
                double precio = (double) spnPrecio.getValue();
                int stock = (int) spnStock.getValue();
                String rubro = (String) cmbRubro.getSelectedItem();

                if (descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDescripcion.requestFocus();
                    return;
                }

                Producto producto = new Producto(codigo, descripcion, precio, stock, rubro);
                productos.add(producto);

                JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void mostrarConsultaPorNombre() {
        // codigo para consultar por nombre
    }

    private void mostrarConsultaPorPrecio() {
        // codigo para consultar por precio
    }

    private void mostrarConsultaPorRubro() {
        // codigo para consultar por rubro
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionProductos frame = new GestionProductos();
            frame.setVisible(true);
        });
    }
}