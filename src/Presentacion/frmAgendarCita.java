package Presentacion;

//Anthony Rodriguez Valverde 24/08/2023

import Entidades.Agenda;
import Entidades.Clientes;
import Entidades.Citas;
import Entidades.DetalleFacturaVenta;
import Logica.LNAgenda;
import Logica.LNCitas;
import Logica.LNClientes;
import Logica.LNDetalleFacturaVenta;
import Logica.LNFuncionarios;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAgendarCita extends javax.swing.JDialog {

    //VARIABLE GLOBAL
    DefaultTableModel modelo;
    static int idFactura;

    public frmAgendarCita(java.awt.Frame parent, boolean modal,int id) {
        super(parent, modal);
        initComponents();
        idFactura = id;
        txtIdFactura.setText(String.valueOf(idFactura));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtIdAgenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarAgenda = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscarCliente1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        txtIdCita = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Fondo1.png"))); // NOI18N
        jLabel9.setText("Agendar citas");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Hora:");

        txtHora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtIdAgenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdAgenda.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Id factura:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Id Cliente:");

        txtIdCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdCliente.setEnabled(false);

        txtCosto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Costo de la cita:");

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Descripcion:");

        btnBuscarAgenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarAgenda.setText("Buscar agenda");
        btnBuscarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAgendaActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar cita");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBuscarCliente1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarCliente1.setText("Buscar cliente");
        btnBuscarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCliente1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Id agenda:");

        txtIdFactura.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdFactura.setEnabled(false);

        txtIdCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdCita.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Id cita:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)))
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(361, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDescripcion)
                                .addGap(61, 61, 61))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBuscarAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(txtIdAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Boton para poder recuperar el id de la cita
    private void btnBuscarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAgendaActionPerformed
         frmBuscarAgenda cli;
        try {
            cli = new frmBuscarAgenda(null,true);
            cli.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                try {
                    int id = cli.ObtenerId();
                    String condicion;
                    LNAgenda logica = new LNAgenda();
                    Agenda agenda;
                    if(id>-1){
                        condicion = String.format("id_agenda = %d",id);
                        agenda = logica.Obtener(condicion);
                        txtIdAgenda.setText(String.valueOf(agenda.getId()));
                        //txtNombreFuncionario.setText(agenda.getNombre());
                    }else{
                        //Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
                }
            }
        
        });
        cli.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(frmAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarAgendaActionPerformed

         //Generar la entidad
    private Citas GenerarEntidad(){
        Citas cita = new Citas();
        
        if (!txtIdAgenda.getText().equals("") && !txtDescripcion.getText().equals("") && !txtCosto.getText().equals("") && !txtIdCliente.getText().equals("")) {
            cita.setIdAgenda(Integer.parseInt(txtIdAgenda.getText()));
            cita.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
            
            String hora = txtHora.getText()+":00:00";
            Time horaE = Time.valueOf(hora);
            cita.setHoraCita(horaE);
            
            cita.setPrecioCita(Double.parseDouble(txtCosto.getText()));
            cita.setDescripcion(txtDescripcion.getText());
            
        }
        
        return cita;
    }//Fin del generar la entidad
    
    //Generar la entidad
    private DetalleFacturaVenta GenerarEntidad2(){
        DetalleFacturaVenta cliente = new DetalleFacturaVenta();
        cliente.setId_factura(Integer.parseInt(txtIdFactura.getText()));
        cliente.setId_cita(Integer.parseInt(txtIdCita.getText()));
        return cliente;
    }//Fin del generar la entidad
    
//     public void LimpiarTabla(){
//        modelo = new DefaultTableModel(){
//            @Override
//            public boolean isCellEditable(int row,int colum){
//                return false;
//            }
//        };
//        tblCita.setModel(modelo);
//        modelo.addColumn("Codigo");
//        modelo.addColumn("Codigo agenda");
//        modelo.addColumn("Codigo cliente");
//        modelo.addColumn("Hora cita");
//        modelo.addColumn("Costo");
//        modelo.addColumn("Descripcion");
//    }//Fin limpiar tabla
    
//    //Metodo para poder cargar la lista
//    public void CargarDatos_Rs(String condicion,String orden) throws Exception{
//        try {
//            LNCitas logica = new LNCitas();
//            ResultSet lista;
//            LimpiarTabla();
//            Object[] fila = new Object[6];
//            lista = logica.Listar(condicion, orden);
//            
//            while (lista.next()) {
//                fila[0]=lista.getInt("ID_CITA");
//                fila[1]=lista.getInt("ID_AGENDA");
//                fila[2]=lista.getString("ID_CLIENTE");
//                fila[3]=lista.getDate("HORA_CITA");
//                fila[4]=lista.getTime("COSTO");
//                fila[5]=lista.getTime("DESCRIPCION_CITA");
//                modelo.addRow(fila);
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }//Creamos el metodo para poder cargar la lista
    
    //Boton para poder agregar la cita
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            Citas cita = new Citas();
            DetalleFacturaVenta cita2 = new DetalleFacturaVenta();
            LNCitas ln = new LNCitas();
            LNDetalleFacturaVenta dln = new LNDetalleFacturaVenta();
            
            if (!txtIdAgenda.getText().equals("") && !txtDescripcion.getText().equals("") && !txtCosto.getText().equals(        "") && !txtIdCliente.getText().equals("")) {
                cita = GenerarEntidad();
                int resultado = ln.Ingresar(cita);
                
                if (resultado>0) {
                    int idCita = ln.getId();
                    txtIdCita.setText(String.valueOf(idCita));
                    cita2 = GenerarEntidad2();
                    dln.Ingresar2(cita2);
                    
                    JOptionPane.showMessageDialog(this, ln.getMensaje());
                    //No as recuperado el id de la cita que es lo mas importante!!!
                    //CargarDatos_Rs("","");
                    
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, ln.getMensaje());
                    //CargarDatos_Rs("","");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Faltan datos!!!");
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error:"+e);
            }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCliente1ActionPerformed
         frmBuscarClientes cli;
        try {
            cli = new frmBuscarClientes(null,true);
            cli.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                try {
                    int id = cli.ObtenerId();
                    String condicion;
                    LNClientes logica = new LNClientes();
                    Clientes agenda;
                    if(id>-1){
                        condicion = String.format("id_cliente = %d",id);
                        agenda = logica.obtenerCliente(condicion);
                        txtIdCliente.setText(String.valueOf(agenda.getId()));
                        //txtNombreFuncionario.setText(agenda.getNombre());
                    }else{
                        //Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
                }
            }
        
        });
        cli.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(frmAgendarCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarCliente1ActionPerformed


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
            java.util.logging.Logger.getLogger(frmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAgendarCita dialog = new frmAgendarCita(new javax.swing.JFrame(), true,idFactura);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarAgenda;
    private javax.swing.JButton btnBuscarCliente1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdAgenda;
    private javax.swing.JTextField txtIdCita;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdFactura;
    // End of variables declaration//GEN-END:variables
}
