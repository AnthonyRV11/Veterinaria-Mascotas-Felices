package Presentacion;

import Logica.LNBitacora;
import Logica.LNFacturaVenta;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class frmVerVentas extends javax.swing.JInternalFrame {

    //VARIABLE GLOBAL
    DefaultTableModel modelo;
    
    //Preparar la tabla y que no se modifique
    public void LimpiarTabla(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int colum){
                return false;
            }
        };
        tblVentas.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Codigo cliente");
        modelo.addColumn("Fecha");
        modelo.addColumn("Descripcion");
    }//Fin limpiar tabla
    
     //Metodo para poder cargar la lista
    public void CargarDatos_Rs(String condicion,String orden) throws Exception{
        try {
            LNFacturaVenta logica = new LNFacturaVenta();
            ResultSet lista;
            LimpiarTabla();
            Object[] fila = new Object[4];
            lista = logica.Listar(condicion, orden);
            
            while (lista.next()) {
                fila[0]=lista.getInt("ID_FACTURA");
                fila[1]=lista.getString("ID_CLIENTE");
                fila[2]=lista.getString("TOTAL_PAGO");
                fila[3]=lista.getString("FECHA_VENTA");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw e;
        }
    }//Creamos el metodo para poder cargar la lista

    
    public frmVerVentas() throws Exception {
        initComponents();
        CargarDatos_Rs("", "");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();

        jLabel9.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Fondo1.png"))); // NOI18N
        jLabel9.setText("Ver ventas");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblVentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
