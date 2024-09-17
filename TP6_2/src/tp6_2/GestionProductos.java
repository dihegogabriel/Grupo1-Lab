package tp6_2;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

public class GestionProductos extends JFrame{
    private JDesktopPane desktopPane;
    private TreeSet<Producto> productos;

    public GestionProductos(){
        setTitle("Gestión de Productos - DeTodo S.A.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);

        desktopPane = new JDesktopPane();
        add(desktopPane);

        productos = new TreeSet<>();

        // crear menu
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuAdmin = new JMenu("Administracion");
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

    // ventana gestion de productos
    private void mostrarGestionProductos(){
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
        panel.add(new JLabel()); // vacío
        panel.add(btnGuardar);
        
        gestionFrame.add(panel);
        desktopPane.add(gestionFrame);

        btnGuardar.addActionListener(e -> {
            try{
                int codigo = Integer.parseInt(txtCodigo.getText());
                String descripcion = txtDescripcion.getText();
                double precio = (double) spnPrecio.getValue();
                int stock = (int) spnStock.getValue();
                String rubro = (String) cmbRubro.getSelectedItem();

                if(descripcion.isEmpty()){
                    JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDescripcion.requestFocus();
                    return;
                }
                Producto producto = new Producto(codigo, descripcion, precio, stock, rubro);
                productos.add(producto);

                JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Error en los datos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void mostrarConsultaPorNombre(){
    String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre o parte del nombre del producto:");
    if(nombre != null && !nombre.trim().isEmpty()){
        String[][] datosFiltrados = productos.stream()
            .filter(p -> p.getDescripcion().toLowerCase().contains(nombre.toLowerCase()))
            .map(p -> new String[]{String.valueOf(p.getCodigo()), p.getDescripcion(), String.valueOf(p.getPrecio()), String.valueOf(p.getStock()), p.getRubro()})
            .toArray(String[][]::new);

        if(datosFiltrados.length > 0){
            mostrarResultadosConsulta(datosFiltrados, "Consulta por Nombre");
        }else{
            JOptionPane.showMessageDialog(this, "No se encontraron productos con ese nombre.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }else{
        JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para realizar la consulta.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void mostrarConsultaPorPrecio(){
    try{
        String minStr = JOptionPane.showInputDialog(this, "Ingrese el precio mínimo:");
        String maxStr = JOptionPane.showInputDialog(this, "Ingrese el precio máximo:");
        
        if(minStr != null && maxStr != null && !minStr.trim().isEmpty() && !maxStr.trim().isEmpty()){
            double minPrecio = Double.parseDouble(minStr);
            double maxPrecio = Double.parseDouble(maxStr);

            String[][] datosFiltrados = productos.stream()
                .filter(p -> p.getPrecio() >= minPrecio && p.getPrecio() <= maxPrecio)
                .map(p -> new String[]{String.valueOf(p.getCodigo()), p.getDescripcion(), String.valueOf(p.getPrecio()), String.valueOf(p.getStock()), p.getRubro()})
                .toArray(String[][]::new);

            if(datosFiltrados.length > 0){
                mostrarResultadosConsulta(datosFiltrados, "Consulta por Precio");
            }else{
                JOptionPane.showMessageDialog(this, "No se encontraron productos en ese rango de precios.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para los precios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(this, "Error en el formato de los precios.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void mostrarConsultaPorRubro(){
    String[] rubros = {"Comestible", "Limpieza", "Perfumería"};
    String rubro = (String) JOptionPane.showInputDialog(this, "Seleccione un rubro:", "Consulta por Rubro",
            JOptionPane.QUESTION_MESSAGE, null, rubros, rubros[0]);

    if(rubro != null){
        String[][] datosFiltrados = productos.stream()
            .filter(p -> p.getRubro().equals(rubro))
            .map(p -> new String[]{String.valueOf(p.getCodigo()), p.getDescripcion(), String.valueOf(p.getPrecio()), String.valueOf(p.getStock()), p.getRubro()})
            .toArray(String[][]::new);
        if(datosFiltrados.length > 0){
            mostrarResultadosConsulta(datosFiltrados, "Consulta por Rubro");
        }else{
            JOptionPane.showMessageDialog(this, "No se encontraron productos en el rubro seleccionado.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
    
    private void mostrarResultadosConsulta(String[][] datos, String titulo){
    String[] columnas = {"Código", "Descripción", "Precio", "Stock", "Rubro"};
    
    JTable tabla = new JTable(datos, columnas);
    JScrollPane scrollPane = new JScrollPane(tabla);
    
    JInternalFrame resultadosFrame = new JInternalFrame(titulo, true, true, true, true);
    resultadosFrame.setSize(500, 300);
    resultadosFrame.add(scrollPane);
    resultadosFrame.setVisible(true);
    
    desktopPane.add(resultadosFrame);
}

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            GestionProductos frame = new GestionProductos();
            frame.setVisible(true);
        });
    }
}