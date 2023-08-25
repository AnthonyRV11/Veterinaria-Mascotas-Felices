package Presentacion;

//Anthony Rodriguez Valverde 22/08/2023

import Entidades.Agenda;
import Entidades.Funcionarios;
import Logica.LNAgenda;
import Logica.LNFuncionarios;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAgendas extends javax.swing.JInternalFrame {

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
        tblAgendas.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Codigo funcionario");
        modelo.addColumn("Nombre funcionario");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora entrada");
        modelo.addColumn("Hora salida");
    }//Fin limpiar tabla

    //Metodo para iniciar el formulario
    public frmAgendas() {
        initComponents();
         try {
            CargarDatos_Rs("", "");
        } catch (Exception ex) {
            Logger.getLogger(frmBuscarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Limpiar(){
        txtIdAgenda2.setText("");
        txtIdFuncionaro.setText("");
        txtNombreFuncionario.setText("");
        //dtFecha.setDate();
        txtHoraEntrada.setText("");
        txtHoraSalida.setText("");
    }//Metodo para limpiar

      //Generar la entidad
    private Agenda GenerarEntidad(){
        Agenda agenda = new Agenda();
        if (!txtIdAgenda2.getText().equals("")) {
            agenda.setExiste(true);
            agenda.setId(Integer.parseInt(txtIdAgenda2.getText()));
        }
        agenda.setId_Funcionario(Integer.parseInt(txtIdFuncionaro.getText()));
        
        java.util.Date utilDate = dtFecha.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        agenda.setFecha(sqlDate);

        if (!txtIdAgenda2.getText().equals("")) {
            String horaEntrada = txtHoraEntrada.getText();
            Time horaEntradaTime = Time.valueOf(horaEntrada);
            agenda.setHora_Entrada(horaEntradaTime);

            String horaSalida = txtHoraSalida.getText();
            Time horaSalidaTime = Time.valueOf(horaSalida);
            agenda.setHora_Salida(horaSalidaTime);
        }else{
            String horaEntrada = txtHoraEntrada.getText()+":00:00";
            Time horaEntradaTime = Time.valueOf(horaEntrada);
            agenda.setHora_Entrada(horaEntradaTime);

            String horaSalida = txtHoraSalida.getText()+":00:00";
            Time horaSalidaTime = Time.valueOf(horaSalida);
            agenda.setHora_Salida(horaSalidaTime);
        }
        

        
        return agenda;
    }//Fin del generar la entidad
    
    
    //Metodo para poder cargar la lista
    public void CargarDatos_Rs(String condicion,String orden) throws Exception{
        try {
            LNAgenda logica = new LNAgenda();
            ResultSet lista;
            LimpiarTabla();
            Object[] fila = new Object[6];
            lista = logica.Listar(condicion, orden);
            
            while (lista.next()) {
                fila[0]=lista.getInt("id_agenda");
                fila[1]=lista.getInt("id_funcionario");
                fila[2]=lista.getString("nombre");
                fila[3]=lista.getDate("fecha");
                fila[4]=lista.getTime("hora_entrada");
                fila[5]=lista.getTime("hora_salida");
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            throw e;
        }
    }//Creamos el metodo para poder cargar la lista

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        dtFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtNombreFuncionario = new javax.swing.JTextField();
        txtIdFuncionaro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdAgenda2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarFuncionario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendas = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtHoraSalida = new javax.swing.JTextField();
        txtHoraEntrada = new javax.swing.JTextField();

        jLabel9.setFont(new java.awt.Font("Poor Richard", 0, 48)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Fondo1.png"))); // NOI18N
        jLabel9.setText("Administrar agendas");

        dtFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre funcionario/veterinario:");

        txtNombreFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreFuncionario.setEnabled(false);

        txtIdFuncionaro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdFuncionaro.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Id agenda:");

        txtIdAgenda2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdAgenda2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Id funcionario:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Hora salida:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Hora entrada:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Fecha:");

        btnBuscarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarFuncionario.setText("Buscar funcionario");
        btnBuscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFuncionarioActionPerformed(evt);
            }
        });

        tblAgendas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblAgendas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAgendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAgendas);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtHoraSalida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtHoraEntrada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(224, 224, 224))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtIdAgenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtIdFuncionaro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(31, 31, 31)
                                                    .addComponent(btnBuscarFuncionario)))
                                            .addGap(23, 23, 23)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNombreFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(84, 84, 84)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(72, 72, 72)))
                                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel9)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdAgenda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdFuncionaro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para cerrar el formulario
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    //Formulario para poder traer los datos del funcionario
    private void btnBuscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFuncionarioActionPerformed
        frmBuscarFuncionario cli = new frmBuscarFuncionario(null,true);
        
        cli.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e){
                try {
                    int id = cli.ObtenerId();
                    String condicion;
                    LNFuncionarios logica = new LNFuncionarios();
                    Funcionarios funcionario;
                    if(id>-1){
                        condicion = String.format("id_funcionario = %d",id);
                        funcionario = logica.Obtener(condicion);
                        txtIdFuncionaro.setText(String.valueOf(funcionario.getId()));
                        txtNombreFuncionario.setText(funcionario.getNombre());
                    }else{
                        //Limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
                }
            }
        
        });
        cli.setVisible(true);
    }//GEN-LAST:event_btnBuscarFuncionarioActionPerformed

    //Evento para poder recuperar una agenda de la tabla
    private void tblAgendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendasMouseClicked
        //Llamar al obtener 
        try {
            LNAgenda logica = new LNAgenda();
            Agenda agenda;
            String condicion;
            if(evt.getClickCount() == 2){
                int fila = tblAgendas.rowAtPoint(evt.getPoint());
                txtIdAgenda2.setText(tblAgendas.getValueAt(fila, 0).toString());
                condicion = String.format("ID_AGENDA=%s", txtIdAgenda2.getText());
                agenda = logica.Obtener(condicion);
                
                txtIdAgenda2.setText(String.valueOf(agenda.getId()));
                txtIdFuncionaro.setText(String.valueOf(agenda.getId_Funcionario()));
                dtFecha.setDate(new java.util.Date(agenda.getFecha().getTime()));
                txtHoraSalida.setText(agenda.getHora_Salida().toString());
                txtHoraEntrada.setText(agenda.getHora_Entrada().toString());

            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_tblAgendasMouseClicked

    //Metodo para poder crear la agenda
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        LNAgenda logica = new LNAgenda();
        Agenda agenda;
        try{
            if (txtIdAgenda2.getText().equals("")) {
                
                if (!txtIdFuncionaro.getText().equals("")
                    && !txtHoraEntrada.getText().equals("") 
                    && !txtHoraSalida.getText().equals("") && !dtFecha.getDate().equals("")
                    ) {
                    agenda = GenerarEntidad();
                    logica.Ingresar(agenda);
                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    Limpiar();
                    CargarDatos_Rs("", "");
                }else{
                    JOptionPane.showMessageDialog(this, "Faltan datos!!!");
                }
            }else{
                JOptionPane.showMessageDialog(this, "En este apartado solo se pueden ingresar agendas, limpia para poder crear otra!!!");
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    //Metodo para eliminar
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNAgenda logica = new LNAgenda();
        Agenda agenda;
        try{
            agenda = GenerarEntidad();
            if (!txtIdAgenda2.getText().equals("")) {
                if (logica.Eliminar_SP(agenda)>0) {
                  JOptionPane.showMessageDialog(this, logica.getMensaje());
                  Limpiar();
                  CargarDatos_Rs("", "");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debes seleccionar un producto en la tabla!");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, logica.getMensaje());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Metodo para limpiar
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();        
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFuncionario;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgendas;
    private javax.swing.JTextField txtHoraEntrada;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtIdAgenda2;
    private javax.swing.JTextField txtIdFuncionaro;
    private javax.swing.JTextField txtNombreFuncionario;
    // End of variables declaration//GEN-END:variables
}
