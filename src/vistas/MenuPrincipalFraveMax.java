
package vistas;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MenuPrincipalFraveMax extends javax.swing.JFrame {

    
    // PARA PODER CREAR UN OPCION DE ELEGIR SI DESEA SALIR O NO CUANDO PRESIONA -SALIR o X-
    public void Cerrar(int tipo) {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea cerrar la Aplicación?", "Titulo",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            // SE USA PARA CERRAR TOTO EL PROGRAMA
            // System.exit(0);
            // SE USA PARA CERRAR LA VENTANA ACTUAL PERO NO CERRAR EL PROGRAMA
            if (tipo == 0) {
                this.dispose();
            } else {
                System.exit(0);
            }

        } else {
            if (eleccion == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Cierre cancelado...");
            }
        }
    }



    public MenuPrincipalFraveMax() {
        initComponents();
        this.setLocationRelativeTo(null);
        editarObloquearMenues(false, false, false, true);
        this.setTitle("FRAVEMAX - GRUPO 33");
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/Grupo332023.png"));
        setIconImage(iconoPropio);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuItem4 = new javax.swing.JMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/fondoFraveMax.jpg"));
        Image image = icon.getImage();
        jdpEscritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jmGestionABMC = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiProductos = new javax.swing.JMenuItem();
        jmVentas = new javax.swing.JMenu();
        jmiGestionVentas = new javax.swing.JMenuItem();
        jmListados = new javax.swing.JMenu();
        jmiListado1 = new javax.swing.JMenuItem();
        jmiListado2 = new javax.swing.JMenuItem();
        jmiListado3 = new javax.swing.JMenuItem();
        jmiListado4 = new javax.swing.JMenuItem();
        jmLoginsalir = new javax.swing.JMenu();
        jmiLogin = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpEscritorioLayout = new javax.swing.GroupLayout(jdpEscritorio);
        jdpEscritorio.setLayout(jdpEscritorioLayout);
        jdpEscritorioLayout.setHorizontalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1321, Short.MAX_VALUE)
        );
        jdpEscritorioLayout.setVerticalGroup(
            jdpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
        );

        jmGestionABMC.setText("GESTIÓN_ABMC");
        jmGestionABMC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmGestionABMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionABMCActionPerformed(evt);
            }
        });

        jmiClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiClientes.setText("Clientes");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        jmGestionABMC.add(jmiClientes);

        jmiProductos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiProductos.setText("Productos");
        jmiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductosActionPerformed(evt);
            }
        });
        jmGestionABMC.add(jmiProductos);

        jMenuBar1.add(jmGestionABMC);

        jmVentas.setText("VENTAS");
        jmVentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jmiGestionVentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiGestionVentas.setText("Gestión de Ventas");
        jmiGestionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGestionVentasActionPerformed(evt);
            }
        });
        jmVentas.add(jmiGestionVentas);

        jMenuBar1.add(jmVentas);

        jmListados.setText("LISTADOS");
        jmListados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jmiListado1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiListado1.setText("Productos de una venta x fecha");
        jmiListado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListado1ActionPerformed(evt);
            }
        });
        jmListados.add(jmiListado1);

        jmiListado2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiListado2.setText("Ventas x fecha");
        jmListados.add(jmiListado2);

        jmiListado3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiListado3.setText("Ventas x cliente");
        jmListados.add(jmiListado3);

        jmiListado4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiListado4.setText("Clientes x productos");
        jmListados.add(jmiListado4);

        jMenuBar1.add(jmListados);

        jmLoginsalir.setText("LOGIN/SALIR");
        jmLoginsalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jmiLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiLogin.setText("Login");
        jmiLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLoginActionPerformed(evt);
            }
        });
        jmLoginsalir.add(jmiLogin);

        jmiSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmLoginsalir.add(jmiSalir);

        jMenuBar1.add(jmLoginsalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdpEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiGestionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGestionVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiGestionVentasActionPerformed

    private void jmiListado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiListado1ActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        Cerrar(1);
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLoginActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFLogin jiflogin = new JIFLogin();
        jdpEscritorio.add(jiflogin);
        jiflogin.setVisible(true);
        //jdpEscritorio.moveToFront(jiflogin);
        

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jiflogin.getSize();
        jiflogin.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        
//        jiflogin.requestFocus();
//        jdpEscritorio.revalidate();
    }//GEN-LAST:event_jmiLoginActionPerformed

    private void jmGestionABMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionABMCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmGestionABMCActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFCliente jifcliente = new JIFCliente();
        jdpEscritorio.add(jifcliente);
        jifcliente.setVisible(true);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifcliente.getSize();
        jifcliente.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductosActionPerformed
        jdpEscritorio.removeAll();
        jdpEscritorio.repaint();
        JIFProducto jifproducto = new JIFProducto();
        jdpEscritorio.add(jifproducto);
        jifproducto.setVisible(true);

        // Lineas para centrar el jInternalFrame dentro del desktopPane
        Dimension desktopSize = jdpEscritorio.getSize();
        Dimension jInternalFrameSize = jifproducto.getSize();
        jifproducto.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }//GEN-LAST:event_jmiProductosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalFraveMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFraveMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFraveMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFraveMax.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalFraveMax().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JDesktopPane jdpEscritorio;
    private javax.swing.JMenu jmGestionABMC;
    private javax.swing.JMenu jmListados;
    private javax.swing.JMenu jmLoginsalir;
    private javax.swing.JMenu jmVentas;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiGestionVentas;
    private javax.swing.JMenuItem jmiListado1;
    private javax.swing.JMenuItem jmiListado2;
    private javax.swing.JMenuItem jmiListado3;
    private javax.swing.JMenuItem jmiListado4;
    private javax.swing.JMenuItem jmiLogin;
    private javax.swing.JMenuItem jmiProductos;
    private javax.swing.JMenuItem jmiSalir;
    // End of variables declaration//GEN-END:variables

        // permite el bloqueo o habilitacion de los Jmenu
    public void editarObloquearMenues(boolean txt1, boolean txt2, boolean txt3, boolean txt4) {

        if (txt1) {
            jmGestionABMC.setEnabled(true);
        } else {
            jmGestionABMC.setEnabled(false);
        }
        if (txt2) {
            jmVentas.setEnabled(true);
        } else {
            jmVentas.setEnabled(false);
        }
        if (txt3) {
            jmListados.setEnabled(true);
        } else {
            jmListados.setEnabled(false);
        }
        if (txt4) {
            jmiLogin.setEnabled(true);
        } else {
            jmiLogin.setEnabled(false);
        }
       

    }


}
