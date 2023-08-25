package Presentacion;

//Anthony Rodriguez Valverde 18/08/2023

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class frmMenu extends javax.swing.JFrame {

     //VARIABLE GLOBAL
    DefaultTableModel modelo;
    
    public frmMenu() {
        initComponents();
        //Maximizamos el tamanio del formulario principal
        this.setExtendedState(frmMenu.MAXIMIZED_BOTH);
        //Titulo
        this.setTitle("MASCOTAS FELICES");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuClientes = new javax.swing.JMenu();
        mnuAdministrarClientes = new javax.swing.JMenuItem();
        mnuAgendarComprar = new javax.swing.JMenuItem();
        mnuProveedores = new javax.swing.JMenu();
        mnuAdministrarProveedores = new javax.swing.JMenuItem();
        mnuVeterinarios = new javax.swing.JMenu();
        mnuAdministrarVeterinariosFuncionarios = new javax.swing.JMenuItem();
        mnuAgenda = new javax.swing.JMenuItem();
        mnuProductos = new javax.swing.JMenu();
        mnuAdministrarProductos = new javax.swing.JMenuItem();
        mnuRealizarCompra = new javax.swing.JMenuItem();
        mnuBitacora = new javax.swing.JMenu();
        mnuBitacora1 = new javax.swing.JMenuItem();
        mnuFacturacion = new javax.swing.JMenu();
        mnuVentas = new javax.swing.JMenuItem();
        mnuCompras = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1387, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );

        mnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Clientes.png"))); // NOI18N
        mnuClientes.setText("Clientes");
        mnuClientes.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuClientes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                mnuClientesComponentResized(evt);
            }
        });

        mnuAdministrarClientes.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuAdministrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/administrar.png"))); // NOI18N
        mnuAdministrarClientes.setText("Administrar informacion");
        mnuAdministrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministrarClientesActionPerformed(evt);
            }
        });
        mnuClientes.add(mnuAdministrarClientes);

        mnuAgendarComprar.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuAgendarComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/agendarCita.png"))); // NOI18N
        mnuAgendarComprar.setText("Agendar cita/Realizar venta");
        mnuAgendarComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgendarComprarActionPerformed(evt);
            }
        });
        mnuClientes.add(mnuAgendarComprar);

        jMenuBar1.add(mnuClientes);

        mnuProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Proveedores.png"))); // NOI18N
        mnuProveedores.setText("Proveedores");
        mnuProveedores.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProveedoresActionPerformed(evt);
            }
        });

        mnuAdministrarProveedores.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuAdministrarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/administrar2.png"))); // NOI18N
        mnuAdministrarProveedores.setText("Administrar informacion");
        mnuAdministrarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministrarProveedoresActionPerformed(evt);
            }
        });
        mnuProveedores.add(mnuAdministrarProveedores);

        jMenuBar1.add(mnuProveedores);

        mnuVeterinarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Veterinario.png"))); // NOI18N
        mnuVeterinarios.setText("Funcionarios y Veterinarios");
        mnuVeterinarios.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuVeterinarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuVeterinariosMouseClicked(evt);
            }
        });
        mnuVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVeterinariosActionPerformed(evt);
            }
        });

        mnuAdministrarVeterinariosFuncionarios.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuAdministrarVeterinariosFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Administrar3.png"))); // NOI18N
        mnuAdministrarVeterinariosFuncionarios.setText("Administrar informacion");
        mnuAdministrarVeterinariosFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministrarVeterinariosFuncionariosActionPerformed(evt);
            }
        });
        mnuVeterinarios.add(mnuAdministrarVeterinariosFuncionarios);

        mnuAgenda.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Agenda.png"))); // NOI18N
        mnuAgenda.setText("Administrar agendas");
        mnuAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAgendaActionPerformed(evt);
            }
        });
        mnuVeterinarios.add(mnuAgenda);

        jMenuBar1.add(mnuVeterinarios);

        mnuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Productos.png"))); // NOI18N
        mnuProductos.setText("Productos");
        mnuProductos.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N

        mnuAdministrarProductos.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuAdministrarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/administrar4.png"))); // NOI18N
        mnuAdministrarProductos.setText("Administrar productos");
        mnuAdministrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministrarProductosActionPerformed(evt);
            }
        });
        mnuProductos.add(mnuAdministrarProductos);

        mnuRealizarCompra.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuRealizarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Compras3.png"))); // NOI18N
        mnuRealizarCompra.setText("Realizar compra");
        mnuRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRealizarCompraActionPerformed(evt);
            }
        });
        mnuProductos.add(mnuRealizarCompra);

        jMenuBar1.add(mnuProductos);

        mnuBitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/citas.png"))); // NOI18N
        mnuBitacora.setText("Bitacora de ventas");
        mnuBitacora.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuBitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuBitacoraMouseClicked(evt);
            }
        });
        mnuBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBitacoraActionPerformed(evt);
            }
        });

        mnuBitacora1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuBitacora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Bitacora.png"))); // NOI18N
        mnuBitacora1.setText("Ver bitacora");
        mnuBitacora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBitacora1ActionPerformed(evt);
            }
        });
        mnuBitacora.add(mnuBitacora1);

        jMenuBar1.add(mnuBitacora);

        mnuFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/facturacion.png"))); // NOI18N
        mnuFacturacion.setText("Facturacion");
        mnuFacturacion.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N

        mnuVentas.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/ventas.png"))); // NOI18N
        mnuVentas.setText("Ventas");
        mnuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentasActionPerformed(evt);
            }
        });
        mnuFacturacion.add(mnuVentas);

        mnuCompras.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/compras.png"))); // NOI18N
        mnuCompras.setText("Compras");
        mnuCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuComprasActionPerformed(evt);
            }
        });
        mnuFacturacion.add(mnuCompras);

        jMenuBar1.add(mnuFacturacion);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cerrar.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuClientesComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mnuClientesComponentResized
        
    }//GEN-LAST:event_mnuClientesComponentResized

    //Redireccionamos al otro formulario, para administrar los clientes
    private void mnuAdministrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministrarClientesActionPerformed
       frmAdministrarClientes frm_cli;
        try {
            frm_cli = new frmAdministrarClientes();
            
             Escritorio.add(frm_cli);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_cli.getSize();
        
        frm_cli.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_cli.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAdministrarClientesActionPerformed
    //Fin del redireccionar al formulario para administrar clientes
    
    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        //Metodo generado por error
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        //Metodo para cerrar el formulario principal
        this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

    //Redireccionamos al otro formulario, para administrar los productos
    private void mnuAdministrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministrarProductosActionPerformed
        frmAdministrarProductos frm_pro;
        try {
            frm_pro = new frmAdministrarProductos();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAdministrarProductosActionPerformed
    //Fin del redireccionar al formulario para administrar productos
    
    private void mnuVeterinariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuVeterinariosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuVeterinariosMouseClicked

    private void mnuVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVeterinariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuVeterinariosActionPerformed

     
    private void mnuProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProveedoresActionPerformed
        //Metodo generado por error
    }//GEN-LAST:event_mnuProveedoresActionPerformed

     //Redireccionamos al otro formulario, para administrar los proveedores
    private void mnuAdministrarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministrarProveedoresActionPerformed
        frmProveedores frm_pro;
        try {
            frm_pro = new frmProveedores();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAdministrarProveedoresActionPerformed

    private void mnuBitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuBitacoraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuBitacoraMouseClicked

    private void mnuBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBitacoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuBitacoraActionPerformed

    private void mnuBitacora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBitacora1ActionPerformed
       //Metodo para ver la bitacora
        frmBitacora frm_pro;
        try {
            frm_pro = new frmBitacora();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuBitacora1ActionPerformed

    private void mnuRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRealizarCompraActionPerformed
        //Metodo para generar la factura de compra
        frmFactura_Compra frm_pro;
        try {
            frm_pro = new frmFactura_Compra();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mnuRealizarCompraActionPerformed

    //Redireccionar al administrar funcionarios y veterinarios 
    private void mnuAdministrarVeterinariosFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministrarVeterinariosFuncionariosActionPerformed
        frmFuncionariosVeterinarios frm_pro;
        try {
            frm_pro = new frmFuncionariosVeterinarios();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAdministrarVeterinariosFuncionariosActionPerformed

    //Redireccionar al administrar agendas
    private void mnuAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgendaActionPerformed
       frmAgendas frm_pro;
        try {
            frm_pro = new frmAgendas();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAgendaActionPerformed

    //Evento para redireccionar al formulario de venta
    private void mnuAgendarComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAgendarComprarActionPerformed
        frmFacturaVenta frm_pro;
        try {
            frm_pro = new frmFacturaVenta();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuAgendarComprarActionPerformed

    private void mnuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentasActionPerformed
       frmVerVentas frm_pro;
        try {
            frm_pro = new frmVerVentas();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuVentasActionPerformed

    private void mnuComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuComprasActionPerformed
         frmVerCompras frm_pro;
        try {
            frm_pro = new frmVerCompras();
            
             Escritorio.add(frm_pro);
        Dimension size = Escritorio.getSize();
        
        Dimension sizeInter = frm_pro.getSize();
        
        frm_pro.setLocation(((int)size.getWidth()-(int)sizeInter.getWidth())/2,
                ((int)size.getHeight() - (int)sizeInter.getHeight())/2);
        
        frm_pro.show();
        
        } catch (Exception ex) {
            Logger.getLogger(frmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuComprasActionPerformed
  
    
    
    //Metodo main
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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAdministrarClientes;
    private javax.swing.JMenuItem mnuAdministrarProductos;
    private javax.swing.JMenuItem mnuAdministrarProveedores;
    private javax.swing.JMenuItem mnuAdministrarVeterinariosFuncionarios;
    private javax.swing.JMenuItem mnuAgenda;
    private javax.swing.JMenuItem mnuAgendarComprar;
    private javax.swing.JMenu mnuBitacora;
    private javax.swing.JMenuItem mnuBitacora1;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenuItem mnuCompras;
    private javax.swing.JMenu mnuFacturacion;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuProveedores;
    private javax.swing.JMenuItem mnuRealizarCompra;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JMenuItem mnuVentas;
    private javax.swing.JMenu mnuVeterinarios;
    // End of variables declaration//GEN-END:variables
}
