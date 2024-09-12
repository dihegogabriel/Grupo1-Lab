package tp_6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GestionProductos extends JFrame{
    
    private JComboBox<String> comboCategoria;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnAgregar;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;
    
    public GestionProductos(){
        setTitle("Gestion de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(null);
        
        //Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        add(panelPrincipal);
        
        //Panel superior
        JPanel panelInputs = new JPanel();
        panelInputs.setLayout(new GridLayout(3, 2, 10, 10));
        
        //Iniciar componentes de inputs
        comboCategoria = new JComboBox<>(new String[]{"Comestible", "Limpieza", "Farmacia", "Ropa", "Perfumería"});
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        btnAgregar = new JButton("Agregar");
        
        panelInputs.add(new JLabel("Categoria:"));
        panelInputs.add(comboCategoria);
        panelInputs.add(new JLabel("Nombre:"));
        panelInputs.add(txtNombre);
        panelInputs.add(new JLabel("Precio ($):"));
        
        panelPrincipal.add(panelInputs, BorderLayout.NORTH);
        
        //Configurar tabla y modelo de tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Categoria");
        modeloTabla.addColumn("Precio");
        
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);
        
        //panel inferior para btn
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnAgregar);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        
        //Accion btn agregar
        btnAgregar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            agregarProducto();
        }
        });
    }
    
    public void agregarProducto(){
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String categoria = comboCategoria.getSelectedItem().toString();
        
        if(nombre.isEmpty() || precioStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{double precio = Double.parseDouble(precioStr);
        modeloTabla.addRow(new Object[]{nombre, categoria, precio});
        txtNombre.setText("");
        txtPrecio.setText("");
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "El precio tiene que ser un numero valido" , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}