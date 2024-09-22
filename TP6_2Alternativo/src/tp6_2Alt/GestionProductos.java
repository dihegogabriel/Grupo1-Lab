package tp6_2Alt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.TreeSet;

public class GestionProductos extends JFrame{
    private TreeSet<Producto> productos = new TreeSet<>();
    private JTable tablaProductos, tablaResultadoPrecio, tablaResultadoNombre, tablaResultadoRubro;
    private DefaultTableModel modeloTabla, modeloTablaPrecio, modeloTablaNombre, modeloTablaRubro;
    private JTextField txtCodigo, txtDescripcion, txtPrecio, txtStock, txtMinPrecio, txtMaxPrecio, txtConsultaNombre;
    private JComboBox<String> comboRubro, comboConsultaRubro;
    private JButton btnNuevo, btnGuardar, btnActualizar, btnEliminar;

    public GestionProductos(){
        setTitle("Gestión de Productos - De Todo S.A.");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes(){
        // panel de pestanias
        JTabbedPane tabbedPane = new JTabbedPane();

        // panel de gestion de productos
        JPanel panelGestion = new JPanel(new BorderLayout());
        panelGestion.add(crearFormularioGestion(), BorderLayout.SOUTH);
        panelGestion.add(crearTablaProductos(), BorderLayout.CENTER);
        tabbedPane.add("Gestión de Productos", panelGestion);

        // consultas por precio
        JPanel panelConsultaPrecio = crearConsultaPorPrecio();
        tabbedPane.add("Consulta por Precio", panelConsultaPrecio);

        // consultas por nombre
        JPanel panelConsultaNombre = crearConsultaPorNombre();
        tabbedPane.add("Consulta por Nombre", panelConsultaNombre);

        // consultas por rubro
        JPanel panelConsultaRubro = crearConsultaPorRubro();
        tabbedPane.add("Consulta por Rubro", panelConsultaRubro);

        add(tabbedPane);

        // cargar la lista de productos tabla de gestion
        cargarProductosEnTabla();
    }

    private JPanel crearFormularioGestion(){
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2));

        // agregar o modificar productos
        panelFormulario.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelFormulario.add(txtCodigo);

        panelFormulario.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelFormulario.add(txtDescripcion);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Stock:"));
        txtStock = new JTextField();
        panelFormulario.add(txtStock);

        panelFormulario.add(new JLabel("Rubro:"));
        comboRubro = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Perfumería"});
        panelFormulario.add(comboRubro);

