/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package grp1tp6;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class ListadoPrecio extends javax.swing.JInternalFrame {
private DefaultTableModel modelo= new DefaultTableModel(){
    public boolean isCellEditable(int f, int c){
        return false;
    }
};
    /**
     * Creates new form ListadoPrecio
     */
    public ListadoPrecio() {
        initComponents();
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtDesde = new javax.swing.JTextField();
        jtHasta = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(450, 420));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado por Precio");

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtProductos.setEnabled(false);
        jScrollPane1.setViewportView(jtProductos);

        jLabel2.setText("Entre $");

        jLabel3.setText("Y");

        jtDesde.setToolTipText("");
        jtDesde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtDesdeFocusLost(evt);
            }
        });

        jtHasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtHastaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtDesdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtDesdeFocusLost
        // TODO add your handling code here:
        if(jtDesde.getText().isEmpty()){  
            borrarFilas();
            JOptionPane.showMessageDialog(this,"Indique un valor de precio limite inicial");            
            return;
        }else if(jtHasta.getText().isEmpty()){
            return;
            }else{
                    buscarProducto();
        }
    }//GEN-LAST:event_jtDesdeFocusLost

    private void jtHastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtHastaFocusLost
        // TODO add your handling code here:
        if(jtDesde.getText().isEmpty()){              
            borrarFilas();
            JOptionPane.showMessageDialog(this,"Indique un valor de precio limite inicial");           
            return;
        }else if(jtHasta.getText().isEmpty()){
            borrarFilas();
            JOptionPane.showMessageDialog(this,"Indique un valor de precio limite final");
            
            }else{
                    buscarProducto();
        }        
    }//GEN-LAST:event_jtHastaFocusLost
    private void armarCabecera(){     
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Categoria");
        modelo.addColumn("Stock");
        jtProductos.setModel(modelo);       
    }
    
    private void borrarFilas(){
        int filas=jtProductos.getRowCount()-1;
        for(int f=filas;f>=0;f--){
            modelo.removeRow(f);
        }
    }
    
    private void buscarProducto(){
        borrarFilas();
        int desde = Integer.parseInt(jtDesde.getText());
        int hasta = Integer.parseInt(jtHasta.getText());
        for (Producto prod : DeTodoSA.listaProductos) {
            if(prod.getPrecio()>=desde && prod.getPrecio()<=hasta){
                modelo.addRow(new Object[]{
                    prod.getCodigo(), 
                    prod.getDescripcion(),                    
                    prod.getPrecio(),
                    prod.getRubro(),
                    prod.getStock(),
                }); 
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtDesde;
    private javax.swing.JTextField jtHasta;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables
}
