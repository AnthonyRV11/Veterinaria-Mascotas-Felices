package Presentacion;

//Anthony Rodriguez Valverde 24/08/2023

import Entidades.DetalleFacturaCompra;
import Entidades.DetalleFacturaVenta;
import Entidades.Productos;
import Logica.LNDetalleFacturaCompra;
import Logica.LNDetalleFacturaVenta;
import Logica.LNProductos;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmDetalle_Factura_Venta extends javax.swing.JDialog {

     //Variable global
    static int idFactura;
    DefaultTableModel modelo;
    
    public frmDetalle_Factura_Venta(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        idFactura = id;
        txtCodigoFactura.setText(String.valueOf(idFactura));
        //CargarDatos_Rs("", "");
        LimpiarTabla();
    }
    
    //Preparar la tabla y que no se modifique
    public void LimpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int colum){
                return false;
            }
        };
        tblDesglose.setModel(modelo);
        modelo.addColumn("Id detalle");
        modelo.addColumn("Id factura");
        modelo.addColumn("Id producto");
        modelo.addColumn("Id cita");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
    }//Fin limpiar tabla

    //Metodo para limpiar
    private void Limpiar(){
        txtCantidad.setText("");
        txtCodigoDetalle.setText("");
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
    }
    
    //Metodo para poder cargar la lista
    public void CargarDatos_Rs(String condicion,String orden) throws Exception{
        try {
            LNDetalleFacturaVenta logica = new LNDetalleFacturaVenta();
            ResultSet lista;
            LimpiarTabla();
            Object[] fila = new Object[7];
            lista = logica.Listar(condicion, orden);
            
            while (lista.next()) {
                fila[0]=lista.getInt("ID_DETALLE_FACTURA_VENTA");
                fila[1]=lista.getString("ID_FACTURA");
                fila[2]=lista.getString("ID_PRODUCTO");
                fila[3]=lista.getString("CANTIDAD_PRODUCTO");
                fila[4]=lista.getString("FECHA_VENTA");
                 fila[5]=lista.getString("ID_CITA");
                fila[6]=lista.getString("HORA");
               
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw e;
        }
    }//Creamos el metodo para poder cargar la list con los clientes
    
    //Generar la entidad
    private DetalleFacturaVenta GenerarEntidad(){
        DetalleFacturaVenta cliente = new DetalleFacturaVenta();
        if (!txtCodigoDetalle.getText().equals("")) {
            cliente.setId_Detalle(Integer.parseInt(txtCodigoDetalle.getText()));
        }
        cliente.setCantidad(Integer.parseInt(txtCantidad.getText()));
        cliente.setId_factura(Integer.parseInt(txtCodigoFactura.getText()));
        cliente.setId_producto(Integer.parseInt(txtCodigoProducto.getText()));
        return cliente;
    }//Fin del generar la entidad
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoFactura = new javax.swing.JTextField();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoDetalle = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDesglose = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Fondo1.png"))); // NOI18N
        jLabel5.setText("Detalle de venta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Id factura:");

        txtCodigoFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigoFactura.setEnabled(false);

        txtCodigoProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigoProducto.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Nombre producto:");

        txtNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreProducto.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar producto");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Id detalle:");

        txtCodigoDetalle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigoDetalle.setEnabled(false);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setText("Finalizar compra");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar de la factura");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar a la factura");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Id producto:");

        btnAgendar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgendar.setText("Agendar cita");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        tblDesglose.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblDesglose.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDesglose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDesgloseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDesglose);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtCodigoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(96, 96, 96)
                                .addComponent(btnEliminar)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSalir))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            frmBuscarProductos cli = new frmBuscarProductos(null,true);

            cli.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e){
                    try {
                        int id = cli.ObtenerId();
                        String condicion;
                        LNProductos logica = new LNProductos();
                        Productos producto;
                        if(id>-1){
                            condicion = String.format("id_producto = %d",id);
                            producto = logica.Obtener(condicion);
                            txtCodigoProducto.setText(String.valueOf(producto.getId()));
                            txtNombreProducto.setText(producto.getNombre());
                        }else{
                            //Limpiar();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Debes seleccionar un producto en la tabla!!!");
                    }
                }

            });
            cli.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un producto en la tabla!!!");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        if (!txtCodigoDetalle.getText().equals("")) {
//            int id = Integer.parseInt(txtCodigoDetalle.getText());
//            LNDetalleFacturaCompra ln = new LNDetalleFacturaCompra();
//            DetalleFacturaCompra deta = new DetalleFacturaCompra();
//            deta.setId_Detalle(id);
//            try {
//                ln.Eliminar(deta);
//                String condicion = String.format("ID_FACTURA=%s", txtCodigoFactura.getText());
//                CargarDatos_Rs(condicion, "");
//                Limpiar();
//            } catch (Exception ex) {
//                Logger.getLogger(frmDetalle_Factura_Compra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            JOptionPane.showMessageDialog(this, "Para eliminar toca el detalle en la tabla!");
//        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        LNDetalleFacturaVenta logica = new LNDetalleFacturaVenta();
        DetalleFacturaVenta factura;
        try{
            if (!txtCantidad.getText().equals("") && !txtCodigoFactura.getText().equals("") && !txtCodigoProducto.getText().equals("")) {
                factura = GenerarEntidad();
                String condicion = String.format("ID_FACTURA = %s",factura.getId_factura());
                logica.Ingresar(factura);
                CargarDatos_Rs(condicion,"");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(this, "Faltan datos para agregar el detalle!!!");
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    //Evento para ir agendar una cita
    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        frmAgendarCita cli = new frmAgendarCita(null,true,idFactura);
        cli.show();
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void tblDesgloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDesgloseMouseClicked
//        //Llamar al obtener
//        try {
//            LNDetalleFacturaCompra logica = new LNDetalleFacturaCompra();
//            DetalleFacturaCompra producto;
//            String condicion;
//            if(evt.getClickCount() == 2){
//                int fila = tblDesglose.rowAtPoint(evt.getPoint());
//                txtCodigoDetalle.setText(tblDesglose.getValueAt(fila, 0).toString());
//                condicion = String.format("ID_DETALLE_FACTURA_COMPRA=%s", txtCodigoDetalle.getText());
//                producto = logica.Obtener(condicion);
//
//                txtCodigoDetalle.setText(String.valueOf(producto.getId_Detalle()));
//                txtCodigoProducto.setText(String.valueOf(producto.getId_producto()));
//                txtCantidad.setText(String.valueOf(producto.getCantidad()));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e);
//        }
    }//GEN-LAST:event_tblDesgloseMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDetalle_Factura_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDetalle_Factura_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDetalle_Factura_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDetalle_Factura_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmDetalle_Factura_Venta dialog = new frmDetalle_Factura_Venta(new javax.swing.JFrame(), true,idFactura);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDesglose;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoDetalle;
    private javax.swing.JTextField txtCodigoFactura;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
