package Presentacion;

//Anthony Rodriguez Valverde 23/08/2023 

import Entidades.FacturaCompra;
import Entidades.Provedores;
import Logica.LNFacturaCompra;
import Logica.LNProvedores;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class frmFactura_Compra extends javax.swing.JInternalFrame {

    //Variable global que va a tomar el id generado de la factura
    int id;
    
    public frmFactura_Compra() {
        initComponents();
    }

    //Generar la entidad
    private int GenerarEntidad() throws Exception{
        FacturaCompra factura = new FacturaCompra();
        LNFacturaCompra ln = new LNFacturaCompra();
        
        factura.setId_provedor(Integer.parseInt(txtCodigoProvedor.getText()));
        
        int retorno = ln.Ingresar(factura);
        return retorno;
    }//Fin del generar la entidad
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDetalleCompra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoProvedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreProvedor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCerrarFactura = new javax.swing.JButton();

        btnDetalleCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDetalleCompra.setText("Empezar compra");
        btnDetalleCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleCompraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Id provedor:");

        txtCodigoProvedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCodigoProvedor.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nombre:");

        txtNombreProvedor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreProvedor.setEnabled(false);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Fondo1.png"))); // NOI18N
        jLabel5.setText("Factura de compra");

        btnCerrarFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarFactura.setText("Cerrar Factura");
        btnCerrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDetalleCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProvedor)
                            .addComponent(txtNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnDetalleCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCerrarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscarProvedor cli = new frmBuscarProvedor(null,true);
        
        cli.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                try {
                    int id = cli.ObtenerId();
                    String condicion;
                    LNProvedores logica = new LNProvedores();
                    Provedores funcionario;
                    if(id>-1){
                        condicion = String.format("id_proveedor = %d",id);
                        funcionario = logica.obtenerProvedor(condicion);
                        txtCodigoProvedor.setText(String.valueOf(funcionario.getId()));
                        txtNombreProvedor.setText(funcionario.getNombre());
                    }else{
                        //Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
                }
            }
        
        });
        cli.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    //Boton para cerrar el formulario y la factura
    private void btnCerrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarFacturaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarFacturaActionPerformed

    //Evento para poder realizar la compra
    private void btnDetalleCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleCompraActionPerformed

        if (!txtCodigoProvedor.getText().equals("")) {
            try {
                id = GenerarEntidad();
                JOptionPane.showMessageDialog(this, "Factura en proceso!!!");
            frmDetalle_Factura_Compra frm = new frmDetalle_Factura_Compra(null,true,id);
            this.dispose();
            frm.show();
            } catch (Exception ex) {
                Logger.getLogger(frmFactura_Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un provedor antes de empezar a comprar!!!");
        }
    }//GEN-LAST:event_btnDetalleCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrarFactura;
    private javax.swing.JButton btnDetalleCompra;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCodigoProvedor;
    private javax.swing.JTextField txtNombreProvedor;
    // End of variables declaration//GEN-END:variables
}