        // buttons
        JPanel panelBotones = new JPanel();
        btnNuevo = new JButton("Nuevo");
        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnNuevo);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);

        panelFormulario.add(panelBotones);

        // events de botones
        btnNuevo.addActionListener(e -> limpiarFormulario());
        btnGuardar.addActionListener(e -> guardarProducto());
        btnActualizar.addActionListener(e -> actualizarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());

        return panelFormulario;
    }

    private JScrollPane crearTablaProductos(){
        modeloTabla = new DefaultTableModel(new String[]{"Código", "Descripción", "Precio", "Rubro", "Stock"}, 0);
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setEnabled(false);

        // evento para seleccionar elementos de la tabla
        tablaProductos.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int filaSeleccionada = tablaProductos.getSelectedRow();
                if(filaSeleccionada >= 0){
                    txtCodigo.setText(modeloTabla.getValueAt(filaSeleccionada, 0).toString());
                    txtDescripcion.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                    txtPrecio.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                    comboRubro.setSelectedItem(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                    txtStock.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                }
            }
        });

        return new JScrollPane(tablaProductos);
    }

    private JPanel crearConsultaPorPrecio() {
        JPanel panelConsulta = new JPanel(new BorderLayout());

        // panel para ingresar el rango de precios
        JPanel panelRango = new JPanel(new GridLayout(2, 2));
        panelRango.add(new JLabel("Precio mínimo:"));
        txtMinPrecio = new JTextField();
        panelRango.add(txtMinPrecio);

        panelRango.add(new JLabel("Precio máximo:"));
        txtMaxPrecio = new JTextField();
        panelRango.add(txtMaxPrecio);

        // boton para realizar la consulta
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(e -> consultarPorPrecio());

        // tabla de resultados
        modeloTablaPrecio = new DefaultTableModel(new String[]{"Código", "Descripción", "Precio", "Rubro", "Stock"}, 0);
        tablaResultadoPrecio = new JTable(modeloTablaPrecio);

        panelConsulta.add(panelRango, BorderLayout.NORTH);
        panelConsulta.add(new JScrollPane(tablaResultadoPrecio), BorderLayout.CENTER);
        panelConsulta.add(btnConsultar, BorderLayout.SOUTH);

        return panelConsulta;
    }

    private JPanel crearConsultaPorNombre(){
        JPanel panelConsulta = new JPanel(new BorderLayout());

        // ingresar el nombre del producto a consultar
        JPanel panelNombre = new JPanel(new GridLayout(1, 2));
        panelNombre.add(new JLabel("Nombre:"));
        txtConsultaNombre = new JTextField();
        panelNombre.add(txtConsultaNombre);

        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(e -> consultarPorNombre());

        // tabla de resultados
        modeloTablaNombre = new DefaultTableModel(new String[]{"Código", "Descripción", "Precio", "Rubro", "Stock"}, 0);
        tablaResultadoNombre = new JTable(modeloTablaNombre);

        panelConsulta.add(panelNombre, BorderLayout.NORTH);
        panelConsulta.add(new JScrollPane(tablaResultadoNombre), BorderLayout.CENTER);
        panelConsulta.add(btnConsultar, BorderLayout.SOUTH);

        return panelConsulta;
    }

    private JPanel crearConsultaPorRubro(){
        JPanel panelConsulta = new JPanel(new BorderLayout());

        // seleccionar el rubro
        JPanel panelRubro = new JPanel(new GridLayout(1, 2));
        panelRubro.add(new JLabel("Rubro:"));
        comboConsultaRubro = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Perfumería"});
        panelRubro.add(comboConsultaRubro);

        // boton para realizar la consulta
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(e -> consultarPorRubro());

        // tabla de resultados
        modeloTablaRubro = new DefaultTableModel(new String[]{"Código", "Descripción", "Precio", "Rubro", "Stock"}, 0);
        tablaResultadoRubro = new JTable(modeloTablaRubro);

        panelConsulta.add(panelRubro, BorderLayout.NORTH);
        panelConsulta.add(new JScrollPane(tablaResultadoRubro), BorderLayout.CENTER);
        panelConsulta.add(btnConsultar, BorderLayout.SOUTH);

        return panelConsulta;
    }

    private void limpiarFormulario(){
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        comboRubro.setSelectedIndex(0);
    }

    private void guardarProducto(){
        try{
            int codigo = Integer.parseInt(txtCodigo.getText());
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String rubro = comboRubro.getSelectedItem().toString();

            Producto nuevoProducto = new Producto(codigo, descripcion, precio, stock, rubro);
            if(productos.add(nuevoProducto)){
                cargarProductosEnTabla();
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(this, "El código ya existe.");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos.");
        }
    }

    private void actualizarProducto(){
        try{
            int codigo = Integer.parseInt(txtCodigo.getText());
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String rubro = comboRubro.getSelectedItem().toString();

            Producto productoExistente = productos.stream()
                    .filter(p -> p.getCodigo() == codigo)
                    .findFirst()
                    .orElse(null);

            if(productoExistente != null){
                productos.remove(productoExistente);
                productos.add(new Producto(codigo, descripcion, precio, stock, rubro));
                cargarProductosEnTabla();
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos.");
        }
    }

    private void eliminarProducto(){
        try{
            int codigo = Integer.parseInt(txtCodigo.getText());

            Producto productoExistente = productos.stream()
                    .filter(p -> p.getCodigo() == codigo)
                    .findFirst()
                    .orElse(null);

            if(productoExistente != null){
                productos.remove(productoExistente);
                cargarProductosEnTabla();
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos.");
        }
    }

    private void cargarProductosEnTabla(){
        modeloTabla.setRowCount(0);
        for(Producto p : productos){
            modeloTabla.addRow(new Object[]{p.getCodigo(), p.getDescripcion(), p.getPrecio(), p.getRubro(), p.getStock()});
        }
    }

    private void consultarPorPrecio(){
        try{
            double minPrecio = Double.parseDouble(txtMinPrecio.getText());
            double maxPrecio = Double.parseDouble(txtMaxPrecio.getText());

            modeloTablaPrecio.setRowCount(0);
            for(Producto p : productos){
                if(p.getPrecio() >= minPrecio && p.getPrecio() <= maxPrecio){
                    modeloTablaPrecio.addRow(new Object[]{p.getCodigo(), p.getDescripcion(), p.getPrecio(), p.getRubro(), p.getStock()});
                }
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Error en el formato de los precios.");
        }
    }

    private void consultarPorNombre(){
        String nombreConsulta = txtConsultaNombre.getText().toLowerCase();
        modeloTablaNombre.setRowCount(0);
        for(Producto p : productos){
            if(p.getDescripcion().toLowerCase().contains(nombreConsulta)){
                modeloTablaNombre.addRow(new Object[]{p.getCodigo(), p.getDescripcion(), p.getPrecio(), p.getRubro(), p.getStock()});
            }
        }
    }

    private void consultarPorRubro(){
        String rubroConsulta = comboConsultaRubro.getSelectedItem().toString();
        modeloTablaRubro.setRowCount(0);
        for(Producto p : productos){
            if(p.getRubro().equalsIgnoreCase(rubroConsulta)){
                modeloTablaRubro.addRow(new Object[]{p.getCodigo(), p.getDescripcion(), p.getPrecio(), p.getRubro(), p.getStock()});
            }
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new GestionProductos().setVisible(true));
    }
}

class Producto implements Comparable<Producto>{
    private int codigo;
    private String descripcion;
    private double precio;
    private int stock;
    private String rubro;

    public Producto(int codigo, String descripcion, double precio, int stock, String rubro){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.rubro = rubro;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public double getPrecio(){
        return precio;
    }

    public int getStock(){
        return stock;
    }

    public String getRubro(){
        return rubro;
    }

    @Override
    public int compareTo(Producto o){
        return Integer.compare(this.codigo, o.codigo);
    }
}